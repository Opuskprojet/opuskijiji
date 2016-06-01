/*
 * Copyright 2015, 2016 Département de Génie Électrique et Génie Informatique (GEGI) de l'Université de Sherbrooke (UdeS).
 * Tous droits réservés / All rights reserved.
 */

package ca.uSherbrooke.gegi.opusK.client.application;

import ca.uSherbrooke.gegi.opusK.client.application.home.HomeModule;
import ca.uSherbrooke.gegi.opusK.client.application.home.HomeModule;
import ca.uSherbrooke.gegi.opusK.client.application.home.chat.ChatPageModule;
import ca.uSherbrooke.gegi.opusK.client.application.home.consultAnnonce.ConsultPageModule;
import ca.uSherbrooke.gegi.opusK.client.application.home.postAnnonce.PostPageModule;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class OpusKModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        install(new HomeModule());
        install(new PostPageModule());
        install(new ChatPageModule());
        install(new ConsultPageModule());
    }
}