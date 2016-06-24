package ca.uSherbrooke.gegi.opusK.client.application.home.chat;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

import javax.inject.Inject;


public class ChatPageView extends ViewImpl implements ChatPagePresenter.MyView {
    interface Binder extends UiBinder<Widget, ChatPageView> {
    }



    @Inject
    ChatPageView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
;
    }
}
