package ca.uSherbrooke.gegi.opusK.client.application.home.postAnnonce;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import org.gwtbootstrap3.client.ui.TextArea;
import org.gwtbootstrap3.client.ui.TextBox;

import javax.inject.Inject;


public class PostPageView extends ViewWithUiHandlers<PostPagePresenter> implements PostPagePresenter.MyView {

    interface Binder extends UiBinder<Widget, PostPageView> {
    }

    @UiField
    HTML serverResponse;

    @UiField
    ListBox listType;

    @UiField
    ListBox listCat;

    @UiField
    TextBox titreAnnonce;

    @UiField
    TextArea description;

    @UiField
    TextBox prix;

    @UiHandler("submitButton")
    void onSend(ClickEvent event) {
        //(listType.getSelectedItemText());
        //getUiHandlers().sendForm();
    }

    @Inject
    PostPageView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public void setServerResponse(String serverResponse) {
        this.serverResponse.setHTML(serverResponse);
    }

}
