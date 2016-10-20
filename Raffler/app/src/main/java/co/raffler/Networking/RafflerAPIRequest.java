package co.raffler.Networking;

import android.content.Context;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by petemorris on 14/10/2016.
 */

public class RafflerAPIRequest implements APIRequest {

    private static final String API_VERSION_HEADER = "X-API-VERSION";
    private static final String API_TOKEN_HEADER  = "X-SESSION-TOKEN";
    private static final Integer HTTP_TIMEOUT_DURATION = 10000;
    private static final String PAYLOAD_KEY = "payload";

    private String mEndPoint;
    private Integer mApiVersion;
    private Boolean mAuthenticated;
    private RetryPolicy mRetryPolicy;

    public RafflerAPIRequest(String endPoint, Boolean authenticated, Integer apiVersion) {
        mEndPoint = endPoint;
        mApiVersion = apiVersion;
        mAuthenticated = authenticated;
        mRetryPolicy = getRetryPolicy(HTTP_TIMEOUT_DURATION);
    }

    public void retrievePayload(Context context, HTTPMethod method, JSONObject params, RafflerAPIResponseListener listener) {
        Request request = getRequest(context, method, params, listener);
        request.setRetryPolicy(mRetryPolicy);
        addRequestToQueue(request, context);
    }

    private void addRequestToQueue(Request request, Context context) {
        RafflerRequestQueue.getInstance(context)
                           .getRequestQueue()
                           .add(request);
    }

    private Request getRequest(Context context, HTTPMethod method, JSONObject params, RafflerAPIResponseListener listener) {
        return new RafflerJSONObjectRequest(getHTTPMethod(method),
                                            mEndPoint,
                                            params,
                                            getResponseListener(listener),
                                            getErrorListener(listener),
                                            getHeaders());
    }

    private Map<String, String> getHeaders() {
        HashMap<String, String> headers = new HashMap<String, String>();
        headers.put(API_VERSION_HEADER, "V" + mApiVersion);
        if (mAuthenticated) {
            headers.put(API_TOKEN_HEADER, "token goes here");
        }
        return headers;
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
                try {
                    JSONObject payload = response.getJSONObject(PAYLOAD_KEY);
                    listener.onResponse(payload);
                } catch (JSONException e) {
                    listener.onErrorResponse(null);
                }
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

    private DefaultRetryPolicy getRetryPolicy(Integer timeoutDuration) {
        return new DefaultRetryPolicy(timeoutDuration,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
    }

}