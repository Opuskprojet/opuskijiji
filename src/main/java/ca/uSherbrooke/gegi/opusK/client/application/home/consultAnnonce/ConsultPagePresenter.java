package ca.uSherbrooke.gegi.opusK.client.application.home.consultAnnonce;

import ca.uSherbrooke.gegi.opusK.client.application.home.HomePagePresenter;
import ca.uSherbrooke.gegi.opusK.client.place.NameTokens;
import ca.uSherbrooke.gegi.opusK.client.place.ParameterTokens;
import ca.uSherbrooke.gegi.opusK.shared.dispatch.SearchAction;
import ca.uSherbrooke.gegi.opusK.shared.dispatch.SearchResult;
import ca.uSherbrooke.gegi.opusK.shared.dispatch.StatusChangeAction;
import ca.uSherbrooke.gegi.opusK.shared.dispatch.StatusChangeResult;
import ca.uSherbrooke.gegi.opusK.shared.entity.Annonces_opusk;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.rpc.shared.DispatchAsync;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;
import org.gwtbootstrap3.extras.notify.client.constants.NotifyType;
import org.gwtbootstrap3.extras.notify.client.ui.Notify;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * presenter pour consulter les annonces
 * Created by tanguy on 31/05/16.
 */
public class ConsultPagePresenter extends Presenter<ConsultPagePresenter.MyView, ConsultPagePresenter.MyProxy> implements ConsultPageUiHandlers{


    @ProxyStandard
    @NameToken({NameTokens.consult,NameTokens.vosAnnonces})
    interface MyProxy extends ProxyPlace<ConsultPagePresenter> {
    }

    interface MyView extends View, HasUiHandlers<ConsultPagePresenter> {
        void setServerResponse(List<Annonces_opusk> serverResponse, boolean vosAnnonces);
        void setServerError(String error);
    }



    private final DispatchAsync dispatcher;
    private final PlaceManager placeManager;

    @Inject
    ConsultPagePresenter(
            EventBus eventBus,
            MyView view,
            MyProxy proxy,
            DispatchAsync dispatcher,
            PlaceManager placeManager) {
        super(eventBus, view, proxy, HomePagePresenter.SLOT_MAIN_CONTENT);
        this.dispatcher = dispatcher;
        this.placeManager = placeManager;
        getView().setUiHandlers(this);
    }


    @Override
    public void prepareFromRequest(PlaceRequest request) {
        super.prepareFromRequest(request);

        if(request.getNameToken().equals("/vosAnnonces"))
        {
            sendSearch("", "", true);
        }
        if(request.getNameToken().equals("/consult"))
        {
            sendSearch("","",false);
        }

    }

    @Override
    public void sendSearch(String query, String categorie, boolean vosAnnonces) {

        SearchAction action = new SearchAction(query,categorie, vosAnnonces);

        dispatcher.execute(action, new AsyncCallback<SearchResult>() {
            @Override
            public void onFailure(Throwable throwable) {
                getView().setServerError("Erreur " + throwable.getMessage());

            }

            @Override
            public void onSuccess(SearchResult searchResult) {
                getView().setServerResponse(searchResult.getAnnonces(),searchResult.getVosAnnonces());
            }
        });

    }

    @Override
    public void statusChange(int idAnnonce) {

        StatusChangeAction action = new StatusChangeAction(idAnnonce);

        dispatcher.execute(action, new AsyncCallback<StatusChangeResult>() {
            @Override
            public void onFailure(Throwable throwable) {
                getView().setServerError("Erreur " + throwable.getMessage());

            }

            @Override
            public void onSuccess(StatusChangeResult searchResult) {
                Notify.notify(searchResult.getResponse(), NotifyType.SUCCESS);
                PlaceRequest placeRequest = new PlaceRequest.Builder()
                        .nameToken(NameTokens.getVosAnnonces())
                        .build();
                placeManager.revealPlace(placeRequest);

            }
        });
    }

    @Override
    public void displayAnnonce(int id)
    {
        PlaceRequest placeRequest = new PlaceRequest.Builder()
                .nameToken(NameTokens.getProduct())
                .with(ParameterTokens.ID, String.valueOf(id))
                .build();

        placeManager.revealPlace(placeRequest);
    }
}
