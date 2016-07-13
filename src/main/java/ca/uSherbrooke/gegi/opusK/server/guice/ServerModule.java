/*
 * Copyright 2015, 2016 Département de Génie Électrique et Génie Informatique (GEGI) de l'Université de Sherbrooke (UdeS).
 * Tous droits réservés / All rights reserved.
 */

package ca.uSherbrooke.gegi.opusK.server.guice;

import ca.uSherbrooke.gegi.opusK.server.dispatch.ProductHandler;
import ca.uSherbrooke.gegi.opusK.server.dispatch.RecupFormHandler;
import ca.uSherbrooke.gegi.opusK.server.dispatch.SearchHandler;
import ca.uSherbrooke.gegi.opusK.server.dispatch.StatusChangeHandler;
import ca.uSherbrooke.gegi.opusK.shared.dispatch.ProductAction;
import ca.uSherbrooke.gegi.opusK.shared.dispatch.RecupFormAction;
import ca.uSherbrooke.gegi.opusK.shared.dispatch.SearchAction;
import ca.uSherbrooke.gegi.opusK.shared.dispatch.StatusChangeAction;
import com.gwtplatform.dispatch.rpc.server.guice.HandlerModule;

public class ServerModule extends HandlerModule {
    @Override
    protected void configureHandlers() {
        bindHandler(RecupFormAction.class, RecupFormHandler.class);
        bindHandler(SearchAction.class, SearchHandler.class);
        bindHandler(StatusChangeAction.class, StatusChangeHandler.class);
        bindHandler(ProductAction.class, ProductHandler.class);
    }
}