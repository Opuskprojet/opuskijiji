package ca.uSherbrooke.gegi.opusK.client.application.home.produit;

import ca.uSherbrooke.gegi.opusK.client.application.home.consultAnnonce.ConsultPageView;
import ca.uSherbrooke.gegi.opusK.shared.entity.Annonces_opusk;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import org.apache.xpath.operations.Bool;
import org.gwtbootstrap3.client.ui.html.Text;

import javax.inject.Inject;

/**
 * Created by tanguy on 02/06/16
 */
public class ProductPageView extends ViewWithUiHandlers<ProductPagePresenter> implements ProductPagePresenter.MyView {


    @UiField
    HTMLPanel detailAnnonce;

    interface Binder extends UiBinder<Widget, ProductPageView> {
    }

    @Inject
    ProductPageView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public void displayProductPage(Annonces_opusk annonces_opusk) {

        String categorie = annonces_opusk.getCategorie();
        detailAnnonce.clear();

        Label titre = new Label();
        titre.setText("Titre : " + annonces_opusk.getTitre());
        //titre.setStyleName("");
        detailAnnonce.add(titre);

        Label categorieItem = new Label();
        categorieItem.setText("Catégorie : " + annonces_opusk.getCategorie());
        detailAnnonce.add(categorieItem);

        Label description = new Label();
        description.setText("Description : " + annonces_opusk.getDescription());
        detailAnnonce.add(description);

        switch (categorie) {
            case "informatique":
                Label marque = new Label();
                marque.setText("Marque : " + annonces_opusk.getMarque());
                detailAnnonce.add(marque);
                break;

            case "multimedia":
                Label etatMultimedia = new Label();
                etatMultimedia.setText("Etat : " + annonces_opusk.getEtat1());
                detailAnnonce.add(etatMultimedia);
                break;

            case "Articles de maison":
                Label etatMaison = new Label();
                etatMaison.setText("Etat : " + annonces_opusk.getEtat3());
                detailAnnonce.add(etatMaison);
                break;

            case "immobilier":
                Label surface = new Label();
                surface.setText(String.valueOf("Surface : " + annonces_opusk.getSurface()));
                detailAnnonce.add(surface);
                Label jardin = new Label();
                boolean presenceJardin = annonces_opusk.getJardin();
                String texteJardin ="";
                if (presenceJardin = true){
                    texteJardin = "Avec un jardin";
                }
                else {
                    texteJardin = "Sans jardin";
                }
                jardin.setText(String.valueOf(texteJardin));
                detailAnnonce.add(jardin);
                Label pieces = new Label();
                pieces.setText(String.valueOf("Nombre de pièces : " + annonces_opusk.getPieces()));
                detailAnnonce.add(pieces);
                break;

            case "livres":
                Label etatLivre = new Label();
                etatLivre.setText("Etat : " + annonces_opusk.getEtat2());
                detailAnnonce.add(etatLivre);
                Label auteur = new Label();
                auteur.setText("Auteur : " + annonces_opusk.getAuteur());
                detailAnnonce.add(auteur);
                Label isbn = new Label();
                isbn.setText(String.valueOf("ISBN : " + annonces_opusk.getIsbn()));
                detailAnnonce.add(isbn);
                break;

        }


        Label prix = new Label();
        prix.setText(String.valueOf("Prix : " + annonces_opusk.getPrix()+ " $"));
        detailAnnonce.add(prix);

        Label cip = new Label();
        cip.setText("Auteur : " + annonces_opusk.getCip());
        detailAnnonce.add(cip);

        Label dateExpiration = new Label();
        dateExpiration.setText("Date d'expiration de l'annonce : " + String.valueOf(annonces_opusk.getDate_Expiration()));
        detailAnnonce.add(dateExpiration);

        Image image = new Image();
        image.setUrl("http://www.msnoverseas.com/Images/no-image-available.png");
        image.addStyleName("col-lg-offset-3");
        image.setHeight("200px");
        detailAnnonce.add(image);

    }
}
