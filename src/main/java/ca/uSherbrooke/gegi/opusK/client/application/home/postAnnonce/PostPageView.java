package ca.uSherbrooke.gegi.opusK.client.application.home.postAnnonce;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

import javax.inject.Inject;


public class PostPageView extends ViewWithUiHandlers<PostPagePresenter> implements PostPagePresenter.MyView {

    interface Binder extends UiBinder<Widget, PostPageView> {
    }

    @UiField
    HTML serverResponse;


    @Inject
    PostPageView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public void setServerResponse(String serverResponse) {
        this.serverResponse.setHTML(serverResponse);
    }

}
