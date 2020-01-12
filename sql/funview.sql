
CREATE OR REPLACE FUNCTION dostepneMiejsca(id_rezerw int)
RETURNS TABLE(lok VARCHAR) AS
$$
BEGIN
    RETURN QUERY
    select lokalizacja from miejsce where id_samolot=(select lot.id_samolot FROM lot JOIN rezerwacja r
    Using(id_lot) Where r.id_rezerwacja =id_rezerw) EXCEPT
    select lokalizacja from odprawa JOIN rezerwacja USING(id_rezerwacja) JOIN lot USING(id_lot) where id_samolot=(select lot.id_samolot FROM lot JOIN rezerwacja r
    Using(id_lot) Where r.id_rezerwacja =id_rezerw);
END; 
$$

LANGUAGE 'plpgsql';

CREATE OR REPLACE FUNCTION ilosc_wolnych(lot_id int)
RETURNS INTEGER AS
$$
DECLARE
  _ilosc_rezerw INTEGER := 0;
  _ilosc INTEGER := 0;
BEGIN
        _ilosc_rezerw := (select count(*) from rezerwacja where id_lot=lot_id);
         _ilosc:= (select ilosc_miejsc from samolot s JOIN lot USING(id_samolot) Where id_lot=lot_id);

        RETURN _ilosc - _ilosc_rezerw;

END; 
$$
LANGUAGE 'plpgsql';



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
    _idlinia := (SELECT COUNT(*) from linia);
    INSERT INTO linia(id_linia,nazwa) VALUES (_idlinia+1,nowaNazwa) RETURNING id_linia INTO liniaGood;
    IF liniaGood > 0 THEN
        liniaGood:=1;
    END IF;
    
    _idsamo := (SELECT COUNT(*) from samolot);
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



CREATE OR REPLACE FUNCTION dodajLot(NazwaLini VARCHAR(20),id_sam int,newSkad VARCHAR(20),newDokad VARCHAR(20),newData DATE,godz time,newCzas FLOAT,newCena int)
RETURNS void AS
$$
DECLARE
  _idlot INTEGER := 0;
  _idskad INTEGER := 0;
  _iddokad INTEGER := 0;

BEGIN
     _iddokad := (select id_lotnisko from lotnisko where  nazwa=newDokad);
     _idskad := (select id_lotnisko from lotnisko where  nazwa=newSkad);
    _idlot := (SELECT COUNT(*) from lot);


    INSERT INTO lot(id_lot , id_samolot ,cel , skad , czas , data_lotu  , godz_odlotu,cena)VALUES
                   (_idlot+1,id_sam,_iddokad,_idskad,newCzas,newData,godz,newCena);

END; 
$$
LANGUAGE 'plpgsql';



CREATE VIEW szukaj AS
SELECT DISTINCT lo1.nazwa AS Skad, lo1.miasto as miasto_z,lo2.nazwa as Do, lo2.miasto as miasto_do,lot.data_lotu,lot.godz_odlotu, linia.nazwa as Linia, lot.id_lot, lot.cena
    FROM lotnisko lo1
    JOIN lot ON lo1.id_lotnisko=lot.skad 
    JOIN lotnisko lo2 ON lo2.id_lotnisko=lot.cel
    JOIN samolot USING(id_samolot)
    JOIN linia USING(id_linia)
    WHERE data_lotu>=now();





CREATE VIEW mojeRezerw AS
    SELECT DISTINCT r.id_rezerwacja,p.nick, pd.imie, pd.nazwisko,l1.nazwa AS z,l2.nazwa AS do,lot.data_lotu,lot.godz_odlotu, CASE WHEN true THEN lot.cena*(100-r.znizka)*0.01 END as cena_konc ,linia.nazwa FROM lot JOIN lotnisko l1 ON lot.skad=l1.id_lotnisko JOIN lotnisko l2 ON lot.cel=l2.id_lotnisko JOIN rezerwacja r USING(id_lot) JOIN pasazer p Using(id_pasazer) JOIN pasazer_dane pd USING(id_pasazer)  JOIN samolot s USING(id_samolot) JOIN linia USING(id_linia)  ;

CREATE VIEW mojeRezerwv2 AS
    SELECT DISTINCT r.id_rezerwacja,p.nick, pd.imie, pd.nazwisko,pd.kraj,pd.miasto,lot.id_lot,l1.nazwa AS z,l2.nazwa AS do,lot.data_lotu,lot.godz_odlotu, CASE WHEN true THEN lot.cena*(100-r.znizka)*0.01 END as cena_konc,linia.nazwa,odprawa.lokalizacja FROM lot JOIN lotnisko l1 ON lot.skad=l1.id_lotnisko LEFT JOIN lotnisko l2 ON lot.cel=l2.id_lotnisko LEFT JOIN rezerwacja r USING(id_lot) JOIN pasazer p Using(id_pasazer) JOIN pasazer_dane pd USING(id_pasazer)  JOIN samolot s USING(id_samolot) JOIN linia USING(id_linia) LEFT JOIN odprawa Using(id_rezerwacja);

