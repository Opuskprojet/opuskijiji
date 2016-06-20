package ca.uSherbrooke.gegi.opusK.shared.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.Object;
import java.sql.Date;

/**
 * Created by tanguy on 16/06/16.
 */


@Entity
@Table(name = "annonces_opusk", schema = "opusk", catalog = "opus")
public class Annonces_opusk {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String cip;
    private String titre;
    private String description;
    private Date dateCreation;
    private Date dateExpiration;
    private String typeAnnonce;
    private String categorie;
    private String marque;
    private double surface;
    private String etat1;
    private String isbn;
    private String auteur;
    private String etat2;
    private String etat3;
    private String chemin;
    private String nom;
    private String prix;
    private String pieces;
    private boolean jardin;


    @Column(name = "id")
    public Serializable getId() {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
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
    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }


    @Column(name = "date_expiration")
    public Date getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(Date dateExpiration) {
        this.dateExpiration = dateExpiration;
    }


    @Column(name = "type_annonce")
    public String getTypeAnnonce() {
        return typeAnnonce;
    }

    public void setTypeAnnonce(String typeAnnonce) {
        this.typeAnnonce = typeAnnonce;
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
    public double getSurface() {
        return surface;
    }

    public void setSurface(double surface) {
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
    public Object getPrix() {
        return prix;
    }

    public void setPrix(String  prix) {
        this.prix = prix;
    }


    @Column(name = "pieces")
    public Object getPieces() {
        return pieces;
    }

    public void setPieces(String pieces) {
        this.pieces = pieces;
    }


    @Column(name = "jardin")
    public Object getJardin() {
        return jardin;
    }

    public void setJardin(boolean jardin) {
        this.jardin = jardin;
    }


}


