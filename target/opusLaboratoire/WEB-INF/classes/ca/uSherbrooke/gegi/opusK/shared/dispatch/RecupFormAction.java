package ca.uSherbrooke.gegi.opusK.shared.dispatch;

import com.gwtplatform.dispatch.rpc.shared.UnsecuredActionImpl;

import java.util.List;

/**
 * Created by tanguy on 09/06/16.
 */
public class RecupFormAction extends UnsecuredActionImpl<RecupFormResult> {

    private List<String> datas;

    public RecupFormAction(List<String> datas)
    {
        this.datas = datas;
    }

    /**
     * For serialization only.
     */
    @SuppressWarnings("unused")
    private RecupFormAction() {
    }

    public List<String> getDatas()
    {
        return datas;
    }
}
