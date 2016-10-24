package co.raffler.Networking;

import android.content.Context;

import org.json.JSONObject;

public interface APIRequest {
    void retrievePayload(Context context, HTTPMethod method, JSONObject params, RafflerAPIResponseListener listener);
}
