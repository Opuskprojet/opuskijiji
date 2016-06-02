package ca.uSherbrooke.gegi.opusK.client.application.home.postAnnonce;

import ca.uSherbrooke.gegi.opusK.client.application.home.HomePagePresenter;
import ca.uSherbrooke.gegi.opusK.client.place.NameTokens;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;


public class PostPagePresenter extends Presenter<PostPagePresenter.MyView, PostPagePresenter.MyProxy> {
    interface MyView extends View {
    }


    @ProxyStandard
    @NameToken(NameTokens.post)
    interface MyProxy extends ProxyPlace<PostPagePresenter> {
    }


    @Inject
    PostPagePresenter(
            EventBus eventBus,
            MyView view,
            MyProxy proxy) {
        super(eventBus, view, proxy, HomePagePresenter.SLOT_MAIN_CONTENT);

    }

}
