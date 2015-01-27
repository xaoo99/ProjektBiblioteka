CREATE TABLE GATUNEK_nie_wywalaj_prosze(
  id_g int PRIMARY KEY,
  nazwa VARCHAR2(50) NOT NULL
);
CREATE SEQUENCE seq_gatunek;
CREATE OR REPLACE TRIGGER seq_gatunek 
BEFORE INSERT ON GATUNEK_nie_wywalaj_prosze 
FOR EACH ROW
WHEN (new.id_g IS NULL)
BEGIN
  SELECT seq_gatunek.NEXTVAL
  INTO   :new.id_g
  FROM   dual;
END;
/
INSERT INTO GATUNEK_nie_wywalaj_prosze(nazwa) VALUES('Gatunek 1 z bazy'), ('Gatunek 2 z bazy'), ('Gatunek 3 z bazy');

CREATE TABLE WYDAWNICTWO_nie_wywalaj_prosze(
  id_w int PRIMARY KEY,
  nazwa VARCHAR2(50) NOT NULL,
  adres VARCHAR2(200) NOT NULL
);
CREATE SEQUENCE seq_wydawnictwo;
CREATE OR REPLACE TRIGGER seq_wydawnictwo 
BEFORE INSERT ON WYDAWNICTWO_nie_wywalaj_prosze 
FOR EACH ROW
WHEN (new.id_w IS NULL)
BEGIN
  SELECT seq_wydawnictwo.NEXTVAL
  INTO   :new.id_w
  FROM   dual;
END;
/
INSERT INTO WYDAWNICTWO_nie_wywalaj_prosze(nazwa, adres) VALUES('Wydawnictwo 1 z bazy', 'Adres w1');

--AUTOR_nie_wywalaj_prosze
CREATE TABLE AUTOR_nie_wywalaj_prosze(
  id_a int PRIMARY KEY,
  imie VARCHAR2(30) NOT NULL,
  nazwisko VARCHAR2(50) NOT NULL
);
CREATE SEQUENCE seq_autor;
CREATE OR REPLACE TRIGGER seq_autor
BEFORE INSERT ON AUTOR_nie_wywalaj_prosze 
FOR EACH ROW
WHEN (new.id_a IS NULL)
BEGIN
  SELECT seq_autor.NEXTVAL
  INTO   :new.id_a
  FROM   dual;
END;

--KSIAZKA_nie_wywalaj_prosze
CREATE TABLE KSIAZKA_nie_wywalaj_prosze(
  id_k int PRIMARY KEY,
  tytul VARCHAR2(50) NOT NULL,
  isbn VARCHAR2(20) NOT NULL,
  id_g int NOT NULL,
  id_a int NOT NULL,
  id_w int NOT NULL,
  CONSTRAINT ksiazka_FK_gat FOREIGN KEY (id_g) REFERENCES GATUNEK_nie_wywalaj_prosze(id_g),
  CONSTRAINT ksiazka_FK_aut FOREIGN KEY (id_a) REFERENCES AUTOR_nie_wywalaj_prosze(id_a),
  CONSTRAINT ksiazka_FK_wyd FOREIGN KEY (id_w) REFERENCES WYDAWNICTWO_nie_wywalaj_prosze(id_w)
);
CREATE SEQUENCE seq_ksiazka;
CREATE OR REPLACE TRIGGER seq_ksiazka 
BEFORE INSERT ON KSIAZKA_nie_wywalaj_prosze 
FOR EACH ROW
WHEN (new.id_k IS NULL)
BEGIN
  SELECT seq_ksiazka.NEXTVAL
  INTO   :new.id_k
  FROM   dual;
END;

--EGZEMPLARZ_nie_wywalaj_prosze
CREATE TABLE EGZEMPLARZ_nie_wywalaj_prosze(
  id_e int PRIMARY KEY,
  id_k int NOT NULL,
  CONSTRAINT egz_FK FOREIGN KEY(id_k) REFERENCES KSIAZKA_nie_wywalaj_prosze(id_k)
);
CREATE SEQUENCE seq_egzemplarz;
CREATE OR REPLACE TRIGGER seq_egzemplarz 
BEFORE INSERT ON EGZEMPLARZ_nie_wywalaj_prosze 
FOR EACH ROW
WHEN (new.id_e IS NULL)
BEGIN
  SELECT seq_egzemplarz.NEXTVAL
  INTO   :new.id_e
  FROM   dual;
END;

COMMIT;