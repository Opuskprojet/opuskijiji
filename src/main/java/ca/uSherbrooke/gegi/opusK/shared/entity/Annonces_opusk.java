package ca.uSherbrooke.gegi.opusK.shared.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by tanguy on 16/06/16.
 */


@NamedNativeQueries({

        @NamedNativeQuery(
                name    =   "getVosAnnonces",
                query   =   "SELECT * FROM opusk.annonces_opusk WHERE annonces_opusk.cip = ?",
                resultClass= Annonces_opusk.class
        ),
        @NamedNativeQuery(
                name    =   "getSearchResult",
                query   =   "SELECT * FROM opusk.annonces_opusk WHERE annonces_opusk.categorie ILIKE ? " +
                            " AND annonces_opusk.titre ILIKE ? " +
                            " AND annonces_opusk.statut = ? ",
                resultClass= Annonces_opusk.class
        )
})

@Entity
@Table(name = "annonces_opusk", schema = "opusk")
public class Annonces_opusk  implements Serializable {

    @Id
    @SequenceGenerator(name = "opusk.annonce_id_annonce_seq", sequenceName = "opusk.annonce_id_annonce_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "opusk.annonce_id_annonce_seq")
    private Integer id;

    private String cip;
    private String titre;
    private String description;
    private Date date_Creation;
    private Date date_Expiration;
    private String type_Annonce;
    private String categorie;
    private String marque;
    private Double surface;
    private String etat1;
    private String isbn;
    private String auteur;
    private String etat2;
    private String etat3;
    private String chemin;
    private String nom;
    private Double prix;
    private Integer pieces;
    private boolean jardin;
    private boolean statut;


    @Column(name = "id")
    public Integer getId() {
        return id;
    }


    @Column(name = "cip")
    public String getCip() {
        return cip;
    }

    public void setCip(String cip) {
        this.cip = cip;
    }


    @Column(name = "titre")
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }


    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Column(name = "date_creation")
    public Date getDate_Creation() {
        return date_Creation;
    }

    public void setDate_Creation(Date date_Creation) {
        this.date_Creation = date_Creation;
    }


    @Column(name = "date_expiration")
    public Date getDate_Expiration() {
        return date_Expiration;
    }

    public void setDate_Expiration(Date date_Expiration) {
        this.date_Expiration = date_Expiration;
    }


    @Column(name = "type_annonce")
    public String getType_Annonce() {
        return type_Annonce;
    }

    public void setType_Annonce(String type_Annonce) {
        this.type_Annonce = type_Annonce;
    }


    @Column(name = "categorie")
    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }


    @Column(name = "marque")
    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }


    @Column(name = "surface")
    public Double getSurface() {
        return surface;
    }

    public void setSurface(Double surface) {
        this.surface = surface;
    }


    @Column(name = "etat1")
    public String getEtat1() {
        return etat1;
    }

    public void setEtat1(String etat1) {
        this.etat1 = etat1;
    }


    @Column(name = "isbn")
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }


    @Column(name = "auteur")
    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }


    @Column(name = "etat2")
    public String getEtat2() {
        return etat2;
    }

    public void setEtat2(String etat2) {
        this.etat2 = etat2;
    }


    @Column(name = "etat3")
    public String getEtat3() {
        return etat3;
    }

    public void setEtat3(String etat3) {
        this.etat3 = etat3;
    }


    @Column(name = "chemin")
    public String getChemin() {
        return chemin;
    }

    public void setChemin(String chemin) {
        this.chemin = chemin;
    }


    @Column(name = "nom")
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    @Column(name = "prix")
    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double  prix) {
        this.prix = prix;
    }


    @Column(name = "pieces")
    public Integer getPieces() {
        return pieces;
    }

    public void setPieces(Integer pieces) {
        this.pieces = pieces;
    }


    @Column(name = "jardin")
    public boolean getJardin() {
        return jardin;
    }

    public void setJardin(boolean jardin) {
        this.jardin = jardin;
    }

    @Column(name = "statut")
    public boolean getStatut() {
        return statut;
    }

    public void setStatut(boolean statut) {
        this.statut = statut;
    }


    @Override
    public boolean equals(Object obj) {
        if(obj != null){
            if(obj instanceof Annonces_opusk){
                return ((Annonces_opusk)obj).getId().equals(id);
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }
}


