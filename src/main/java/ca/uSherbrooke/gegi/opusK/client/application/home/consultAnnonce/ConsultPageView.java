package ca.uSherbrooke.gegi.opusK.client.application.home.consultAnnonce;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

import javax.inject.Inject;


public class ConsultPageView extends ViewImpl implements ConsultPagePresenter.MyView {
    interface Binder extends UiBinder<Widget, ConsultPageView> {
    }


    @Inject
    ConsultPageView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }
}
