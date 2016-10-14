package co.raffler.Networking;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
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
    private static final Integer HTTP_TIMEOUT_DURATION = 10;

    private String mEndPoint;
    private Boolean mAuthenticated;
    private Integer mApiVersion;
    private Integer mHTTPMethod;
    private RequestQueue mRequestQueue;

    public RafflerAPIRequest(String endPoint, Integer method, Boolean authenticated, Integer apiVersion) {
        mEndPoint = endPoint;
        mHTTPMethod = method;
        mAuthenticated = authenticated;
        mApiVersion = apiVersion;
    }

    public void retrievePayload(Context context) {
        JsonObjectRequest request = new JsonObjectRequest(
                                    mHTTPMethod,
                                    mEndPoint,
                                    null,
                                    getResponseListener(),
                                    getErrorListener()) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = super.getHeaders();
                headers.putAll(getRafflerHeaders());
                return headers;
            }
        };
        request.setRetryPolicy(getRetryPolicy());
    }

    private Response.Listener<JSONObject> getResponseListener() {
        return new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

            }
        };
    }

    private Response.ErrorListener getErrorListener() {
        return new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        };
    }

    private Map<String, String> getRafflerHeaders() {
        HashMap<String, String> headers = new HashMap<String, String>(2);
        headers.put(API_VERSION_HEADER, "V" + mApiVersion);
        if (mAuthenticated) { headers.put(API_TOKEN_HEADER, "token goes here"); }
        return headers;
    }

    private DefaultRetryPolicy getRetryPolicy() {
        return new DefaultRetryPolicy(
                HTTP_TIMEOUT_DURATION,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
    }

}
