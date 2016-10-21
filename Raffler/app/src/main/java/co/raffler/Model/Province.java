package co.raffler.Model;

import org.json.JSONException;
import org.json.JSONObject;

import co.raffler.Networking.ModelObjectFactory;

/**
 * Created by petemorris on 12/10/2016.
 */

public class Province extends RafflerModelObject {

    public static class ProvinceFactory implements ModelObjectFactory {
        @Override
        public Province get(JSONObject payload) throws JSONException {
            return new Province(payload);
        }

        @Override
        public String getDataKey() {
            return "provinces";
        }
    }

    private static final String ID_KEY = "id";
    private static final String NAME_KEY = "name";
    private static final String ACTIVE_KEY = "active";

    private Integer mId;
    private String mName;
    private Boolean mIsActive;

    public Province(JSONObject payload) throws JSONException {
        super(payload);
    }

    @Override
    void bindPayload(JSONObject payload) throws JSONException {
        this.mId = payload.getInt(ID_KEY);
        this.mName = payload.getString(NAME_KEY);
        this.mIsActive = payload.getBoolean(ACTIVE_KEY);
    }

    public Integer getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public Boolean getIsActive() { return mIsActive;  }

}
