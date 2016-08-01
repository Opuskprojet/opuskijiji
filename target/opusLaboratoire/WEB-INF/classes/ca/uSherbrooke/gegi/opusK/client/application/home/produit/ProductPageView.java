package ca.uSherbrooke.gegi.opusK.client.application.home.produit;

import ca.uSherbrooke.gegi.opusK.shared.entity.Annonces_opusk;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.*;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

import javax.inject.Inject;

/**
 * Created by tanguy on 02/06/16
 */
public class ProductPageView extends ViewWithUiHandlers<ProductPagePresenter> implements ProductPagePresenter.MyView {

    interface Resources extends ClientBundle {
        @Source("no-image.png")
        ImageResource getDefaultPhoto();

        ProductPageView.Resources INSTANCE = GWT.create(ProductPageView.Resources.class);
    }

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

        String  smallCol = "col-lg-4";
        String largeCol = "col-lg-8";
        String categorie = annonces_opusk.getCategorie();
        detailAnnonce.clear();

        detailAnnonce.add(createLab("Titre : ", smallCol));
        detailAnnonce.add(createLab(annonces_opusk.getTitre(),largeCol));

        detailAnnonce.add(createLab("Catégorie : ", smallCol));
        detailAnnonce.add(createLab(annonces_opusk.getCategorie(),largeCol));

        detailAnnonce.add(createLab("Description : ", smallCol));
        TextArea description = new TextArea();
        description.setReadOnly(true);
        description.setText(annonces_opusk.getDescription());
        detailAnnonce.add(description);

        switch (categorie) {
            case "informatique":
                detailAnnonce.add(createLab("Marque : ", smallCol));
                detailAnnonce.add(createLab(annonces_opusk.getMarque(),largeCol));
                break;

            case "multimedia":
                detailAnnonce.add(createLab("Etat : ", smallCol));
                detailAnnonce.add(createLab(annonces_opusk.getEtat1(),largeCol));
                break;

            case "Articles de maison":
                detailAnnonce.add(createLab("Etat : ", smallCol));
                detailAnnonce.add(createLab(annonces_opusk.getEtat3(),largeCol));
                break;

            case "immobilier":
                detailAnnonce.add(createLab("Surface : ", smallCol));
                detailAnnonce.add(createLab(String.valueOf(annonces_opusk.getSurface()),largeCol));

                String texteJardin;
                if (annonces_opusk.getJardin())
                    texteJardin = "Avec un jardin";
                else
                    texteJardin = "Sans jardin";

                detailAnnonce.add(createLab("Jardin : ", smallCol));
                detailAnnonce.add(createLab(texteJardin, largeCol));

                detailAnnonce.add(createLab("Nombre de pièces : ", smallCol));
                detailAnnonce.add(createLab(String.valueOf(annonces_opusk.getPieces()), largeCol));
                break;

            case "livres":
                detailAnnonce.add(createLab("Etat : ", smallCol));
                detailAnnonce.add(createLab(annonces_opusk.getEtat2(), largeCol));

                detailAnnonce.add(createLab("Auteur : ", smallCol));
                detailAnnonce.add(createLab(annonces_opusk.getAuteur(), largeCol));

                detailAnnonce.add(createLab("ISBN : ", smallCol));
                detailAnnonce.add(createLab(annonces_opusk.getIsbn(), largeCol));
                break;

        }

        detailAnnonce.add(createLab("Prix : ", smallCol));
        detailAnnonce.add(createLab(annonces_opusk.getPrix() + " $", largeCol));

        detailAnnonce.add(createLab("Auteur : ", smallCol));
        detailAnnonce.add(createLab(annonces_opusk.getCip(), largeCol));

        detailAnnonce.add(createLab("Date d'expiration de l'annonce : ", smallCol));
        detailAnnonce.add(createLab(String.valueOf(annonces_opusk.getDate_Expiration()), largeCol));

        Image image = new Image();
        image.addStyleName("col-lg-offset-3");
        image.setResource(Resources.INSTANCE.getDefaultPhoto());
        detailAnnonce.add(image);


    }

    private Label createLab (String name ,String style )
    {
        Label lab = new Label(name);
        lab.addStyleName(style);
        return lab;
    }
}
