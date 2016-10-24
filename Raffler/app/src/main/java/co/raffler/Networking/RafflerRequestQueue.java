package co.raffler.Networking;

import android.content.Context;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

class RafflerRequestQueue {

    private static RafflerRequestQueue mInstance;
    private RequestQueue mRequestQueue;

    private RafflerRequestQueue(Context context) {
        mRequestQueue = Volley.newRequestQueue(context);
    }

    static synchronized RafflerRequestQueue getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new RafflerRequestQueue(context);
        }
        return mInstance;
    }

    RequestQueue getRequestQueue() {
        return mRequestQueue;
    }

}
