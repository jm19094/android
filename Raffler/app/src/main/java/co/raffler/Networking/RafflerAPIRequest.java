package co.raffler.Networking;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by petemorris on 14/10/2016.
 */

public class RafflerAPIRequest {

    private static final String API_VERSION_HEADER = "X-API-VERSION";
    private static final String API_TOKEN_HEADER  = "X-SESSION-TOKEN";
    private static final Integer HTTP_TIMEOUT_DURATION = 10000;

    private String mEndPoint;
    private Boolean mAuthenticated;
    private Integer mApiVersion;

    public RafflerAPIRequest(String endPoint, Boolean authenticated, Integer apiVersion) {
        mEndPoint = endPoint;
        mAuthenticated = authenticated;
        mApiVersion = apiVersion;
    }

    public void retrievePayload(Context context, HTTPMethod method, JSONObject params, RafflerAPIResponseListener listener) {

        JsonObjectRequest request = new JsonObjectRequest(
                                    getHTTPMethod(method),
                                    mEndPoint,
                                    params,
                                    getResponseListener(listener),
                                    getErrorListener(listener)) {

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = super.getHeaders();
                HashMap<String, String> rafflerHeaders = new HashMap<String, String>();
                rafflerHeaders.put(API_VERSION_HEADER, "V" + mApiVersion);
                if (mAuthenticated) { rafflerHeaders.put(API_TOKEN_HEADER, "token goes here"); }
                rafflerHeaders.putAll(headers);
                return rafflerHeaders;
            }
        };
        request.setRetryPolicy(getRetryPolicy());
        RafflerRequestQueue.getInstance(context)
                           .getRequestQueue()
                           .add(request);
    }

    private Integer getHTTPMethod(HTTPMethod method) {
        switch (method) {
            case POST:
                return Request.Method.POST;
            case PUT:
                return Request.Method.PUT;
            default:
                return Request.Method.GET;
        }
    }

    private Response.Listener<JSONObject> getResponseListener(final RafflerAPIResponseListener listener) {
        return new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                listener.onResponse(response);
            }
        };
    }

    private Response.ErrorListener getErrorListener(final RafflerAPIResponseListener listener) {
        return new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.onErrorResponse(error);
            }
        };
    }

    private DefaultRetryPolicy getRetryPolicy() {
        return new DefaultRetryPolicy(
                HTTP_TIMEOUT_DURATION,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
    }

}