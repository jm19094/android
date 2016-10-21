package co.raffler.Model;

import java.util.Date;

/**
 * Created by petemorris on 12/10/2016.
 */

public class Raffle {

    private Date mRolloverDate;
    private String mRolloverDateString;
    private Integer mRolloverSecondsRemaining;

    public Date getRolloverDate() {
        return mRolloverDate;
    }

    public String getRolloverDateString() {
        return mRolloverDateString;
    }

    public Integer getRolloverSecondsRemaining() {
        return mRolloverSecondsRemaining;
    }
}
