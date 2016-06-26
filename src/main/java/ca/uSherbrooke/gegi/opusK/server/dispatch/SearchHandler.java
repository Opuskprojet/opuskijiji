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

/**
 * Created by tanguy on 10/06/16.
 */
public class SearchHandler implements ActionHandler<SearchAction,SearchResult> {


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

            results = em.createNamedQuery("getTEEEEEEEEESSST", Annonces_opusk.class)
                    .setParameter("cat", "%" + categorie +"%")
                    .setParameter("titre", "%" + searchQuery + "%")
                    .setParameter("stat",true)
                    .getResultList();

            /* if(categorie == "All")
            {
                if(searchQuery.isEmpty())
                {
                    results = em.createNamedQuery("getAllDefault", Annonces_opusk.class)
                            .setParameter(1, true)
                            .getResultList();
                }
                else
                {
                    results = em.createNamedQuery("getByTextOnly", Annonces_opusk.class)
                            .setParameter(1,searchQuery)
                            .setParameter(2, true)
                            .getResultList();
                }
            }
            else
            {
                if(searchQuery.isEmpty())
                {
                    results = em.createNamedQuery("getByCategorieOnly", Annonces_opusk.class)
                            .setParameter(1,categorie)
                            .setParameter(2, true)
                            .getResultList();
                }
                else
                {
                    results = em.createNamedQuery("getByBoth", Annonces_opusk.class)
                            .setParameter(1,categorie)
                            .setParameter(2, searchQuery)
                            .setParameter(3, true)
                            .getResultList();
                }
            }*/
        }


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
