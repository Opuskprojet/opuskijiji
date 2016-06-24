/*
 * Copyright 2015, 2016 Département de Génie Électrique et Génie Informatique (GEGI) de l'Université de Sherbrooke (UdeS).
 * Tous droits réservés / All rights reserved.
 */

package ca.uSherbrooke.gegi.opusK.client.gin;

import ca.uSherbrooke.gegi.opusK.client.application.OpusKModule;
import ca.uSherbrooke.gegi.opusK.client.place.NameTokens;

import com.gwtplatform.dispatch.rpc.client.gin.RpcDispatchAsyncModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;
import com.gwtplatform.mvp.client.annotations.DefaultPlace;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.proxy.DefaultPlaceManager;
import com.gwtplatform.mvp.shared.proxy.RouteTokenFormatter;

/**
 * See more on setting up the PlaceManager on <a
 * href="// See more on: https://github.com/ArcBees/GWTP/wiki/PlaceManager">DefaultModule's > DefaultPlaceManager</a>
 */
public class ClientModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        install(new DefaultModule.Builder().placeManager(DefaultPlaceManager.class).tokenFormatter(RouteTokenFormatter.class).build());
		install(new RpcDispatchAsyncModule());
        install(new ca.uSherbrooke.gegi.commons.core.client.gin.ClientModule());
        install(new OpusKModule());
		
		bindConstant().annotatedWith(DefaultPlace.class).to(NameTokens.home);       
    }
}