package co.raffler.Model;

/**
 * Created by petemorris on 18/10/2016.
 */

public class Error {

    private String message;
    private Integer code;
    private String domain;

    public Error(String domain, Integer code, String message) {
        this.message = message;
        this.code = code;
        this.domain = domain;
    }

    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }

    public String getDomain() {
        return domain;
    }
}
