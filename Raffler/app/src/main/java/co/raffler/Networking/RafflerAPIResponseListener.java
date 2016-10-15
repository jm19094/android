package co.raffler.Networking;

import com.android.volley.VolleyError;

import org.json.JSONObject;

/**
 * Created by petemorris on 15/10/2016.
 */

public interface RafflerAPIResponseListener {
    void onResponse(JSONObject payload);
    void onErrorResponse(VolleyError error);
}
