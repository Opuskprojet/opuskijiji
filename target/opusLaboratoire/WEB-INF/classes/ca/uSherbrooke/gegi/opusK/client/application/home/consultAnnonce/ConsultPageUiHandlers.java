package ca.uSherbrooke.gegi.opusK.client.application.home.consultAnnonce;

import com.gwtplatform.mvp.client.UiHandlers;

/**
 * Created by tanguy on 15/06/16
 */
public interface ConsultPageUiHandlers extends UiHandlers {
    void sendSearch(String query, String categorie, boolean vosAnnonces);
    void statusChange(int idAnnonce);
    void displayAnnonce(int id);
}
