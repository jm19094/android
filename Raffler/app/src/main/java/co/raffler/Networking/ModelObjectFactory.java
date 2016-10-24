package co.raffler.Networking;

import org.json.JSONException;
import org.json.JSONObject;

import co.raffler.Model.RafflerModelObject;

public interface ModelObjectFactory {
    <T extends RafflerModelObject> T get(JSONObject payload) throws JSONException;
    String getDataKey();
}
