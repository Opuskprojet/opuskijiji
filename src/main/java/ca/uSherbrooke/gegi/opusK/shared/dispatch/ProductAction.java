package ca.uSherbrooke.gegi.opusK.shared.dispatch;

import com.gwtplatform.dispatch.rpc.shared.UnsecuredActionImpl;

/**
 * Created by tanguy on 13/07/16
 */
public class ProductAction extends UnsecuredActionImpl<ProductResult> {
    private int annonceId;

    public ProductAction(int annonceId)
    {
        this.annonceId = annonceId;
    }

    /**
     * For serialization only.
     */
    @SuppressWarnings("unused")
    private ProductAction() {
    }

    public int getAnnonceId()
    {
        return annonceId;
    }
}
