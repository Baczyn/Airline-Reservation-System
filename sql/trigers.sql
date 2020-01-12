CREATE OR REPLACE FUNCTION nick_zajety() RETURNS TRIGGER AS $$
    BEGIN
        IF EXISTS(SELECT 1 FROM uzytkownik WHERE nick = New.nick) THEN

            RETURN NULL;
        ELSE
            RETURN NEW;
        END IF;
    END;
$$ LANGUAGE 'plpgsql';

CREATE TRIGGER nick_valid BEFORE INSERT ON uzytkownik FOR EACH ROW EXECUTE PROCEDURE nick_zajety();

CREATE OR REPLACE FUNCTION dodajLinia() RETURNS TRIGGER AS $$
    BEGIN
        NEW.nazwa := lower(NEW.nazwa);
        NEW.nazwa := initcap(NEW.nazwa);
        IF EXISTS(SELECT 1 FROM linia WHERE nazwa = New.nazwa) THEN

            RETURN NULL;
        ELSE
            RETURN NEW;
        END IF;
    END;
$$ LANGUAGE 'plpgsql';


CREATE TRIGGER linia_valid BEFORE INSERT ON linia FOR EACH ROW EXECUTE PROCEDURE dodajLinia();












CREATE OR REPLACE FUNCTION dodajLotnisko() RETURNS TRIGGER AS $$
    BEGIN
        NEW.nazwa := lower(NEW.nazwa);
        NEW.nazwa := initcap(NEW.nazwa);
        IF EXISTS(SELECT 1 FROM lotnisko WHERE nazwa = New.nazwa) THEN

            RETURN NULL;
        ELSE
            RETURN NEW;
        END IF;
    END;
$$ LANGUAGE 'plpgsql';


CREATE TRIGGER lotnisko_valid BEFORE INSERT ON lotnisko FOR EACH ROW EXECUTE PROCEDURE dodajLotnisko();
    
    







CREATE OR REPLACE FUNCTION dodajPax() RETURNS TRIGGER AS $$
    BEGIN
        NEW.imie := lower(NEW.imie);
        NEW.imie := initcap(NEW.imie);
        NEW.nazwisko := lower(NEW.nazwisko);
        NEW.nazwisko := initcap(NEW.nazwisko);
        NEW.kraj := lower(NEW.kraj);
        NEW.kraj := initcap(NEW.kraj);
        NEW.miasto := lower(NEW.miasto);
        NEW.miasto := initcap(NEW.miasto);
        NEW.ulica := lower(NEW.ulica);
        NEW.ulica := initcap(NEW.ulica);
        RETURN NEW;

    END;
$$ LANGUAGE 'plpgsql';


CREATE TRIGGER pax_valid BEFORE INSERT ON pasazer_dane FOR EACH ROW EXECUTE PROCEDURE dodajPax();
    
    