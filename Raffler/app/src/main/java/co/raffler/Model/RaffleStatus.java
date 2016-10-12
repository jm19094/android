package co.raffler.Model;

/**
 * Created by petemorris on 12/10/2016.
 */

public class RaffleStatus {

    private Integer jackpot;
    private Integer jackpotIncludingReferrals;
    private String ticket;
    private String yesterdayTicket;
    private Boolean isYesterdayPrizeMonetary;
    private String yesterdayPrizeDescription;
    private String yesterdayPrizeIncludingReferralsDescription;
    private Boolean yesterdayPrizeIsClaimed;
    private String yesterdayPrizeWinToken;
    private String yesterdayJackpotTicket;
    private String resultsQuip;

    public Integer getJackpot() {
        return jackpot;
    }

    public Integer getJackpotIncludingReferrals() {
        return jackpotIncludingReferrals;
    }

    public String getTicket() {
        return ticket;
    }

    public String getYesterdayTicket() {
        return yesterdayTicket;
    }

    public Boolean getYesterdayPrizeMonetary() {
        return isYesterdayPrizeMonetary;
    }

    public String getYesterdayPrizeDescription() {
        return yesterdayPrizeDescription;
    }

    public String getYesterdayPrizeIncludingReferralsDescription() {
        return yesterdayPrizeIncludingReferralsDescription;
    }

    public Boolean getYesterdayPrizeIsClaimed() {
        return yesterdayPrizeIsClaimed;
    }

    public String getYesterdayPrizeWinToken() {
        return yesterdayPrizeWinToken;
    }

    public String getYesterdayJackpotTicket() {
        return yesterdayJackpotTicket;
    }

    public String getResultsQuip() {
        return resultsQuip;
    }
}
