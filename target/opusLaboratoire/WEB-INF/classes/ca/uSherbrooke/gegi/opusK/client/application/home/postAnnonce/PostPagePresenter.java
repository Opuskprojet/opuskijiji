package ca.uSherbrooke.gegi.opusK.client.application.home.postAnnonce;

import ca.uSherbrooke.gegi.opusK.client.application.home.HomePagePresenter;
import ca.uSherbrooke.gegi.opusK.client.place.NameTokens;
import ca.uSherbrooke.gegi.opusK.shared.dispatch.RecupFormAction;
import ca.uSherbrooke.gegi.opusK.shared.dispatch.RecupFormResult;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.rpc.shared.DispatchAsync;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

import java.util.List;

/**
 * Presenter pour  poster les annonces
 * Created by tanguy on 31/05/16.
 */
public class PostPagePresenter extends Presenter<PostPagePresenter.MyView, PostPagePresenter.MyProxy> implements PostPageUiHandlers{


    @ProxyStandard
    @NameToken(NameTokens.post)
    interface MyProxy extends ProxyPlace<PostPagePresenter> {
    }

    interface MyView extends View, HasUiHandlers<PostPagePresenter> {
        void setServerResponse(String serverResponse);

    }

    private final DispatchAsync dispatcher;



    @Inject
    PostPagePresenter(
            EventBus eventBus,
            MyView view,
            MyProxy proxy, DispatchAsync dispatcher) {
        super(eventBus, view, proxy, HomePagePresenter.SLOT_MAIN_CONTENT);
        this.dispatcher = dispatcher;

        getView().setUiHandlers(this);

    }

    @Override
    public void sendForm(List<String> datas)
    {
         RecupFormAction action = new RecupFormAction(datas);

        dispatcher.execute(action, new AsyncCallback<RecupFormResult>() {
            @Override
            public void onFailure(Throwable throwable) {
                getView().setServerResponse("Erreur " + throwable.getMessage());

            }

            @Override
            public void onSuccess(RecupFormResult recupFormResult) {
                getView().setServerResponse(recupFormResult.getResponse());
            }
        });
    }

}
