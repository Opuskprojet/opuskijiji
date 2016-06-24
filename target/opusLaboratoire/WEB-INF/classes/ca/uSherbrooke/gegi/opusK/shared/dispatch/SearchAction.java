package ca.uSherbrooke.gegi.opusK.shared.dispatch;

import com.gwtplatform.dispatch.rpc.shared.UnsecuredActionImpl;

/**
 * Created by tanguy on 10/06/16.
 */
public class SearchAction extends UnsecuredActionImpl<SearchResult> {


    private String searchQuery;
    private String categorie;
    private boolean vosAnnonces;

    public SearchAction(String searchQuery, String categorie, boolean vosAnnonces)
    {
        this.searchQuery = searchQuery;
        this.categorie = categorie;
        this.vosAnnonces = vosAnnonces;
    }

    /**
     * For serialization only.
     */
    @SuppressWarnings("unused")
    private SearchAction() {
    }

    public String getSearchQuery() {
        return searchQuery;
    }

    public String getCategorie() {
        return categorie;
    }

    public boolean getVosAnnonces(){return vosAnnonces;}
}
