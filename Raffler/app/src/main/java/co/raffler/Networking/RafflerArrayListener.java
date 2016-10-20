package co.raffler.Networking;

import java.util.List;

import co.raffler.Model.RafflerModelObject;

/**
 * Created by petemorris on 20/10/2016.
 */

public interface RafflerArrayListener<T extends RafflerModelObject> {
    void onGot(List<T> objects);
    void onError();
}