package ca.uSherbrooke.gegi.opusK.client.application.home.consultAnnonce;

import ca.uSherbrooke.gegi.opusK.shared.entity.Annonces_opusk;
import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.client.ui.*;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

import javax.inject.Inject;
import java.util.List;

/**
 * Vue pour consulter les andnonces
 * Created by tanguy on 31/05/16.
 */
public class ConsultPageView extends ViewWithUiHandlers<ConsultPagePresenter> implements ConsultPagePresenter.MyView {


    interface Binder extends UiBinder<Widget, ConsultPageView> {
    }

    @UiField
    InputElement searchBar;

    @UiField
    SimplePager pager;

    @UiField
    CellTable cellTable;

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
            // declare Tableau de i bouton qui auront en value l'id de l'annonce

            ButtonCell tabsButtonCell[] = new ButtonCell[serverResponse.size()];


            for (int i = 0; i < serverResponse.size(); i++)
            {


                // voir Table cell

                //
                if (vosAnnonces) {


                    // ajoute les options de management (colonne avec bouton statut)
                    // click listener  bouton pour declencher action
                    //getUiHandlers().statusChange(this.getId);
                }

            }
        }

    }

    @Override
    public void setServerError(String error) {
        // PRINTF en haut de la page ERROR
    }
}
