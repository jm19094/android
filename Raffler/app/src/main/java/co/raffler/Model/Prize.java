package co.raffler.Model;

import org.json.JSONException;
import org.json.JSONObject;
import co.raffler.Networking.ModelObjectFactory;

/**
 * Created by petemorris on 12/10/2016.
 */

public class Prize extends RafflerModelObject {

    public static class PrizeFactory implements ModelObjectFactory {
        @Override
        public Prize get(JSONObject payload) throws JSONException {
            return new Prize(payload);
        }

        @Override
        public String getDataKey() {
            return "prizes";
        }
    }

    private static final String PRIZE_KEY = "prize";
    private static final String MONETARY_KEY = "monetary";
    private static final String POSITION_KEY = "position";
    private static final String TOTAL_WINNERS_KEY = "total_winners";

    private String mDescription;
    private Boolean mIsMonetary;
    private Integer mPosition;
    private Integer mNumberOfWinners;

    public Prize(JSONObject payload) throws JSONException {
        super(payload);
    }

    @Override
    void bindPayload(JSONObject payload) throws JSONException {
        this.mDescription = payload.getString(PRIZE_KEY);
        this.mIsMonetary = payload.getBoolean(MONETARY_KEY);
        this.mPosition = payload.getInt(POSITION_KEY);
        this.mNumberOfWinners = payload.getInt(TOTAL_WINNERS_KEY);
    }

    public String getDescription() {
        return mDescription;
    }

    public Boolean getMonetary() {
        return mIsMonetary;
    }

    public Integer getPosition() {
        return mPosition;
    }

    public Integer getNumberOfWinners() {
        return mNumberOfWinners;
    }
}
