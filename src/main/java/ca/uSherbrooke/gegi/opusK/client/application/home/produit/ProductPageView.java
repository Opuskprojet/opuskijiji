package ca.uSherbrooke.gegi.opusK.client.application.home.produit;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

import javax.inject.Inject;

/**
 * Created by tanguy on 02/06/16.
 */
public class ProductPageView extends ViewImpl implements ProductPagePresenter.MyView {
    interface Binder extends UiBinder<Widget, ProductPageView> {
    }


    @Inject
    ProductPageView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));

    }
}
