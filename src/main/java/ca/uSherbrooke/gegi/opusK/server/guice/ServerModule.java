/*
 * Copyright 2015, 2016 Département de Génie Électrique et Génie Informatique (GEGI) de l'Université de Sherbrooke (UdeS).
 * Tous droits réservés / All rights reserved.
 */

package ca.uSherbrooke.gegi.opusK.server.guice;

import ca.uSherbrooke.gegi.opusK.server.dispatch.RecupFormHandler;
import ca.uSherbrooke.gegi.opusK.server.dispatch.SearchHandler;
import ca.uSherbrooke.gegi.opusK.shared.dispatch.RecupFormAction;
import ca.uSherbrooke.gegi.opusK.shared.dispatch.SearchAction;
import com.gwtplatform.dispatch.rpc.server.guice.HandlerModule;

public class ServerModule extends HandlerModule {
    @Override
    protected void configureHandlers() {
        bindHandler(RecupFormAction.class, RecupFormHandler.class);
        bindHandler(SearchAction.class, SearchHandler.class);
    }
}