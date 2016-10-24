package co.raffler.Networking;

import co.raffler.Model.RafflerModelObject;

public interface RafflerMapListener<T extends RafflerModelObject> {
    void onGot(T object);
    void onError();
}
