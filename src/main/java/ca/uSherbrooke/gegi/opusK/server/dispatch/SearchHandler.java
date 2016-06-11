package ca.uSherbrooke.gegi.opusK.server.dispatch;

import ca.uSherbrooke.gegi.opusK.shared.dispatch.SearchAction;
import ca.uSherbrooke.gegi.opusK.shared.dispatch.SearchResult;
import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.rpc.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.shared.ActionException;

/**
 * Created by tanguy on 10/06/16.
 */
public class SearchHandler implements ActionHandler<SearchAction,SearchResult> {
    @Override
    public SearchResult execute(SearchAction searchAction, ExecutionContext executionContext) throws ActionException {
        return null;
    }

    @Override
    public Class<SearchAction> getActionType() {
        return null;
    }

    @Override
    public void undo(SearchAction searchAction, SearchResult searchResult, ExecutionContext executionContext) throws ActionException {

    }
}
