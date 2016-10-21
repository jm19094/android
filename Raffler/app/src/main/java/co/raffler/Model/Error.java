package co.raffler.Model;

/**
 * Created by petemorris on 18/10/2016.
 */

public class Error {

    private String mMessage;
    private Integer mCode;
    private String mDomain;

    public Error(String domain, Integer code, String message) {
        this.mMessage = message;
        this.mCode = code;
        this.mDomain = domain;
    }

    public String getMessage() {
        return mMessage;
    }

    public Integer getCode() {
        return mCode;
    }

    public String getDomain() {
        return mDomain;
    }
}
