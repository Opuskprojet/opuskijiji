package ca.uSherbrooke.gegi.opusK.client.application.home.postAnnonce;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

/**
 * Created by tanguy on 31/05/16.
 */
public class PostPageModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(PostPagePresenter.class, PostPagePresenter.MyView.class, PostPageView.class, PostPagePresenter.MyProxy.class);
    }
}
