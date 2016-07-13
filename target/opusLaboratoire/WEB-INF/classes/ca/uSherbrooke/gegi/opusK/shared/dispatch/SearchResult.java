package ca.uSherbrooke.gegi.opusK.shared.dispatch;

import ca.uSherbrooke.gegi.opusK.shared.entity.Annonces_opusk;
import com.gwtplatform.dispatch.rpc.shared.Result;

import java.util.List;

/**
 * Created by tanguy on 10/06/16
 */

public class SearchResult implements Result {

    private List<Annonces_opusk> annonces;
    private Boolean vosAnnonces;

    public SearchResult(final List<Annonces_opusk> annonces, final boolean vosAnnonces) {
        this.annonces = annonces;
        this.vosAnnonces = vosAnnonces;
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

    public Boolean getVosAnnonces() {
        return vosAnnonces;
    }
}
