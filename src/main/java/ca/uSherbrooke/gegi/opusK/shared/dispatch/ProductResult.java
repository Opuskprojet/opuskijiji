package ca.uSherbrooke.gegi.opusK.shared.dispatch;

import ca.uSherbrooke.gegi.opusK.shared.entity.Annonces_opusk;
import com.gwtplatform.dispatch.rpc.shared.Result;

/**
 * Created by tanguy on 13/07/16
 */
public class ProductResult implements Result{


        private Annonces_opusk annonces;


        public ProductResult(final Annonces_opusk annonces) {
            this.annonces = annonces;
        }

        /**
         * For serialization only.
         */
        @SuppressWarnings("unused")
        private ProductResult() {
        }

        public Annonces_opusk getAnnonce() {
            return annonces;
        }

}


