package co.raffler.Model;

/**
 * Created by petemorris on 12/10/2016.
 */

public class Winner {

    private String name;
    private String winDateUK;
    private String winDateUS;
    private String largePictureURL;
    private String mediumPictureURL;
    private String smallPictureURL;
    private Boolean isMonetary;
    private String prizeDescription;
    private String prizeDescriptionWithReferrals;
    private String location;
    private Boolean claimed;
    private String ticket;

    public String getName() {
        return name;
    }

    public String getWinDateUK() {
        return winDateUK;
    }

    public String getWinDateUS() {
        return winDateUS;
    }

    public String getLargePictureURL() {
        return largePictureURL;
    }

    public String getMediumPictureURL() {
        return mediumPictureURL;
    }

    public String getSmallPictureURL() {
        return smallPictureURL;
    }

    public Boolean getMonetary() {
        return isMonetary;
    }

    public String getPrizeDescription() {
        return prizeDescription;
    }

    public String getPrizeDescriptionWithReferrals() {
        return prizeDescriptionWithReferrals;
    }

    public String getLocation() {
        return location;
    }

    public Boolean getClaimed() {
        return claimed;
    }

    public String getTicket() {
        return ticket;
    }
}
