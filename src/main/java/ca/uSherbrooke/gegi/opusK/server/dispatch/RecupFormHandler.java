package ca.uSherbrooke.gegi.opusK.server.dispatch;

import ca.uSherbrooke.gegi.commons.core.server.utils.UserSession;
import ca.uSherbrooke.gegi.opusK.shared.dispatch.RecupFormAction;
import ca.uSherbrooke.gegi.opusK.shared.dispatch.RecupFormResult;
import ca.uSherbrooke.gegi.persist.dao.Dao;
import com.google.inject.Inject;
import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.rpc.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.shared.ActionException;

import java.util.List;

/**
 * Created by tanguy on 09/06/16.
 */
public class RecupFormHandler implements ActionHandler<RecupFormAction,RecupFormResult>{

    @Inject
    Dao myDao;

    @Inject
    UserSession session;

    @Override
    public RecupFormResult execute(RecupFormAction action, ExecutionContext executionContext) throws ActionException {

        int idUser = session.getUserId();

        List<String> datas = action.getDatas();


        // entity set champs
        // dao.persist(entity)


        String reponse = "Annonce publié sur Opus Kijiji :) !";
        return new RecupFormResult(reponse);
    }

    @Override
    public Class<RecupFormAction> getActionType() {
        return null;
    }

    @Override
    public void undo(RecupFormAction action, RecupFormResult result, ExecutionContext executionContext) throws ActionException {

    }
}
