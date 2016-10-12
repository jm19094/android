package co.raffler.Model;

import java.util.Date;

/**
 * Created by petemorris on 12/10/2016.
 */

public class Raffle {

    private Date rolloverDate;
    private String rolloverDateString;
    private Integer rolloverSecondsRemaining;

    public Date getRolloverDate() {
        return rolloverDate;
    }

    public String getRolloverDateString() {
        return rolloverDateString;
    }

    public Integer getRolloverSecondsRemaining() {
        return rolloverSecondsRemaining;
    }
}
