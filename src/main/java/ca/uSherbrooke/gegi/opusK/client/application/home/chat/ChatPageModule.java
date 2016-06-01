package ca.uSherbrooke.gegi.opusK.client.application.home.chat;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class ChatPageModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(ChatPagePresenter.class, ChatPagePresenter.MyView.class, ChatPageView.class, ChatPagePresenter.MyProxy.class);
    }
}
