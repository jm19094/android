package co.raffler.Networking;

import android.content.Context;
import com.android.volley.VolleyError;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.Collections;
import co.raffler.Model.RafflerModelObject;

public class RafflerArrayRequestHandler {

    public <T extends RafflerModelObject> void retrieveObjects(APIRequest request,
                                                               final ModelObjectFactory factory,
                                                               Context context,
                                                               final RafflerArrayListener<T> arrayListener) {

        request.retrievePayload(context,
                                HTTPMethod.GET,
                                null,
                                getResponseListener(factory, arrayListener));

    }

    private <T extends RafflerModelObject> RafflerAPIResponseListener getResponseListener(final ModelObjectFactory factory,
                                                                                          final RafflerArrayListener<T> listener) {

        return new RafflerAPIResponseListener() {
            @Override
            public void onResponse(JSONObject payload) {
                String arrayKey = factory.getDataKey();
                try {
                    JSONArray dataArray = payload.getJSONArray(arrayKey);
                    ArrayList<T> objects = new ArrayList<>(dataArray.length());
                    for (int i = 0; i < dataArray.length(); i++) {
                        JSONObject objectData = dataArray.getJSONObject(i);
                        T object = factory.get(objectData);
                        objects.add(object);
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
