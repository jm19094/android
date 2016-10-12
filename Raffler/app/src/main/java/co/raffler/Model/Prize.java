package co.raffler.Model;

/**
 * Created by petemorris on 12/10/2016.
 */

public class Prize {

    private String description;
    private Boolean isMonetary;
    private Integer position;
    private Integer numberOfWinners;

    public String getDescription() {
        return description;
    }

    public Boolean getMonetary() {
        return isMonetary;
    }

    public Integer getPosition() {
        return position;
    }

    public Integer getNumberOfWinners() {
        return numberOfWinners;
    }
}
