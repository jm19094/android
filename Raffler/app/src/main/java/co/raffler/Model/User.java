package co.raffler.Model;

import java.util.Date;

/**
 * Created by petemorris on 12/10/2016.
 */

public class User {

    private String mFirstName;
    private String mLastName;
    private String mEmailAddress;
    private Date mBirthday;
    private Country mCountry;
    private Province mProvince;
    private String mZipCode;
    private Boolean mIsMale;
    private String mReferralCode;
    private String mCurrencyCode;
    private RaffleStatus mRaffleStatus;

    public RaffleStatus getRaffleStatus() {
        return mRaffleStatus;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public String getEmailAddress() {
        return mEmailAddress;
    }

    public Date getBirthday() {
        return mBirthday;
    }

    public Country getCountry() {
        return mCountry;
    }

    public Province getProvince() {
        return mProvince;
    }

    public String getZipCode() {
        return mZipCode;
    }

    public Boolean getMale() {
        return mIsMale;
    }

    public String getReferralCode() {
        return mReferralCode;
    }

    public String getCurrencyCode() {
        return mCurrencyCode;
    }
}