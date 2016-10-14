package co.raffler.Networking;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by petemorris on 14/10/2016.
 */

public class RafflerRequestQueue {

    private static RafflerRequestQueue mInstance;
    private RequestQueue mRequestQueue;
    private static Context mContext;

    private RafflerRequestQueue(Context context) {
        mContext = context;
        mRequestQueue = Volley.newRequestQueue(mContext);
    }

    public static synchronized RafflerRequestQueue getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new RafflerRequestQueue(context);
        }
        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        return mRequestQueue;
    }

}
