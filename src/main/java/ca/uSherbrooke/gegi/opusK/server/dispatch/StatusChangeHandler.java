package ca.uSherbrooke.gegi.opusK.server.dispatch;

import ca.uSherbrooke.gegi.opusK.shared.dispatch.StatusChangeAction;
import ca.uSherbrooke.gegi.opusK.shared.dispatch.StatusChangeResult;
import ca.uSherbrooke.gegi.opusK.shared.entity.Annonces_opusk;
import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.rpc.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.rpc.shared.Action;
import com.gwtplatform.dispatch.rpc.shared.Result;
import com.gwtplatform.dispatch.shared.ActionException;

/**
 * Created by tanguy on 25/06/16.
 */
public class StatusChangeHandler implements ActionHandler<StatusChangeAction,StatusChangeResult> {


    @Override
    public StatusChangeResult execute(StatusChangeAction action, ExecutionContext executionContext) throws ActionException {

        String annonceId = action.getAnnonceId();

        /*
        Annonces_opusk annonce = myDao.find( annonceID);
        annonce.setStatus = ;

        myDao.merge(annonce);
*/

        return null;
    }

    @Override
    public Class getActionType() {
        return null;
    }

    @Override
    public void undo(StatusChangeAction statusChangeAction, StatusChangeResult statusChangeResult, ExecutionContext executionContext) throws ActionException {

    }

}
