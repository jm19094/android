package co.raffler.Networking;

import java.util.List;
import co.raffler.Model.RafflerModelObject;

public interface RafflerArrayListener<T extends RafflerModelObject> {
    void onGot(List<T> objects);
    void onError();
}