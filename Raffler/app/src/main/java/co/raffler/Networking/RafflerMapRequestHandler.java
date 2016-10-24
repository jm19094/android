package co.raffler.Networking;

import android.content.Context;
import com.android.volley.VolleyError;
import org.json.JSONException;
import org.json.JSONObject;
import co.raffler.Model.RafflerModelObject;

public class RafflerMapRequestHandler {

    public <T extends RafflerModelObject> void retrieveObject(APIRequest request,
                                                              final ModelObjectFactory factory,
                                                              Context context,
                                                              final RafflerMapListener<T> mapListener) {

        request.retrievePayload(context,
                HTTPMethod.GET,
                null,
                getResponseListener(factory, mapListener));

    }

    private <T extends RafflerModelObject> RafflerAPIResponseListener getResponseListener(final ModelObjectFactory factory,
                                                                                          final RafflerMapListener<T> listener) {

        return new RafflerAPIResponseListener() {
            @Override
            public void onResponse(JSONObject payload) {
                try {
                    T object = factory.get(payload);
                    listener.onGot(object);
                } catch (JSONException e) {
                    e.printStackTrace();
                    listener.onError();
                }
            }

            @Override
            public void onErrorResponse(VolleyError error) {
                listener.onError();
            }
        };

    }

}
