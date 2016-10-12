package co.raffler.Model;

import java.util.Date;

/**
 * Created by petemorris on 12/10/2016.
 */

public class User {

    private String firstName;
    private String lastName;
    private String emailAddress;
    private Date birthday;
    private Country country;
    private Province province;
    private String zipCode;
    private Boolean isMale;
    private String referralCode;
    private String currencyCode;
    private RaffleStatus raffleStatus;

    public RaffleStatus getRaffleStatus() {
        return raffleStatus;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public Date getBirthday() {
        return birthday;
    }

    public Country getCountry() {
        return country;
    }

    public Province getProvince() {
        return province;
    }

    public String getZipCode() {
        return zipCode;
    }

    public Boolean getMale() {
        return isMale;
    }

    public String getReferralCode() {
        return referralCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }
}