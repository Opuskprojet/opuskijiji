package ca.uSherbrooke.gegi.opusK.client.application.home.produit;

import ca.uSherbrooke.gegi.opusK.shared.entity.Annonces_opusk;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;
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

        detailAnnonce.add(createLab("Titre : ", smallCol,true));
        detailAnnonce.add(createLab(annonces_opusk.getTitre(),largeCol,false));

        detailAnnonce.add(createLab("Catégorie : ", smallCol,true));
        detailAnnonce.add(createLab(annonces_opusk.getCategorie(),largeCol,false));

        detailAnnonce.add(createLab("Description : ", smallCol,true));
        detailAnnonce.add(createLab(annonces_opusk.getDescription(),largeCol,false));


        switch (categorie) {
            case "informatique":
                detailAnnonce.add(createLab("Marque : ", smallCol,true));
                detailAnnonce.add(createLab(annonces_opusk.getMarque(),largeCol,false));
                break;

            case "multimedia":
                detailAnnonce.add(createLab("Etat : ", smallCol,true));
                detailAnnonce.add(createLab(annonces_opusk.getEtat1(),largeCol,false));
                break;

            case "Articles de maison":
                detailAnnonce.add(createLab("Etat : ", smallCol,true));
                detailAnnonce.add(createLab(annonces_opusk.getEtat3(),largeCol,false));
                break;

            case "immobilier":
                detailAnnonce.add(createLab("Surface : ", smallCol,true));
                detailAnnonce.add(createLab(String.valueOf(annonces_opusk.getSurface()),largeCol,false));

                String texteJardin;
                if (annonces_opusk.getJardin())
                    texteJardin = "Avec un jardin";
                else
                    texteJardin = "Sans jardin";

                detailAnnonce.add(createLab("Jardin : ", smallCol,true));
                detailAnnonce.add(createLab(texteJardin, largeCol,false));

                detailAnnonce.add(createLab("Nombre de pièces : ", smallCol,true));
                detailAnnonce.add(createLab(String.valueOf(annonces_opusk.getPieces()), largeCol,false));
                break;

            case "livres":
                detailAnnonce.add(createLab("Etat : ", smallCol,true));
                detailAnnonce.add(createLab(annonces_opusk.getEtat2(), largeCol,false));

                detailAnnonce.add(createLab("Auteur : ", smallCol,true));
                detailAnnonce.add(createLab(annonces_opusk.getAuteur(), largeCol,false));

                detailAnnonce.add(createLab("ISBN : ", smallCol,true));
                detailAnnonce.add(createLab(annonces_opusk.getIsbn(), largeCol,false));
                break;

        }

        detailAnnonce.add(createLab("Prix : ", smallCol,true));
        detailAnnonce.add(createLab(annonces_opusk.getPrix() + " $", largeCol,false));

        detailAnnonce.add(createLab("Auteur : ", smallCol,true));
        detailAnnonce.add(createLab(annonces_opusk.getCip(), largeCol,false));

        detailAnnonce.add(createLab("Date d'expiration de l'annonce : ", smallCol,true));
        detailAnnonce.add(createLab(String.valueOf(annonces_opusk.getDate_Expiration()), largeCol,false));

        Image image = new Image();
        image.addStyleName("col-lg-offset-3");
        image.setResource(Resources.INSTANCE.getDefaultPhoto());
        detailAnnonce.add(image);


    }

    private Label createLab (String name ,String style, boolean taille)
    {
        Label lab = new Label(name);
        lab.addStyleName(style);
        if(taille)
        lab.getElement().getStyle().setColor("green");

        return lab;
    }
}
