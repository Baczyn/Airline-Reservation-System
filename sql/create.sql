create table linia(id_linia int,nazwa varchar(20));
create table lotnisko(id_lotnisko int,nazwa varchar(20),kraj varchar(20),miasto varchar(20),ulica varchar(20));
create table samolot(id_samolot int,id_linia int,ilosc_miejsc int);
create table miejsce(lokalizacja varchar(3),id_samolot int);
create table odprawa(id_odprawa int,cena_miejsce int, data_odprawa date,id_rezerwacja int,lokalizacja varchar(3) );
create table rezerwacja(id_rezerwacja int,id_lot int, id_pasazer int, data_rezerw date,znizka int);
create table pasazer(id_pasazer int,nick varchar(20));
create table pasazer_dane(id_pasazer int,imie varchar(20),nazwisko varchar(20),kraj varchar(20),miasto varchar(20),ulica varchar(20),nr_domu int,plec varchar(15));
create table uzytkownik(nick varchar(20),haslo varchar(20),mail varchar(20),typ varchar(10));
create table lot(id_lot int,id_samolot int,cel int,skad int,czas float,data_lotu date,godz_odlotu time,cena int);



alter table linia ADD PRIMARY KEY (id_linia);
alter table lotnisko ADD PRIMARY KEY(id_lotnisko);
alter table samolot ADD PRIMARY KEY(id_samolot);
alter table miejsce ADD PRIMARY KEY(lokalizacja,id_samolot);
alter table odprawa ADD PRIMARY KEY(id_odprawa);
alter table rezerwacja ADD PRIMARY KEY(id_rezerwacja);;
alter table pasazer add PRIMARY KEY(id_pasazer);
alter  table uzytkownik add PRIMARY KEY(nick);
alter table lot add PRIMARY KEY(id_lot);

alter table samolot add FOREIGN KEY(id_linia) references linia(id_linia);
alter table miejsce ADD FOREIGN KEY(id_samolot) references samolot(id_samolot);--
alter table rezerwacja ADD FOREIGN KEY(id_lot) references lot(id_lot);
alter table rezerwacja add FOREIGN KEY(id_pasazer) references pasazer(id_pasazer);
alter table pasazer add FOREIGN KEY(nick) references uzytkownik(nick);
alter table pasazer_dane add FOREIGN KEY(id_pasazer) references pasazer(id_pasazer);
alter table lot add FOREIGN KEY(cel) references lotnisko(id_lotnisko);
alter table lot add FOREIGN KEY(skad) references lotnisko(id_lotnisko);
alter table lot add FOREIGN KEY(id_samolot) references samolot(id_samolot);
alter table odprawa add FOREIGN KEY(id_rezerwacja) references rezerwacja(id_rezerwacja);

insert into linia(id_linia,nazwa) values
(1,'Lot'),
(2,'Ryanair');

insert into samolot(id_samolot,id_linia,ilosc_miejsc) values
(1,1,5),
(2,1,5),
(3,2,2),
(4,2,2);

insert into miejsce(lokalizacja,id_samolot) values
('1A',1),
('1B',1),
('1C',1),
('1D',1),
('1E',1),

('1A',2),
('1B',2),
('1C',2),
('1D',2),
('1E',2),

('1A',3),
('1B',3),

('1A',4),
('1B',4);

insert into lotnisko(id_lotnisko,nazwa,kraj,miasto,ulica) values
(1,'Krakow-Balice','Polska','Krakow','Medweckiego'),
(2,'Chopina','Polska','Warszawa','Zwirki i Wigory'),
(3,'Barcelona-Girona','Hiszpania','Girona','Vilobi dOnyar');






insert into lot(id_lot,id_samolot ,cel ,skad ,czas ,data_lotu ,godz_odlotu ,cena ) VALUES
(1,1,1,3,1.5,'07-02-2020','11:00:00',200);

INsert into uzytkownik(nick,haslo,mail,typ)VALUES ('admin','admin','admin','admin');
