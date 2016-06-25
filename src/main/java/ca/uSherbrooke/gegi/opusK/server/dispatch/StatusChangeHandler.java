package ca.uSherbrooke.gegi.opusK.server.dispatch;

import ca.uSherbrooke.gegi.opusK.shared.dispatch.StatusChangeAction;
import ca.uSherbrooke.gegi.opusK.shared.dispatch.StatusChangeResult;
import ca.uSherbrooke.gegi.opusK.shared.entity.Annonces_opusk;
import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.rpc.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.shared.ActionException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by tanguy on 25/06/16.
 */
public class StatusChangeHandler implements ActionHandler<StatusChangeAction,StatusChangeResult> {


    @Override
    public StatusChangeResult execute(StatusChangeAction action, ExecutionContext executionContext) throws ActionException {

        String annonceId = action.getAnnonceId();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("opusLaboratoire");
        EntityManager em = emf.createEntityManager();

        Annonces_opusk annonce = em.find(Annonces_opusk.class,annonceId);

        if(annonce != null)
        {
            //annonce.setStatus = !annonce.getStatus;

            em.merge(annonce);
            em.close();
            emf.close();
            return new StatusChangeResult("Statut de l'annonce changé !");
        }
        else {
            em.close();
            emf.close();
            return new StatusChangeResult("Erreur annonce non trouvée");
        }
    }

    @Override
    public Class getActionType() {
        return null;
    }

    @Override
    public void undo(StatusChangeAction statusChangeAction, StatusChangeResult statusChangeResult, ExecutionContext executionContext) throws ActionException {

    }

}
