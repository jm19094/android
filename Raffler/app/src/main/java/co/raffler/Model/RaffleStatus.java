package co.raffler.Model;

/**
 * Created by petemorris on 12/10/2016.
 */

public class RaffleStatus {

    private Integer mJackpot;
    private Integer mJackpotIncludingReferrals;
    private String mTicket;
    private String mYesterdayTicket;
    private Boolean mIsYesterdayPrizeMonetary;
    private String mYesterdayPrizeDescription;
    private String mYesterdayPrizeIncludingReferralsDescription;
    private Boolean mYesterdayPrizeIsClaimed;
    private String mYesterdayPrizeWinToken;
    private String mYesterdayJackpotTicket;
    private String mResultsQuip;

    public Integer getJackpot() {
        return mJackpot;
    }

    public Integer getJackpotIncludingReferrals() {
        return mJackpotIncludingReferrals;
    }

    public String getTicket() {
        return mTicket;
    }

    public String getYesterdayTicket() {
        return mYesterdayTicket;
    }

    public Boolean getYesterdayPrizeMonetary() {
        return mIsYesterdayPrizeMonetary;
    }

    public String getYesterdayPrizeDescription() {
        return mYesterdayPrizeDescription;
    }

    public String getYesterdayPrizeIncludingReferralsDescription() {
        return mYesterdayPrizeIncludingReferralsDescription;
    }

    public Boolean getYesterdayPrizeIsClaimed() {
        return mYesterdayPrizeIsClaimed;
    }

    public String getYesterdayPrizeWinToken() {
        return mYesterdayPrizeWinToken;
    }

    public String getYesterdayJackpotTicket() {
        return mYesterdayJackpotTicket;
    }

    public String getResultsQuip() {
        return mResultsQuip;
    }
}
