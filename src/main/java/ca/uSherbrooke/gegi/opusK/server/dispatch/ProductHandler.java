package ca.uSherbrooke.gegi.opusK.server.dispatch;

import ca.uSherbrooke.gegi.opusK.shared.dispatch.ProductAction;
import ca.uSherbrooke.gegi.opusK.shared.dispatch.ProductResult;
import ca.uSherbrooke.gegi.opusK.shared.dispatch.StatusChangeResult;
import ca.uSherbrooke.gegi.opusK.shared.entity.Annonces_opusk;
import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.rpc.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.shared.ActionException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by tanguy on 13/07/16
 */
public class ProductHandler implements ActionHandler<ProductAction,ProductResult> {
    @Override
    public ProductResult execute(ProductAction action, ExecutionContext executionContext) throws ActionException {
        int annonceId = action.getAnnonceId();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("opusLaboratoire");
        EntityManager em = emf.createEntityManager();

        Annonces_opusk annonce = em.find(Annonces_opusk.class,annonceId);

        em.close();
        emf.close();
        if(annonce != null)
        {
            return new ProductResult(annonce);
        }
        else {
            return null;
        }
    }

    @Override
    public Class<ProductAction> getActionType() {
        return null;
    }

    @Override
    public void undo(ProductAction productAction, ProductResult productResult, ExecutionContext executionContext) throws ActionException {

    }
}
