package co.raffler.API;

import android.content.Context;
import android.util.Log;

import com.android.volley.VolleyError;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import co.raffler.Networking.HTTPMethod;
import co.raffler.Networking.RafflerAPIRequest;
import co.raffler.Networking.RafflerAPIResponseListener;

/**
 * Created by petemorris on 15/10/2016.
 */

public class UserAccount {

    public void authenticate(Context context, String email, String password, final UserAccountAuthenticationListener authenticationListener) {
        JSONObject params = new JSONObject();
        try {
            params.put("email", email);
            params.put("password", password);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        new RafflerAPIRequest("https://api.raffler.co/auth/login", false, 1)
                .retrievePayload(context, HTTPMethod.POST, params, new RafflerAPIResponseListener() {
                    @Override
                    public void onResponse(JSONObject payload) {
                        authenticationListener.onAuthentication();
                        Log.d("login", payload.toString());
                    }

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        authenticationListener.onAuthenticationError();
                        Log.d("login", error.toString());
                    }
                });
    }

}