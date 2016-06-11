package ca.uSherbrooke.gegi.opusK.server.dispatch;

import ca.uSherbrooke.gegi.opusK.shared.dispatch.RecupFormAction;
import ca.uSherbrooke.gegi.opusK.shared.dispatch.RecupFormResult;
import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.rpc.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.shared.ActionException;

/**
 * Created by tanguy on 09/06/16.
 */
public class RecupFormHandler implements ActionHandler<RecupFormAction,RecupFormResult>{

    @Override
    public RecupFormResult execute(RecupFormAction action, ExecutionContext executionContext) throws ActionException {
        return null;
    }

    @Override
    public Class<RecupFormAction> getActionType() {
        return null;
    }

    @Override
    public void undo(RecupFormAction action, RecupFormResult result, ExecutionContext executionContext) throws ActionException {

    }
}
