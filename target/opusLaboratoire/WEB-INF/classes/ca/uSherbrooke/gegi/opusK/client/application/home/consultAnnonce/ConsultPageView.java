package ca.uSherbrooke.gegi.opusK.client.application.home.consultAnnonce;

import ca.uSherbrooke.gegi.opusK.shared.entity.Annonces_opusk;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.dom.client.TableElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

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

    @UiField
    TableElement tableResult;

    @UiField
    ListBox listCat;

    @UiHandler("submitButton")
    void onSend(ClickEvent event) {
        String query = searchBar.getValue().trim();
        String categorie = listCat.getSelectedItemText();

        getUiHandlers().sendSearch(query,categorie, false);
    }


    @Inject
    ConsultPageView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public void setServerResponse(List<Annonces_opusk> serverResponse, boolean vosAnnonces) {
        // Presenter les resultats dynamiquements
        if(serverResponse.size() == 0)
        {
            //  affiche text "aucun resultat"
        }
        else
        {
            //for int i < server.size ... on construit les annonces
            if(vosAnnonces)
            {
                // ajoute les options de management (colonne avec bouton statut)
                // click listener  bouton pour declencher action
                // dispatch exec
            }
            // end for
        }

    }

    @Override
    public void setServerError(String error) {
        // PRINTF en haut de la page ERROR
    }
}
