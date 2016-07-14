package ca.uSherbrooke.gegi.opusK.client.application.home.produit;

import ca.uSherbrooke.gegi.opusK.shared.entity.Annonces_opusk;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
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

        detailAnnonce.clear();
        Label titre = new Label();
        titre.setText(annonces_opusk.getTitre());
        titre.setStyleName("col-lg-offset-5");

        Label prix = new Label();
        prix.setText(String.valueOf(annonces_opusk.getPrix()));

        /*Switch (annonce.getCategorie())
            case "Immobilier"
                Label nbPiece
         */

        detailAnnonce.add(titre);
        detailAnnonce.add(prix);
    }
}
