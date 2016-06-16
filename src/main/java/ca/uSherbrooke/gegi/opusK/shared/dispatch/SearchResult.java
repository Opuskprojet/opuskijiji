package ca.uSherbrooke.gegi.opusK.shared.dispatch;

import com.gwtplatform.dispatch.rpc.shared.Result;

import java.util.List;

/**
 * Created by tanguy on 10/06/16.
 */

// REMPLACER STRING PAR TYPE ENTITY
public class SearchResult implements Result {

    private List<String> annonces;

    public SearchResult(final List<String> annonces) {
        this.annonces = annonces;
    }

    /**
     * For serialization only.
     */
    @SuppressWarnings("unused")
    private SearchResult() {
    }

    public List<String> getAnnonces() {
        return annonces;
    }
}
