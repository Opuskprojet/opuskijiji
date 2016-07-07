package ca.uSherbrooke.gegi.opusK.client.application.home.postAnnonce;

import com.gwtplatform.mvp.client.UiHandlers;

import java.util.List;

/**
 * uiHandler
 * Created by tanguy on 11/06/16.
 */
public interface PostPageUiHandlers extends UiHandlers {
    void sendForm(List<String> datas);
}
