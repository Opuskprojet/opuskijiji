package ca.uSherbrooke.gegi.opusK.client.application.home.chat;

import ca.uSherbrooke.gegi.opusK.client.application.home.HomePagePresenter;
import ca.uSherbrooke.gegi.opusK.client.place.NameTokens;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.presenter.slots.NestedSlot;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;


public class ChatPagePresenter extends Presenter<ChatPagePresenter.MyView, ChatPagePresenter.MyProxy> {
    interface MyView extends View {
    }



    @ProxyStandard
    @NameToken(NameTokens.chat)
    interface MyProxy extends ProxyPlace<ChatPagePresenter> {
    }

    @Inject
    ChatPagePresenter(
            EventBus eventBus,
            MyView view,
            MyProxy proxy) {
        super(eventBus, view, proxy, HomePagePresenter.SLOT_MAIN_CONTENT);

    }

}
