package ca.uSherbrooke.gegi.opusK.shared.dispatch;

import com.gwtplatform.dispatch.rpc.shared.Result;

/**
 * Created by tanguy on 09/06/16.hjk
 */
public class RecupFormResult implements Result {

    private String response;

    public RecupFormResult(final String response) {
        this.response = response;
    }

    /**
     * For serialization only.
     */
    @SuppressWarnings("unused")
    private RecupFormResult() {
    }

    public String getResponse() {
        return response;
    }
}
