package ca.uSherbrooke.gegi.opusK.client.application.home.postAnnonce;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class PostPageModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(PostPagePresenter.class, PostPagePresenter.MyView.class, PostPageView.class, PostPagePresenter.MyProxy.class);
    }
}
