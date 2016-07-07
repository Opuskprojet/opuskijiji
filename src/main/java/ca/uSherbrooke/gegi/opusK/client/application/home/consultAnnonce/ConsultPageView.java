package ca.uSherbrooke.gegi.opusK.client.application.home.consultAnnonce;

import ca.uSherbrooke.gegi.opusK.shared.entity.Annonces_opusk;
import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.ColumnSortEvent;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.view.client.ListDataProvider;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

import javax.inject.Inject;
import java.util.Comparator;
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
    CellTable<Annonces_opusk> cellTable;

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

        while (cellTable.getColumnCount() > 0) {
            cellTable.removeColumn(0);
        }

        // Presenter les resultats dynamiquements
        if(serverResponse.size() == 0)
        {
            //  affiche text "aucun resultat"
        }
        else
        {
            onLoad(serverResponse, vosAnnonces);
        }
    }


    public void onLoad(List<Annonces_opusk> serverResponse, boolean vosAnnonces)
    {

        // Create type column.
        TextColumn<Annonces_opusk> typeColumn = new TextColumn<Annonces_opusk>() {
            @Override
            public String getValue(Annonces_opusk annonces_opusk) {
                return annonces_opusk.getType_Annonce();
            }

        };

        // Create titre column.
        TextColumn<Annonces_opusk> titreColumn = new TextColumn<Annonces_opusk>() {
            @Override
            public String getValue(Annonces_opusk annonces_opusk) {
                return annonces_opusk.getTitre();
            }

        };

        // Create cat column.
        TextColumn<Annonces_opusk> categorieColumn = new TextColumn<Annonces_opusk>() {
            @Override
            public String getValue(Annonces_opusk annonces_opusk) {
                return annonces_opusk.getCategorie();
            }
        };

        // Create descr column.
        TextColumn<Annonces_opusk> prixColumn = new TextColumn<Annonces_opusk>() {
            @Override
            public String getValue(Annonces_opusk annonces_opusk) {
                return String.valueOf(annonces_opusk.getPrix());
            }
        };

        // Create date column.
        TextColumn<Annonces_opusk> dateColumn = new TextColumn<Annonces_opusk>() {
            @Override
            public String getValue(Annonces_opusk annonces_opusk) {
                return annonces_opusk.getDate_Creation().toString();
            }

        };

        // Make the name column sortable.
        categorieColumn.setSortable(true);
        prixColumn.setSortable(true);
        typeColumn.setSortable(true);


        // Create a data provider.
        ListDataProvider<Annonces_opusk> dataProvider = new ListDataProvider<>();
        // Connect the table to the data provider.
        dataProvider.addDataDisplay(cellTable);

        // Add the data to the data provider, which automatically pushes it to the
        // widget.
        List<Annonces_opusk> list = dataProvider.getList();
        for (Annonces_opusk contact : serverResponse) {
            list.add(contact);
        }

        // Add a ColumnSortEvent.ListHandler to connect sorting to the
        // java.util.List.
        ColumnSortEvent.ListHandler<Annonces_opusk> columnSortHandler = new ColumnSortEvent.ListHandler<Annonces_opusk>(
                list);
        columnSortHandler.setComparator(categorieColumn,
                new Comparator<Annonces_opusk>() {
                    public int compare(Annonces_opusk a1, Annonces_opusk a2) {
                        return a1.getCategorie().compareTo(a2.getCategorie());
                    }
                });

        // Add a ColumnSortEvent.ListHandler to connect sorting to the
        // java.util.List.
        ColumnSortEvent.ListHandler<Annonces_opusk> typeSortHandler = new ColumnSortEvent.ListHandler<Annonces_opusk>(
                list);
        columnSortHandler.setComparator(typeColumn,
                new Comparator<Annonces_opusk>() {
                    public int compare(Annonces_opusk a1, Annonces_opusk a2) {
                        return a1.getType_Annonce().compareTo(a2.getType_Annonce());
                    }
                });


        ColumnSortEvent.ListHandler<Annonces_opusk> prixSortHandler = new ColumnSortEvent.ListHandler<Annonces_opusk>(
                list);
        columnSortHandler.setComparator(prixColumn,
                new Comparator<Annonces_opusk>() {
                    public int compare(Annonces_opusk a1, Annonces_opusk a2) {
                       return Double.compare(a1.getPrix(),a2.getPrix());
                }});

        // Add the columns.
        cellTable.addColumn(typeColumn,"Type");
        cellTable.addColumn(titreColumn,"Titre");
        cellTable.addColumn(categorieColumn, "Catégorie");

        cellTable.addColumn(prixColumn, "Prix");
        cellTable.addColumn(dateColumn, "Crée le ");

        cellTable.addColumnSortHandler(columnSortHandler);
        cellTable.addColumnSortHandler(prixSortHandler);
        cellTable.addColumnSortHandler(typeSortHandler);
        // We know that the data is sorted alphabetically by default.
        cellTable.getColumnSortList().push(typeColumn);

        if (vosAnnonces)
        {

        }



        pager.setDisplay(cellTable);
    }

    @Override
    public void setServerError(String error) {
        // PRINTF en haut de la page ERROR
    }
}
