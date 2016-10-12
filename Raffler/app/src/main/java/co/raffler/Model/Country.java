package co.raffler.Model;

import java.util.ArrayList;

/**
 * Created by petemorris on 12/10/2016.
 */

public class Country {

    private Integer id;
    private String name;
    private ArrayList<Province> provinces;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Province> getProvinces() {
        return provinces;
    }
}
