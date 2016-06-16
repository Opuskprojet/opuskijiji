package ca.uSherbrooke.gegi.opusK.shared.dispatch;

import com.gwtplatform.dispatch.rpc.shared.ActionImpl;

/**
 * Created by tanguy on 10/06/16.
 */
public class SearchAction extends ActionImpl<SearchResult> {


    private String searchQuery;
    private String categorie;

    public SearchAction(String searchQuery, String categorie)
    {
        this.searchQuery = searchQuery;
        this.categorie = categorie;
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
}
