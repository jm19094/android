package co.raffler.Networking;

import android.content.Context;

import org.json.JSONObject;

/**
 * Created by petemorris on 20/10/2016.
 */

public interface APIRequest {
    void retrievePayload(Context context, HTTPMethod method, JSONObject params, RafflerAPIResponseListener listener);
}
