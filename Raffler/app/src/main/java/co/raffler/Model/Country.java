package co.raffler.Model;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import co.raffler.Networking.ModelObjectFactory;

/**
 * Created by petemorris on 12/10/2016.
 */

public class Country extends RafflerModelObject {

    public static class CountryFactory implements ModelObjectFactory {
        @Override
        public Country get(JSONObject payload) throws JSONException {
            return new Country(payload);
        }

        @Override
        public String getDataKey() {
            return "countries";
        }
    }

    private static final String ID_KEY = "id";
    private static final String NAME_KEY = "name";

    private Integer mId;
    private String mName;

    public Country(JSONObject payload) throws JSONException {
        super(payload);
    }

    @Override
    void bindPayload(JSONObject payload) throws JSONException {
        this.mId = payload.getInt(ID_KEY);
        this.mName = payload.getString(NAME_KEY);
    }

    public Integer getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }


}
