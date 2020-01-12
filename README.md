# Airline-Reservation-System
Projekt zrealizoway w ramach przedmiotu Bazy Danych I.
##Zawartość
1.	Folder src: Pliki źródłowe 
2.	Folder docs: Dokumentacja wygenerowana przez javadocs 
3.  Folder sql: pliki .sql tworzące tabele itp.
4.  Dokumentacja_Samoloty.pdf: Opis projektu

## Instalacja
1. Połącz się z serwerem:
ssh -L 5433:localhost:5432 7nazwisko@pascal.fis.agh.edu.pl
2. W folderz src skompiluj pliki .java:
javac -cp .:./postgresql-42.2.9.jar:DateChooser.jar  MainWindow.java
3. Uruchom program:
java -cp .:./postgresql-42.2.9.jar:DateChooser.jar  MainWindow

