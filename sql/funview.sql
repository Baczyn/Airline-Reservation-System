/*Funckcja zwraca wszystkie dostępne miejsca (lokalizacje)
 w samolocie, który należy do zarezewowanego przez pasażera lotu*/
CREATE OR REPLACE FUNCTION dostepneMiejsca(id_rezerw int)
RETURNS TABLE(lok VARCHAR) AS
$$
BEGIN
    RETURN QUERY
    SELECT lokalizacja FROM miejsce WHERE id_samolot=(SELECT lot.id_samolot FROM lot JOIN rezerwacja r
    USING(id_lot) WHERE r.id_rezerwacja =id_rezerw) EXCEPT
    SELECT lokalizacja FROM odprawa JOIN rezerwacja USING(id_rezerwacja) JOIN lot USING(id_lot) WHERE id_samolot=(SELECT lot.id_samolot FROM lot JOIN rezerwacja r
    USING(id_lot) WHERE r.id_rezerwacja =id_rezerw);
END; 
$$

LANGUAGE 'plpgsql';

/*Funckcja zwraca ilość wolnych miejsc
 w samolocie, który należy do wybranego lotu*/
CREATE OR REPLACE FUNCTION ilosc_wolnych(lot_id int)
RETURNS INTEGER AS
$$
DECLARE
  _ilosc_rezerw INTEGER := 0;
  _ilosc INTEGER := 0;
BEGIN
        _ilosc_rezerw := (SELECT count(*) FROM rezerwacja WHERE id_lot=lot_id);
         _ilosc:= (SELECT ilosc_miejsc FROM samolot s JOIN lot USING(id_samolot) WHERE id_lot=lot_id);

        RETURN _ilosc - _ilosc_rezerw;

END; 
$$
LANGUAGE 'plpgsql';


/*Funckcja dodaje nową Linie i dodaje do niej samolotem o określonej ilości miejsc.
Funkcja usupełnia również lokalizacje miejsc w samolocie (1A,1B itp)*/
CREATE OR REPLACE FUNCTION dodajLinieSamolot(nowaNazwa VARCHAR(20),nowaIlosc int)
RETURNS INTEGER AS
$$
DECLARE
  _idlinia INTEGER := 0;
  _idsamo INTEGER := 0;
  j INTEGER := 1;
  _temp VARCHAR(1) :='A';
  liniaGood INTEGER := 0;

BEGIN
    _idlinia := (SELECT COUNT(*) FROM linia);
    INSERT INTO linia(id_linia,nazwa) VALUES (_idlinia+1,nowaNazwa) RETURNING id_linia INTO liniaGood;
    IF liniaGood > 0 THEN
        liniaGood:=1;
    END IF;
    
    _idsamo := (SELECT COUNT(*) FROM samolot);
    INSERT INTO samolot(id_samolot,id_linia,ilosc_miejsc) VALUES (_idsamo+1,_idlinia+1,nowaIlosc);

    FOR i IN 1..nowaIlosc LOOP
        
        IF MOD(i,4) = 1 THEN 
            _temp :='A';
        ELSIF MOD(i,4) = 2 THEN 
            _temp :='B';
        ELSIF MOD(i,4) = 3 THEN 
            _temp :='C';
        ELSIF MOD(i,4) = 0 THEN 
            _temp :='D';
        END IF;
                                  
        INSERT INTO miejsce(lokalizacja,id_samolot) VALUES (CONCAT(CAST(j AS VARCHAR(1)),_temp),_idsamo+1);

        IF MOD(i,4) = 0 THEN 
            j:=j+1;
        END IF;

    END LOOP;
    
RETURN liniaGOOD;

END; 
$$
LANGUAGE 'plpgsql';


/*Funckcja dodaje nowy lot o zadanych parametrach*/
CREATE OR REPLACE FUNCTION dodajLot(NazwaLini VARCHAR(20),id_sam int,newSkad VARCHAR(20),newDokad VARCHAR(20),newData DATE,godz time,newCzas FLOAT,newCena int)
RETURNS void AS
$$
DECLARE
  _idlot INTEGER := 0;
  _idskad INTEGER := 0;
  _iddokad INTEGER := 0;

BEGIN
     _iddokad := (SELECT id_lotnisko FROM lotnisko WHERE  nazwa=newDokad);
     _idskad := (SELECT id_lotnisko FROM lotnisko WHERE  nazwa=newSkad);
    _idlot := (SELECT COUNT(*) FROM lot);


    INSERT INTO lot(id_lot , id_samolot ,cel , skad , czas , data_lotu  , godz_odlotu,cena)VALUES
                   (_idlot+1,id_sam,_iddokad,_idskad,newCzas,newData,godz,newCena);

END; 
$$
LANGUAGE 'plpgsql';


/*Widok szukaj pozwala wyświetlić wszystkie loty jakie są w bazie*/
CREATE VIEW szukaj AS
SELECT DISTINCT lo1.nazwa AS Skad, lo1.miasto as miasto_z,lo2.nazwa as Do, lo2.miasto as miasto_do,lot.data_lotu,lot.godz_odlotu, linia.nazwa as Linia, lot.id_lot, lot.cena
    FROM lotnisko lo1
    JOIN lot ON lo1.id_lotnisko=lot.skad 
    JOIN lotnisko lo2 ON lo2.id_lotnisko=lot.cel
    JOIN samolot USING(id_samolot)
    JOIN linia USING(id_linia)
    WHERE data_lotu>=now();




/*Widok mojeRezerw pozwala wyświetlić wszystkie rezerwacje jakie są w bazie*/
CREATE VIEW mojeRezerw AS
    SELECT DISTINCT r.id_rezerwacja,p.nick, pd.imie, pd.nazwisko,l1.nazwa AS z,l2.nazwa AS do,lot.data_lotu,lot.godz_odlotu, CASE WHEN true THEN lot.cena*(100-r.znizka)*0.01 END as cena_konc ,linia.nazwa FROM lot JOIN lotnisko l1 ON lot.skad=l1.id_lotnisko JOIN lotnisko l2 ON lot.cel=l2.id_lotnisko JOIN rezerwacja r USING(id_lot) JOIN pasazer p USING(id_pasazer) JOIN pasazer_dane pd USING(id_pasazer)  JOIN samolot s USING(id_samolot) JOIN linia USING(id_linia)  ;

/*Widok mojeRezerwv2 pozwala wyświetlić wszystkie rezerwacje jakie są w bazie,
ale z większą ilością informacji, zawiera również info czy pasażer się odprawił, czy nie*/
CREATE VIEW mojeRezerwv2 AS
    SELECT DISTINCT r.id_rezerwacja,p.nick, pd.imie, pd.nazwisko,pd.kraj,pd.miasto,lot.id_lot,l1.nazwa AS z,l2.nazwa AS do,lot.data_lotu,lot.godz_odlotu, CASE WHEN true THEN lot.cena*(100-r.znizka)*0.01 END as cena_konc,linia.nazwa,odprawa.lokalizacja FROM lot JOIN lotnisko l1 ON lot.skad=l1.id_lotnisko LEFT JOIN lotnisko l2 ON lot.cel=l2.id_lotnisko LEFT JOIN rezerwacja r USING(id_lot) JOIN pasazer p USING(id_pasazer) JOIN pasazer_dane pd USING(id_pasazer)  JOIN samolot s USING(id_samolot) JOIN linia USING(id_linia) LEFT JOIN odprawa USING(id_rezerwacja);



/*Funkcja usuwa kolejno odprawy dla danego lotu, rezewacje, oraz lot*/
CREATE OR REPLACE FUNCTION usun_lot(id_l int)
RETURNS INTEGER AS
$$
DECLARE

kursor1 CURSOR FOR SELECT * FROM odprawa JOIN rezerwacja r USING(id_rezerwacja) WHERE id_lot=id_l;
kursor2 CURSOR FOR SELECT * FROM rezerwacja  WHERE id_lot=id_l;

odpr RECORD;
rezerw RECORD;

flag INTEGER:=0;

BEGIN
    OPEN kursor1;
    LOOP
        FETCH kursor1 INTO odpr;
        EXIT WHEN NOT FOUND; 
        DELETE FROM odprawa WHERE odprawa.id_odprawa=odpr.id_odprawa;
    END LOOP;
    CLOSE kursor1;

    OPEN kursor2;
    LOOP
        FETCH kursor2 INTO rezerw;
        EXIT WHEN NOT FOUND; 
        DELETE FROM rezerwacja WHERE rezerwacja.id_rezerwacja=rezerw.id_rezerwacja;
    END LOOP;

    CLOSE kursor2;

    DELETE FROM lot WHERE id_lot=id_l RETURNING id_lot INTO flag;


    RETURN flag;
END; 
$$

LANGUAGE 'plpgsql';

/*Funkcja usuwa kolejno odprawy dla danej rezerwacji, oraz rezerwacje*/
CREATE OR REPLACE FUNCTION usun_rezerwacje(id_r int)
RETURNS INTEGER AS
$$
DECLARE

flag INTEGER:=0;

BEGIN

    DELETE FROM odprawa WHERE odprawa.id_rezerwacja=id_r;
    DELETE FROM rezerwacja WHERE id_rezerwacja=id_r RETURNING id_rezerwacja INTO flag;

    RETURN flag;
END; 
$$

LANGUAGE 'plpgsql';
