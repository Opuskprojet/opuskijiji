package ca.uSherbrooke.gegi.opusK.server.dispatch;

import ca.uSherbrooke.gegi.commons.core.server.utils.UserSession;
import ca.uSherbrooke.gegi.opusK.shared.dispatch.SearchAction;
import ca.uSherbrooke.gegi.opusK.shared.dispatch.SearchResult;
import ca.uSherbrooke.gegi.opusK.shared.entity.Annonces_opusk;
import ca.uSherbrooke.gegi.persist.dao.Dao;
import ca.uSherbrooke.gegi.persist.dao.Opus;
import com.google.inject.Inject;
import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.rpc.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.shared.ActionException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by tanguy on 10/06/16.
 */
public class SearchHandler implements ActionHandler<SearchAction,SearchResult> {

    static private Logger logger = Logger.getLogger("SearchHandler");


    @Inject
    UserSession session;

    @Override
    public SearchResult execute(SearchAction searchAction, ExecutionContext executionContext) throws ActionException {
        String searchQuery = searchAction.getSearchQuery();
        String categorie = searchAction.getCategorie();
        boolean vosAnnonces = searchAction.getVosAnnonces();
        List<Annonces_opusk> results;

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("opusLaboratoire");
        EntityManager em = emf.createEntityManager();

        String cip =  session.getAdministrativeUserId();

        if(vosAnnonces)
        {
            results = em.createNamedQuery("getVosAnnonces", Annonces_opusk.class)
                    .setParameter(1,cip)
                    .getResultList();
        }
        else
        {
            if(categorie.equals("All"))
                categorie ="";

            results = em.createNamedQuery("getSearchResult", Annonces_opusk.class)
                    .setParameter(1, "%" + categorie +"%")
                    .setParameter(2, "%" + searchQuery + "%")
                    .setParameter(3,true)
                    .getResultList();

        }

        logger.log(Level.INFO,"nombres d'annonces trouvées : " + results.size());

        em.close();
        emf.close();

         return new SearchResult(results, vosAnnonces);

    }

    @Override
    public Class<SearchAction> getActionType() {
        return null;
    }

    @Override
    public void undo(SearchAction searchAction, SearchResult searchResult, ExecutionContext executionContext) throws ActionException {

    }
}
