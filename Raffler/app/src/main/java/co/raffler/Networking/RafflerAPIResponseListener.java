package co.raffler.Networking;

import com.android.volley.VolleyError;

import org.json.JSONObject;

public interface RafflerAPIResponseListener {
    void onResponse(JSONObject payload);
    void onErrorResponse(VolleyError error);
}
