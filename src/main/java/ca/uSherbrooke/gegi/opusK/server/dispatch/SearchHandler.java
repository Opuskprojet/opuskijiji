package ca.uSherbrooke.gegi.opusK.server.dispatch;

import ca.uSherbrooke.gegi.commons.core.server.utils.UserSession;
import ca.uSherbrooke.gegi.opusK.shared.dispatch.SearchAction;
import ca.uSherbrooke.gegi.opusK.shared.dispatch.SearchResult;
import ca.uSherbrooke.gegi.persist.dao.Dao;
import com.google.inject.Inject;
import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.rpc.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.shared.ActionException;

/**
 * Created by tanguy on 10/06/16.
 */
public class SearchHandler implements ActionHandler<SearchAction,SearchResult> {

    @Inject
    Dao myDao;

    @Inject
    UserSession session;

    @Override
    public SearchResult execute(SearchAction searchAction, ExecutionContext executionContext) throws ActionException {
        String searchQuery = searchAction.getSearchQuery();
        String categorie = searchAction.getCategorie();

       // session.getUserId();

        //myDao.persist();

        // DAO find ..
        // New List<Entity> ...
        //for.. list.add ...
        // return new SearchResult(list);

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
