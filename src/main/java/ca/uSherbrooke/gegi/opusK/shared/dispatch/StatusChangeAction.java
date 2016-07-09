package ca.uSherbrooke.gegi.opusK.shared.dispatch;

import com.gwtplatform.dispatch.rpc.shared.UnsecuredActionImpl;

/**
 * Created by tanguy on 25/06/16.
 */
public class StatusChangeAction extends UnsecuredActionImpl<StatusChangeResult> {


    private int annonceId;

    public StatusChangeAction(int annonceId)
    {
        this.annonceId = annonceId;
    }

    /**
     * For serialization only.
     */
    @SuppressWarnings("unused")
    private StatusChangeAction() {
    }

    public int getAnnonceId()
    {
        return annonceId;
    }
}
