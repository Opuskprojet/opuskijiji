package ca.uSherbrooke.gegi.opusK.client.application.home.produit;

import ca.uSherbrooke.gegi.opusK.shared.entity.Annonces_opusk;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.*;
import com.gwtplatform.mvp.client.ViewImpl;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

import javax.inject.Inject;

/**
 * Created by tanguy on 02/06/16
 */
public class ProductPageView extends ViewWithUiHandlers<ProductPagePresenter> implements ProductPagePresenter.MyView {


    @UiField
    HTMLPanel myPanel;

    interface Binder extends UiBinder<Widget, ProductPageView> {
    }


    @Inject
    ProductPageView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public void displayProductPage(Annonces_opusk annonces_opusk) {

        myPanel.clear();

        Label test = new Label();
        test.setText(annonces_opusk.getTitre());

        Label prix = new Label();
        prix.setText(String.valueOf(annonces_opusk.getPrix()));

        /*Switch (annonce.getCategorie())
            case "Immobilier"
                Label nbPiece


         */

        myPanel.add(test);
        myPanel.add(prix);
    }
}
