package co.raffler.Model;

import org.json.JSONException;
import org.json.JSONObject;

import co.raffler.Networking.ModelObjectFactory;

/**
 * Created by petemorris on 12/10/2016.
 */

public class Winner extends RafflerModelObject {

    public static class WinnerFactory implements ModelObjectFactory {
        @Override
        public Winner get(JSONObject payload) throws JSONException {
            return new Winner(payload);
        }

        @Override
        public String getDataKey() {
            return "winners";
        }
    }

    private static final String ID_KEY = "id";
    private static final String NAME_KEY = "name";
    private static final String DATE_OF_WIN_UK_KEY = "date_of_win_uk";
    private static final String DATE_OF_WIN_US_KEY = "date_of_win_us";
    private static final String TICKET_NUMBER_KEY = "ticket";
    private static final String PICTURE_SMALL_KEY = "display_picture_small";
    private static final String PICTURE_MEDIUM_KEY = "display_picture_medium";
    private static final String PICTURE_LARGE_KEY = "display_picture";
    private static final String MONETARY_KEY = "is_monetary";
    private static final String PRIZE_KEY = "prize";
    private static final String PRIZE_WITH_REFERRALS_KEY = "prize_with_referrals";
    private static final String LOCATION_KEY = "location";
    private static final String CLAIMED_KEY = "claimed";

    private String mName;
    private String mWinDateUK;
    private String mWinDateUS;
    private String mLargePictureURL;
    private String mMediumPictureURL;
    private String mSmallPictureURL;
    private Boolean mIsMonetary;
    private String mPrizeDescription;
    private String mPrizeDescriptionWithReferrals;
    private String mLocation;
    private Boolean mIsClaimed;
    private String mTicketNumber;

    public Winner(JSONObject payload) throws JSONException {
        super(payload);
    }

    @Override
    void bindPayload(JSONObject payload) throws JSONException {
        this.mName = payload.getString(NAME_KEY);
        this.mWinDateUK = payload.getString(DATE_OF_WIN_UK_KEY);
        this.mWinDateUS = payload.getString(DATE_OF_WIN_US_KEY);
        this.mLargePictureURL = payload.getString(PICTURE_LARGE_KEY);
        this.mMediumPictureURL = payload.getString(PICTURE_MEDIUM_KEY);
        this.mSmallPictureURL = payload.getString(PICTURE_SMALL_KEY);
        this.mIsMonetary = payload.getBoolean(MONETARY_KEY);
        this.mPrizeDescription = payload.getString(PRIZE_KEY);
        this.mPrizeDescriptionWithReferrals = payload.getString(PRIZE_WITH_REFERRALS_KEY);
        this.mLocation = payload.getString(LOCATION_KEY);
        this.mIsClaimed = payload.getBoolean(CLAIMED_KEY);
        this.mTicketNumber = payload.getString(TICKET_NUMBER_KEY);
    }

    public String getName() {
        return mName;
    }

    public String getWinDateUK() {
        return mWinDateUK;
    }

    public String getWinDateUS() {
        return mWinDateUS;
    }

    public String getLargePictureURL() {
        return mLargePictureURL;
    }

    public String getMediumPictureURL() {
        return mMediumPictureURL;
    }

    public String getSmallPictureURL() {
        return mSmallPictureURL;
    }

    public Boolean getMonetary() {
        return mIsMonetary;
    }

    public String getPrizeDescription() {
        return mPrizeDescription;
    }

    public String getPrizeDescriptionWithReferrals() {
        return mPrizeDescriptionWithReferrals;
    }

    public String getLocation() {
        return mLocation;
    }

    public Boolean getClaimed() {
        return mIsClaimed;
    }

    public String getTicket() {
        return mTicketNumber;
    }
}
