package ca.uSherbrooke.gegi.opusK.client.application.home.produit;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;


/**
 * Created by tanguy on 02/06/16
 */
public class ProductPageModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(ProductPagePresenter.class, ProductPagePresenter.MyView.class, ProductPageView.class, ProductPagePresenter.MyProxy.class);
    }
}

