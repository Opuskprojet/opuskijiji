package ca.uSherbrooke.gegi.opusK.client.application.home.consultAnnonce;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class ConsultPageModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(ConsultPagePresenter.class, ConsultPagePresenter.MyView.class, ConsultPageView.class, ConsultPagePresenter.MyProxy.class);
    }
}
