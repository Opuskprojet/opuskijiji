package ca.uSherbrooke.gegi.opusK.shared.dispatch;

import ca.uSherbrooke.gegi.opusK.shared.entity.Annonces_opusk;
import com.gwtplatform.dispatch.rpc.shared.Result;

import java.util.List;

/**
 * Created by tanguy on 10/06/16.
 */

public class SearchResult implements Result {

    private List<Annonces_opusk> annonces;

    public SearchResult(final List<Annonces_opusk> annonces) {
        this.annonces = annonces;
    }

    /**
     * For serialization only.
     */
    @SuppressWarnings("unused")
    private SearchResult() {
    }

    public List<Annonces_opusk> getAnnonces() {
        return annonces;
    }
}
