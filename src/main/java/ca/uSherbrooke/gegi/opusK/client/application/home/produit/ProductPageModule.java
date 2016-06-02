package ca.uSherbrooke.gegi.opusK.client.application.home.produit;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class ProductPageModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(ProductPagePresenter.class, ProductPagePresenter.MyView.class, ProductPageView.class, ProductPagePresenter.MyProxy.class);
    }
}
