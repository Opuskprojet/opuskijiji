package ca.uSherbrooke.gegi.opusK.client.application.home.produit;

import ca.uSherbrooke.gegi.opusK.client.application.home.HomePagePresenter;
import ca.uSherbrooke.gegi.opusK.client.place.NameTokens;
import ca.uSherbrooke.gegi.opusK.shared.dispatch.*;
import ca.uSherbrooke.gegi.opusK.shared.entity.Annonces_opusk;
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
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;
import org.gwtbootstrap3.extras.notify.client.constants.NotifyType;
import org.gwtbootstrap3.extras.notify.client.ui.Notify;

/**
 * Created by tanguy on 02/06/16
 */
public class ProductPagePresenter extends Presenter<ProductPagePresenter.MyView, ProductPagePresenter.MyProxy> implements ProductPageUiHandlers{
    interface MyView extends View, HasUiHandlers<ProductPagePresenter> {
        void displayProductPage(Annonces_opusk annonces_opusk);
    }


    @ProxyStandard
    @NameToken(NameTokens.product)
    interface MyProxy extends ProxyPlace<ProductPagePresenter> {
    }

    private final DispatchAsync dispatcher;

    @Inject
    ProductPagePresenter(
            EventBus eventBus,
            MyView view,
            MyProxy proxy,
            DispatchAsync dispatcher) {
        super(eventBus, view, proxy, HomePagePresenter.SLOT_MAIN_CONTENT);
        this.dispatcher = dispatcher;
        getView().setUiHandlers(this);
    }

    @Override
    public void prepareFromRequest(PlaceRequest request) {
        String id = request.getParameter("id", "0");
        recupAnnonce(Integer.valueOf(id));
    }


    private void recupAnnonce(int id)
    {
        ProductAction action = new ProductAction(id);
        dispatcher.execute(action, new AsyncCallback<ProductResult>() {
            @Override
            public void onFailure(Throwable throwable) {
                Notify.notify(throwable.getMessage(), NotifyType.DANGER);
            }

            @Override
            public void onSuccess(ProductResult productResult) {
                if(productResult != null)
                    getView().displayProductPage(productResult.getAnnonce());
                else
                    Notify.notify("produit non trouvé :(", NotifyType.DANGER);
            }
        });

    }
}
