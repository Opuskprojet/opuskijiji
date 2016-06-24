package ca.uSherbrooke.gegi.opusK.client.application.home.consultAnnonce;

import ca.uSherbrooke.gegi.opusK.shared.entity.Annonces_opusk;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import org.gwtbootstrap3.client.ui.Input;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by tanguy on 31/05/16.
 */
public class ConsultPageView extends ViewWithUiHandlers<ConsultPagePresenter> implements ConsultPagePresenter.MyView {


    interface Binder extends UiBinder<Widget, ConsultPageView> {
    }

    @UiField
    InputElement searchBar;

    @UiHandler("submitButton")
    void onSend(ClickEvent event) {
        //String query = searchBar.getValue();
        //String categorie = ;


        //getUiHandlers().sendSearch(query,caterogie, false);
    }


    @Inject
    ConsultPageView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public void setServerResponse(List<Annonces_opusk> serverResponse) {
        // Presenter les resultats dynamiquements
    }

    @Override
    public void setServerError(String error) {
        // PRINTF en haut de la page ERROR
    }
}
