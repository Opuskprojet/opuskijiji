package ca.uSherbrooke.gegi.opusK.client.application.home.postAnnonce;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

import javax.inject.Inject;


public class PostPageView extends ViewImpl implements PostPagePresenter.MyView {
    interface Binder extends UiBinder<Widget, PostPageView> {
    }


    @Inject
    PostPageView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }
}
