package ca.uSherbrooke.gegi.opusK.shared.dispatch;

import ca.uSherbrooke.gegi.opusK.shared.entity.Annonces_opusk;
import com.gwtplatform.dispatch.rpc.shared.Result;

import java.util.List;

/**
 * Created by tanguy on 25/06/16.
 */
public class StatusChangeResult implements Result{

    private String response;

    public StatusChangeResult(final String response) {
        this.response = response;
    }

    /**
     * For serialization only.
     */
    @SuppressWarnings("unused")
    private StatusChangeResult() {
    }

    public String getResponse() {
        return response;
    }
}

