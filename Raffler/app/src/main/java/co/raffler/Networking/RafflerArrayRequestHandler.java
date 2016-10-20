package co.raffler.Networking;

import android.content.Context;
import android.util.Log;

import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import co.raffler.Model.RafflerModelObject;
import co.raffler.Networking.HTTPMethod;
import co.raffler.Networking.ModelObjectFactory;
import co.raffler.Networking.RafflerAPIRequest;
import co.raffler.Networking.RafflerAPIResponseListener;

/**
 * Created by petemorris on 19/10/2016.
 */

public class RafflerArrayRequestHandler {

    public void retrieveObjects(APIRequest request,
                                final ModelObjectFactory<RafflerModelObject> factory,
                                Context context,
                                final RafflerArrayListener arrayListener) {

        request.retrievePayload(context,
                                HTTPMethod.GET,
                                null,
                                getResponseListener(factory, arrayListener));

    }

    private RafflerAPIResponseListener getResponseListener(final ModelObjectFactory<RafflerModelObject> factory,
                                                           final RafflerArrayListener listener) {

        return new RafflerAPIResponseListener() {
            @Override
            public void onResponse(JSONObject payload) {
                String arrayKey = factory.getDataKey();
                try {
                    JSONArray dataArray = payload.getJSONArray(arrayKey);
                    ArrayList<RafflerModelObject> objects = new ArrayList<RafflerModelObject>(dataArray.length());
                    for (int i = 0; i < dataArray.length(); i++) {
                        JSONObject objectData = dataArray.getJSONObject(i);
                        objects.add( factory.get(objectData) );
                    }
                    if (objects.size() == 0) {
                        listener.onError();
                    } else {
                        listener.onGot(Collections.unmodifiableList(objects));
                    }
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
