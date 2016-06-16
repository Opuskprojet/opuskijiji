package ca.uSherbrooke.gegi.opusK.client.application.home.consultAnnonce;

import ca.uSherbrooke.gegi.opusK.client.application.home.HomePagePresenter;
import ca.uSherbrooke.gegi.opusK.client.place.NameTokens;
import ca.uSherbrooke.gegi.opusK.shared.dispatch.RecupFormResult;
import ca.uSherbrooke.gegi.opusK.shared.dispatch.SearchAction;
import ca.uSherbrooke.gegi.opusK.shared.dispatch.SearchResult;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.rpc.shared.DispatchAsync;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.presenter.slots.NestedSlot;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

import java.util.List;

/**
 * Created by tanguy on 31/05/16.
 */
public class ConsultPagePresenter extends Presenter<ConsultPagePresenter.MyView, ConsultPagePresenter.MyProxy> implements ConsultPageUiHandlers{

    @ProxyStandard
    @NameToken(NameTokens.consult)
    interface MyProxy extends ProxyPlace<ConsultPagePresenter> {
    }

    interface MyView extends View, HasUiHandlers<ConsultPagePresenter> {
        // REMPLACER PAR list ENTITY
        void setServerResponse(List<String> serverResponse);
        void setServerError(String error);
    }



    private final DispatchAsync dispatcher;

    @Inject
    ConsultPagePresenter(
            EventBus eventBus,
            MyView view,
            MyProxy proxy,
            DispatchAsync dispatcher) {
        super(eventBus, view, proxy, HomePagePresenter.SLOT_MAIN_CONTENT);
        this.dispatcher = dispatcher;
        getView().setUiHandlers(this);
    }

    @Override
    public void sendSearch(String query, String categorie) {

        SearchAction action = new SearchAction(query,categorie);

        dispatcher.execute(action, new AsyncCallback<SearchResult>() {
            @Override
            public void onFailure(Throwable throwable) {
                getView().setServerError("Erreur " + throwable.getMessage());

            }

            @Override
            public void onSuccess(SearchResult searchResult) {
                getView().setServerResponse(searchResult.getAnnonces());
            }
        });

    }



}
