package ca.uSherbrooke.gegi.opusK.server.dispatch;

import ca.uSherbrooke.gegi.commons.core.server.utils.UserSession;
import ca.uSherbrooke.gegi.opusK.shared.dispatch.RecupFormAction;
import ca.uSherbrooke.gegi.opusK.shared.dispatch.RecupFormResult;
import ca.uSherbrooke.gegi.opusK.shared.entity.Annonces_opusk;
import ca.uSherbrooke.gegi.persist.dao.Dao;
import com.google.inject.Inject;
import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.rpc.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.shared.ActionException;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by tanguy on 09/06/16.
 */
public class RecupFormHandler implements ActionHandler<RecupFormAction,RecupFormResult>{

    static private Logger logger = Logger.getLogger("RecupFormHandler");


    //@Inject
    //private Dao myDao;

    @Inject
    private UserSession session;

    @Override
    public RecupFormResult execute(RecupFormAction action, ExecutionContext executionContext) throws ActionException {

        int idUser = session.getUserId();

        logger.log(Level.INFO,"id : " + idUser);


        List<String> datas = action.getDatas();

        Annonces_opusk annonce = new Annonces_opusk();

        annonce.setCip("buctTest");
        annonce.setTypeAnnonce(datas.get(0));
        annonce.setCategorie(datas.get(1));
        annonce.setTitre(datas.get(2));
        annonce.setDescription(datas.get(3));
        annonce.setPrix(datas.get(4));
        annonce.setMarque(datas.get(5));
        annonce.setEtat1(datas.get(6));
        annonce.setEtat3(datas.get(7));
        annonce.setPieces(datas.get(8));
        annonce.setSurface(Double.valueOf(datas.get(9)));
        annonce.setJardin(Boolean.valueOf(datas.get(10)));
        annonce.setEtat2(datas.get(11));
        annonce.setIsbn(datas.get(12));
        annonce.setAuteur(datas.get(13));



      //   myDao.persist(annonce);


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
