package co.raffler.Model;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import co.raffler.Networking.ModelObjectFactory;

/**
 * Created by petemorris on 12/10/2016.
 */

public class Raffle extends RafflerModelObject {

    public static class RaffleFactory implements ModelObjectFactory {
        @Override
        public Raffle get(JSONObject payload) throws JSONException {
            return new Raffle(payload);
        }

        @Override
        public String getDataKey() {
            return null;
        }
    }

    private static final String ROLLOVER_DATE_KEY = "gmt_rollover_datetime";

    private Date mRolloverDate;
    private String mRolloverDateString;

    public Raffle(JSONObject payload) throws JSONException {
        super(payload);
    }

    @Override
    void bindPayload(JSONObject payload) throws JSONException {
        this.mRolloverDateString = payload.getString(ROLLOVER_DATE_KEY);
        try {
            this.mRolloverDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(mRolloverDateString);
        } catch (ParseException e) {
            throw new JSONException("Invalid date/time string in JSON");
        }
    }

    public Date getRolloverDate() {
        return mRolloverDate;
    }

    public String getRolloverDateString() {
        return mRolloverDateString;
    }

}
