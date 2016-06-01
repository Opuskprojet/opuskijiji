package ca.uSherbrooke.gegi.opusK.client.application.home.consultAnnonce;

import ca.uSherbrooke.gegi.opusK.client.application.home.HomePagePresenter;
import ca.uSherbrooke.gegi.opusK.client.place.NameTokens;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.presenter.slots.NestedSlot;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;


public class ConsultPagePresenter extends Presenter<ConsultPagePresenter.MyView, ConsultPagePresenter.MyProxy> {
    interface MyView extends View {
    }


    @ProxyStandard
    @NameToken(NameTokens.consult)
    interface MyProxy extends ProxyPlace<ConsultPagePresenter> {
    }

    @Inject
    ConsultPagePresenter(
            EventBus eventBus,
            MyView view,
            MyProxy proxy) {
        super(eventBus, view, proxy, HomePagePresenter.SLOT_MAIN_CONTENT);

    }

}
