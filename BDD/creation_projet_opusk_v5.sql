--------------------------------------------------------------------------
--------------------------------------------------------------------------
---        Script Postgre pour création base de données opusKijiji     ---
---                                  v.2.0                             ---
---           Par Pierre-Frédérick DENYS (denp2803) le 08/06/2016      --- 
--------------------------------------------------------------------------
--------------------------------------------------------------------------

DROP SCHEMA opusk CASCADE; 
------------------------------------------------------------
-- Création du schéma contenant les tables de l'application
------------------------------------------------------------
CREATE SCHEMA opusk; 

------------------------------------------------------------
-- Table: annonce
------------------------------------------------------------
CREATE TABLE opusk.annonce(
	id_Annonce      SERIAL NOT NULL ,
	cip             VARCHAR (25)  ,
	titre_annonce   VARCHAR (25) NOT NULL ,
	description     VARCHAR (2000)   ,
	date_creation   DATE ,
	date_expiration DATE ,
	prix            DOUBLE PRECISION   ,
	statut          BOOL  NOT NULL ,
	id_type         INT   ,
	id_categorie    INT  NOT NULL ,
	CONSTRAINT prk_constraint_annonce PRIMARY KEY (id_Annonce)
)WITHOUT OIDS;

------------------------------------------------------------
-- Table: type_annonce
------------------------------------------------------------
CREATE TABLE opusk.type_annonce(
	id_type  INT NOT NULL,
	nom_type VARCHAR (25) NOT NULL,
	CONSTRAINT prk_constraint_type_annonce PRIMARY KEY (id_type)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: categorie
------------------------------------------------------------
CREATE TABLE opusk.categorie(
	id_categorie       INT NOT NULL ,
	nom_categorie      VARCHAR (25) NOT NULL ,
	CONSTRAINT prk_constraint_categorie PRIMARY KEY (id_categorie)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: annonce_informatique
------------------------------------------------------------
CREATE TABLE opusk.annonce_informatique(
	marque     VARCHAR (25) NOT NULL ,
	id_Annonce INT  NOT NULL ,
	CONSTRAINT prk_constraint_annonce_informatique PRIMARY KEY (id_Annonce)
)WITHOUT OIDS;




------------------------------------------------------------
-- Table: annonce_immobilier
------------------------------------------------------------
CREATE TABLE opusk.annonce_immobilier(
	nb_pieces  INT   ,
	jardin     BOOL   ,
	surface    DOUBLE PRECISION   ,
	id_Annonce INT  NOT NULL ,
	CONSTRAINT prk_constraint_annonce_immobilier PRIMARY KEY (id_Annonce)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: annonce_livres
------------------------------------------------------------
CREATE TABLE opusk.annonce_livres(
	ISBN       VARCHAR (25)  ,
	auteur     VARCHAR (25)  ,
	etat_livre VARCHAR (25)  ,
	id_Annonce INT  NOT NULL ,
	CONSTRAINT prk_constraint_annonce_livres PRIMARY KEY (id_Annonce)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: photo
------------------------------------------------------------
CREATE TABLE opusk.photo(
	id_photo     SERIAL NOT NULL ,
	nom_photo    VARCHAR (25)  ,
	chemin_photo VARCHAR (100)  ,
	id_Annonce   INT   ,
	CONSTRAINT prk_constraint_photo PRIMARY KEY (id_photo)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: annonce_multimedia
------------------------------------------------------------
CREATE TABLE opusk.annonce_multimedia(
	etat_multimedia VARCHAR (25) NOT NULL ,
	id_Annonce      INT  NOT NULL ,
	CONSTRAINT prk_constraint_annonce_multimedia PRIMARY KEY (id_Annonce)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: annonce_maison
------------------------------------------------------------
CREATE TABLE opusk.annonce_maison(
	etat_maison VARCHAR (25) NOT NULL ,
	id_Annonce  INT  NOT NULL ,
	CONSTRAINT prk_constraint_annonce_maison PRIMARY KEY (id_Annonce)
)WITHOUT OIDS;

------------------------------------------------------------
-- Contraintes sur les tables 
------------------------------------------------------------

ALTER TABLE opusk.annonce ADD CONSTRAINT FK_annonce_id_type FOREIGN KEY (id_type) REFERENCES opusk.type_annonce(id_type);
ALTER TABLE opusk.annonce ADD CONSTRAINT FK_annonce_id_categorie FOREIGN KEY (id_categorie) REFERENCES opusk.categorie(id_categorie);
ALTER TABLE opusk.annonce_informatique ADD CONSTRAINT FK_annonce_informatique_id_Annonce FOREIGN KEY (id_Annonce) REFERENCES opusk.annonce(id_Annonce);
ALTER TABLE opusk.annonce_immobilier ADD CONSTRAINT FK_annonce_immobilier_id_Annonce FOREIGN KEY (id_Annonce) REFERENCES opusk.annonce(id_Annonce);
ALTER TABLE opusk.annonce_livres ADD CONSTRAINT FK_annonce_livres_id_Annonce FOREIGN KEY (id_Annonce) REFERENCES opusk.annonce(id_Annonce);
ALTER TABLE opusk.photo ADD CONSTRAINT FK_photo_id_Annonce FOREIGN KEY (id_Annonce) REFERENCES opusk.annonce(id_Annonce);
ALTER TABLE opusk.annonce_multimedia ADD CONSTRAINT FK_annonce_multimedia_id_Annonce FOREIGN KEY (id_Annonce) REFERENCES opusk.annonce(id_Annonce);
ALTER TABLE opusk.annonce_maison ADD CONSTRAINT FK_annonce_maison_id_Annonce FOREIGN KEY (id_Annonce) REFERENCES opusk.annonce(id_Annonce);


------------------------------------------------------------
-- Création de la vue permettant d'afficher l'ensemble des annonces
------------------------------------------------------------
CREATE OR REPLACE VIEW opusk.Annonces_opusk AS
SELECT a.id_annonce as id, a.cip as CIP, a.titre_annonce as TITRE, a.description as DESCRIPTION, 
a.date_creation as DATE_CREATION, a.date_expiration as DATE_EXPIRATION, 
a.prix as PRIX, a.statut as STATUT, c.nom_categorie as CATEGORIE,t.nom_type as TYPE_ANNONCE,
p.chemin_photo as CHEMIN, p.nom_photo as NOM,
info.marque as MARQUE, 
immo.nb_pieces as PIECES, immo.jardin as JARDIN, immo.surface as SURFACE,
media.etat_multimedia as ETAT1, 
livre.ISBN as ISBN, livre.auteur as AUTEUR, livre.etat_livre as ETAT2, 
maison.etat_maison as ETAT3

FROM opusk.annonce a
NATURAL JOIN opusk.categorie c
NATURAL JOIN opusk.type_annonce t
LEFT OUTER JOIN opusk.photo p
ON p.id_Annonce = a.id_Annonce
LEFT OUTER JOIN opusk.annonce_informatique info
ON info.id_Annonce = a.id_Annonce
LEFT OUTER JOIN opusk.annonce_immobilier immo
ON immo.id_Annonce = a.id_Annonce
LEFT OUTER JOIN opusk.annonce_multimedia media
ON media.id_Annonce = a.id_Annonce
LEFT OUTER JOIN opusk.annonce_livres livre
ON livre.id_Annonce = a.id_Annonce
LEFT OUTER JOIN opusk.annonce_maison maison
ON livre.id_Annonce = a.id_Annonce;

------------------------------------------------------------
-- Insertion de données dans la vue 
------------------------------------------------------------

INSERT INTO opusk.categorie VALUES (1, 'all');
INSERT INTO opusk.categorie VALUES (2, 'informatique');
INSERT INTO opusk.categorie VALUES (3, 'immobilier');
INSERT INTO opusk.categorie VALUES (4, 'multimedia');
INSERT INTO opusk.categorie VALUES (5, 'livres');
INSERT INTO opusk.categorie VALUES (6, 'maison');

INSERT INTO opusk.type_annonce VALUES (1, 'offre');
INSERT INTO opusk.type_annonce VALUES (2, 'dons');
INSERT INTO opusk.type_annonce VALUES (3, 'vente');

INSERT INTO opusk.annonce VALUES (1, 'denp2803', 'vente étudiant', 'vente tanguy buchier, cause : pas sage', '1996-12-01', '1996-12-01', 20.00 , 'true', 1, 2);
INSERT INTO opusk.annonce_informatique VALUES ('asus', 1);
INSERT INTO opusk.photo VALUES (1, 'photo1', 'c:/program_files/', 1);


INSERT INTO opusk.annonce VALUES (2, 'buct5623', 'vente étudiant2', 'vente tanguy buchière, cause : vilain', '1996-12-12', '1996-12-13', 21.00 , 'false', 2, 4);
INSERT INTO opusk.annonce_multimedia VALUES ('bon état', 2);
INSERT INTO opusk.photo VALUES (2, 'photo2', 'c:/program_files/', 2);


------------------------------------------------------------
-- Affichage en console de la vue 
------------------------------------------------------------

SELECT * FROM opusk.Annonces_opusk;

REASSIGN OWNED BY superopus TO opus;
