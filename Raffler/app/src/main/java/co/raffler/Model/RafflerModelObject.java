package co.raffler.Model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by petemorris on 18/10/2016.
 */

public abstract class RafflerModelObject {

    public RafflerModelObject(JSONObject payload) throws JSONException {
        bindPayload(payload);
    }

    abstract void bindPayload(JSONObject payload) throws JSONException;

}
