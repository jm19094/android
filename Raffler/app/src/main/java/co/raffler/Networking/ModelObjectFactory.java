package co.raffler.Networking;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by petemorris on 19/10/2016.
 */

public interface ModelObjectFactory<T> {
    T get(JSONObject payload) throws JSONException;
    String getDataKey();
}
