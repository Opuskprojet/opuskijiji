/*
 * Copyright 2015, 2016 Département de Génie Électrique et Génie Informatique (GEGI) de l'Université de Sherbrooke (UdeS).
 * Tous droits réservés / All rights reserved.
 */

package ca.uSherbrooke.gegi.opusK.client.application.home;

import ca.uSherbrooke.gegi.opusK.client.place.NameTokens;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.presenter.slots.NestedSlot;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

import javax.inject.Inject;

/**
 * Created by tanguy on 15/06/16
 */
public class HomePagePresenter extends Presenter<HomePagePresenter.MyView, HomePagePresenter.MyProxy> implements HomePageUiHandlers {

    public static final NestedSlot SLOT_MAIN_CONTENT = new NestedSlot();


    public interface MyView extends View, HasUiHandlers<HomePageUiHandlers> {

    }

    @ProxyStandard
    @NameToken(NameTokens.home)
	/*@UseGatekeeper(AuthenticationGatekeeper.class)*/
    public interface MyProxy extends ProxyPlace<HomePagePresenter> {
    }

    @Inject
    public HomePagePresenter(EventBus eventBus, MyView view, MyProxy proxy ) {
        super(eventBus, view, proxy, RevealType.Root);
        getView().setUiHandlers(this);

    }

    @Override
    protected void onReset() {
        super.onReset();

    }



}