package co.raffler.Networking;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import org.json.JSONObject;
import java.util.Map;

public class RafflerJSONObjectRequest extends JsonObjectRequest {

    private Map<String, String> mAdditionalHeaders;

    public RafflerJSONObjectRequest(Integer method, String url, JSONObject jsonRequest, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener, Map<String, String> headers) {
        super(method, url, jsonRequest, listener, errorListener);
        mAdditionalHeaders = headers;
    }

    public Map<String, String> getAdditionalHeaders() {
        return mAdditionalHeaders;
    }

    public void setAdditionalHeaders(Map<String, String> mHeaders) {
        this.mAdditionalHeaders = mHeaders;
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        mAdditionalHeaders.putAll(super.getHeaders());
        return mAdditionalHeaders;
    }

}
