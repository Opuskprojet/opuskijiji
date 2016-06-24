package ca.uSherbrooke.gegi.opusK.client.application.home.postAnnonce;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.ui.ListBox;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import org.gwtbootstrap3.client.ui.*;
import org.gwtbootstrap3.client.ui.CheckBox;
import org.gwtbootstrap3.client.ui.DoubleBox;
import org.gwtbootstrap3.client.ui.TextArea;
import org.gwtbootstrap3.client.ui.TextBox;
import org.gwtbootstrap3.client.ui.gwt.FlowPanel;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tanguy on 31/05/16.
 */
public class PostPageView extends ViewWithUiHandlers<PostPagePresenter> implements PostPagePresenter.MyView {

    interface Binder extends UiBinder<Widget, PostPageView> {
    }

    // construit tout pour eviter  valeur indéfinie dans la List de datas
    private TextBox textinfo = new TextBox();
    private TextBox textmulti = new TextBox();
    private TextBox textmaison = new TextBox();
    private TextBox piece = new TextBox();
    private TextBox isbn = new TextBox();
    private TextBox etat = new TextBox();
    private TextBox auteur = new TextBox();
    private CheckBox checkjardin = new CheckBox();
    private DoubleBox surface = new DoubleBox();

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
    DoubleBox prix;

    @UiField
    FormGroup dynamicForm; //lien pour le formulaire


    @UiHandler("listCat")
    void onSelect(ChangeEvent event){
        String categorie = listCat.getSelectedItemText();
        dynamicForm.clear();
        switch (categorie){
            case "Informatique" :
                FormLabel labelinfo = new FormLabel();
                labelinfo.setText("Marque");
                labelinfo.addStyleName("col-lg-4");

                FlowPanel flowinfo = new FlowPanel();
                flowinfo.addStyleName("col-lg-5");

                flowinfo.add(textinfo);

                dynamicForm.add(labelinfo);
                dynamicForm.add(flowinfo);
                break;

            case "Multimédia" :
                FormLabel labelmulti = new FormLabel();
                labelmulti.setText("Etat");
                labelmulti.addStyleName("col-lg-4");

                FlowPanel flowmulti = new FlowPanel();
                flowmulti.addStyleName("col-lg-5");

                flowmulti.add(textmulti);

                dynamicForm.add(labelmulti);
                dynamicForm.add(flowmulti);
                break;

            case "Articles de maison" :
                FormLabel labelmaison = new FormLabel();
                labelmaison.setText("Etat");
                labelmaison.addStyleName("col-lg-4");

                FlowPanel flowmaison = new FlowPanel();
                flowmaison.addStyleName("col-lg-5");

                flowmaison.add(textmaison);

                dynamicForm.add(labelmaison);
                dynamicForm.add(flowmaison);
                break;

            case "Immobilier" :
                FormLabel labelimmo2 = new FormLabel();
                labelimmo2.setText("Surface");
                labelimmo2.addStyleName("col-lg-4");

                FlowPanel flowimmo2 = new FlowPanel();
                flowimmo2.addStyleName("col-lg-5");

                flowimmo2.add(surface);

                dynamicForm.add(labelimmo2);
                dynamicForm.add(flowimmo2);


                FormLabel labelimmo3 = new FormLabel();
                labelimmo3.setText("Pièces");
                labelimmo3.addStyleName("col-lg-4");

                FlowPanel flowimmo3 = new FlowPanel();
                flowimmo3.addStyleName("col-lg-5");

                flowimmo3.add(piece);

                dynamicForm.add(labelimmo3);
                dynamicForm.add(flowimmo3);


                FlowPanel flowimmo1 = new FlowPanel();
                flowimmo1.addStyleName("col-lg-offset-4 col-lg-5");

                checkjardin.setText("Jardin");
                flowimmo1.add(checkjardin);

                dynamicForm.add(flowimmo1);
                break;

            case "Livres" :

                FormLabel labellivre1 = new FormLabel();
                labellivre1.setText("ISBN");
                labellivre1.addStyleName("col-lg-4");

                FlowPanel flowlivre1 = new FlowPanel();
                flowlivre1.addStyleName("col-lg-5");

                flowlivre1.add(isbn);

                dynamicForm.add(labellivre1);
                dynamicForm.add(flowlivre1);


                FormLabel labellivre2 = new FormLabel();
                labellivre2.setText("Auteur");
                labellivre2.addStyleName("col-lg-4");

                FlowPanel flowlivre2 = new FlowPanel();
                flowlivre2.addStyleName("col-lg-5");

                flowlivre2.add(auteur);

                dynamicForm.add(labellivre2);
                dynamicForm.add(flowlivre2);

                FormLabel labellivre3 = new FormLabel();
                labellivre3.setText("Etat");
                labellivre3.addStyleName("col-lg-4");

                FlowPanel flowlivre3 = new FlowPanel();
                flowlivre3.addStyleName("col-lg-5");

                flowlivre3.add(etat);

                dynamicForm.add(labellivre3);
                dynamicForm.add(flowlivre3);

                break;

            default:
                break;

        }
    }


    @UiHandler("submitButton")
    void onSend(ClickEvent event) {

        /*
         *
         * type / categorie / titre / description / prix / marque info / etat multimedia /
         * etat maison / piece / surface / jardin / etat livre / isbn / auteur;
         */
        surface.setValue(setDefault(surface.getValue()));
        prix.setValue(setDefault(prix.getValue()));

        List<String> datas = Arrays.asList(listType.getSelectedItemText(),
                listCat.getSelectedItemText(),titreAnnonce.getText(),description.getText()
                , String.valueOf(prix.getValue()), textinfo.getText(),textmulti.getText(),textmaison.getText()
                ,piece.getText(), String.valueOf(surface.getValue()),Boolean.toString(checkjardin.getValue()), etat.getText(),
                isbn.getText(),auteur.getText());

        getUiHandlers().sendForm(datas);
    }

    @Inject
    PostPageView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public void setServerResponse(String serverResponse) {
        this.serverResponse.setHTML(serverResponse);
    }


    private Double setDefault (Double value)
    {
        if(value == null)
            value = 0.0;
        return value;
    }
}
