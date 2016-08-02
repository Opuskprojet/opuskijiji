DROP TRIGGER IF EXISTS DataInsert ON opusk.annonces_opusk;
DROP TRIGGER IF EXISTS DataUpdate ON opusk.annonces_opusk;

CREATE OR REPLACE FUNCTION f_insert()
  RETURNS TRIGGER AS
$func$

DECLARE multiplicateur integer := 3;
BEGIN

IF (TG_OP = 'INSERT') THEN

		INSERT INTO opusk.annonce (id_annonce, titre_annonce, statut, id_categorie, cip, 
								description, date_creation, date_expiration, prix, id_type)
		VALUES (NEW.id, NEW.titre, NEW.statut, 1, NEW.cip, NEW.description, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP+ multiplicateur* interval '1 months',NEW.prix, 1);
				  
			IF (NEW.categorie = 'Informatique') THEN
				--id_categorie = 2;
				INSERT INTO opusk.annonce_informatique (id_annonce)
				  VALUES (NEW.id);
					
					-- Tests sur les champs pouvant etre vides
					IF (NEW.marque != '') THEN
					UPDATE opusk.annonce_informatique
					SET marque = NEW.marque
					WHERE id_annonce = NEW.id;
					END IF;

				UPDATE opusk.annonce
				SET id_categorie=2
				WHERE id_annonce=NEW.id;
			END IF;

			IF (NEW.categorie = 'Immobilier') THEN
				--id_categorie = 3;
				INSERT INTO opusk.annonce_immobilier (id_annonce)
				  VALUES (NEW.id);

					-- Tests sur les champs pouvant etre vides
					IF (NEW.surface != 0) THEN
					UPDATE opusk.annonce_immobilier
					SET surface = NEW.surface
					WHERE id_annonce = NEW.id;
					END IF;
					
					IF (NEW.jardin != NULL) THEN
					UPDATE opusk.annonce_immobilier
					SET jardin = NEW.jardin
					WHERE id_annonce = NEW.id;
					END IF;

					IF (NEW.pieces != 0) THEN
					UPDATE opusk.annonce_immobilier
					SET nb_pieces = NEW.pieces
					WHERE id_annonce = NEW.id;
					END IF;

				UPDATE opusk.annonce
				SET id_categorie=3
				WHERE id_annonce=NEW.id;
			END IF;

			IF (NEW.categorie = 'Multimedia') THEN 
				--id_categorie = 4;
				INSERT INTO opusk.annonce_multimedia (id_annonce)
				  VALUES (NEW.id);

					-- Tests sur les champs pouvant etre vides
					IF (NEW.etat1 != '') THEN
					UPDATE opusk.annonce_multimedia
					SET etat_multimedia = NEW.etat1
					WHERE id_annonce = NEW.id;
					END IF;
					
				UPDATE opusk.annonce
				SET id_categorie=4
				WHERE id_annonce=NEW.id;
			END IF;

			IF (NEW.categorie = 'Livres') THEN  
				--id_categorie = 5;
				INSERT INTO opusk.annonce_livres (id_annonce)
				  VALUES (NEW.id);

					-- Tests sur les champs pouvant etre vides
					IF (NEW.etat2 != '') THEN
					UPDATE opusk.annonce_livres
					SET etat_livre = NEW.etat2
					WHERE id_annonce = NEW.id;
					END IF;
					
					IF (NEW.auteur != '') THEN
					UPDATE opusk.annonce_livres
					SET auteur = NEW.auteur
					WHERE id_annonce = NEW.id;
					END IF;

					IF (NEW.isbn != '') THEN
					UPDATE opusk.annonce_livres
					SET isbn = NEW.isbn
					WHERE id_annonce = NEW.id;
					END IF;

				UPDATE opusk.annonce
				SET id_categorie=5
				WHERE id_annonce=NEW.id;
			END IF;

			IF (NEW.categorie = 'Maison') THEN
				--id_categorie = 6;
				INSERT INTO opusk.annonce_maison (id_annonce)
				  VALUES (NEW.id);

					-- Tests sur les champs pouvant etre vides
					IF (NEW.etat3 != '') THEN
					UPDATE opusk.annonce_maison
					SET etat_maison = NEW.etat3
					WHERE id_annonce = NEW.id;
					END IF;
					
				UPDATE opusk.annonce
				SET id_categorie=6
				WHERE id_annonce=NEW.id;
			END IF;

				CASE NEW.type_annonce
					WHEN 'Vente' THEN
					UPDATE opusk.annonce
					SET id_type=1
					WHERE id_annonce=NEW.id;
					
					WHEN 'Don' THEN
					UPDATE opusk.annonce
					SET id_type=2
					WHERE id_annonce=NEW.id;
					
					WHEN 'Location' THEN
					UPDATE opusk.annonce
					SET id_type=3
					WHERE id_annonce=NEW.id;

					ELSE
		
				END CASE;	
		
END IF;

IF (TG_OP = 'UPDATE') THEN

			UPDATE opusk.annonce
			SET statut = NEW.statut
			WHERE id_annonce = NEW.id;

			IF (NEW.categorie = 'Informatique') THEN
				--id_categorie = 2;
					
					-- Tests sur les champs pouvant etre vides
					IF (OLD.marque != NEW.marque) THEN
					UPDATE opusk.annonce_informatique
					SET marque = NEW.marque
					WHERE id_annonce = NEW.id;
					END IF;

				UPDATE opusk.annonce
				SET id_categorie=2
				WHERE id_annonce=NEW.id;
			END IF;

			IF (NEW.categorie = 'Immobilier') THEN
				--id_categorie = 3;

					-- Tests sur les champs pouvant etre vides
					IF (OLD.surface != NEW.surface) THEN
					UPDATE opusk.annonce_immobilier
					SET surface = NEW.surface
					WHERE id_annonce = NEW.id;
					END IF;
					
					IF (OLD.jardin != NEW.jardin) THEN
					UPDATE opusk.annonce_immobilier
					SET jardin = NEW.jardin
					WHERE id_annonce = NEW.id;
					END IF;

					IF (OLD.pieces != NEW.pieces) THEN
					UPDATE opusk.annonce_immobilier
					SET nb_pieces = NEW.pieces
					WHERE id_annonce = NEW.id;
					END IF;

				UPDATE opusk.annonce
				SET id_categorie=3
				WHERE id_annonce=NEW.id;
			END IF;

			IF (NEW.categorie = 'Multimedia') THEN 
				--id_categorie = 4;

					-- Tests sur les champs pouvant etre vides
					IF (OLD.etat1 != NEW.etat1) THEN
					UPDATE opusk.annonce_multimedia
					SET etat_multimedia = NEW.etat1
					WHERE id_annonce = NEW.id;
					END IF;
					
				UPDATE opusk.annonce
				SET id_categorie=4
				WHERE id_annonce=NEW.id;
			END IF;

			IF (NEW.categorie = 'Livres') THEN  
				--id_categorie = 5;

					-- Tests sur les champs pouvant etre vides
					IF (NEW.etat2 != OLD.etat2) THEN
					UPDATE opusk.annonce_livres
					SET etat_livre = NEW.etat2
					WHERE id_annonce = NEW.id;
					END IF;
					
					IF (NEW.auteur != OLD.auteur) THEN
					UPDATE opusk.annonce_livres
					SET auteur = NEW.auteur
					WHERE id_annonce = NEW.id;
					END IF;

					IF (NEW.isbn != OLD.isbn) THEN
					UPDATE opusk.annonce_livres
					SET isbn = NEW.isbn
					WHERE id_annonce = NEW.id;
					END IF;

				UPDATE opusk.annonce
				SET id_categorie=5
				WHERE id_annonce=NEW.id;
			END IF;

			IF (NEW.categorie = 'Maison') THEN
				--id_categorie = 6;

					-- Tests sur les champs pouvant etre vides
					IF (NEW.etat3 != OLD.etat3) THEN
					UPDATE opusk.annonce_maison
					SET etat_maison = NEW.etat3
					WHERE id_annonce = NEW.id;
					END IF;
					
				UPDATE opusk.annonce
				SET id_categorie=6
				WHERE id_annonce=NEW.id;
			END IF;

				CASE NEW.type_annonce
					WHEN 'Vente' THEN
					UPDATE opusk.annonce
					SET id_type=1
					WHERE id_annonce=NEW.id;
					
					WHEN 'Don' THEN
					UPDATE opusk.annonce
					SET id_type=2
					WHERE id_annonce=NEW.id;
					
					WHEN 'Location' THEN
					UPDATE opusk.annonce
					SET id_type=3
					WHERE id_annonce=NEW.id;

					ELSE
		
				END CASE;
END IF;
	
	RETURN NEW;

END;

$func$ LANGUAGE plpgsql;

CREATE TRIGGER DataInsert INSTEAD OF INSERT ON opusk.annonces_opusk
    FOR EACH ROW EXECUTE PROCEDURE f_insert();

CREATE TRIGGER DataUpdate INSTEAD OF UPDATE ON opusk.annonces_opusk
    FOR EACH ROW EXECUTE PROCEDURE f_insert();
