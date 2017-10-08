package com.neuron.ixigo.volley;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.neuron.ixigo.models.FlightSearch;

import org.json.JSONObject;

public class RestClient {

    VolleyManager mVolleyManager;
    private SharedPreferences preferences;
    String token;

    public VolleyManager getmVolleyManager() {
        return mVolleyManager;
    }

    GsonRequest gsonRequest;
    Context context;
    protected static final String PROTOCOL_CHARSET = "utf-8";
    protected static final String PROTOCOL_CONTENT_TYPE = String.format("application/json; charset=%s", PROTOCOL_CHARSET);

    public RestClient(Context appContext) {
        mVolleyManager = new VolleyManager(appContext);
        this.context = appContext;
    }

    public RequestHandler getFlightSearch(String url, final RequestCallback<FlightSearch> listener, JSONObject request) {

        gsonRequest = new GsonRequest<>(Request.Method.GET, url, FlightSearch.class, request, listener, context);
        gsonRequest.setRetryPolicy(new RetryPolicy() {
            @Override
            public int getCurrentTimeout() {
                return 360000;
            }

            @Override
            public int getCurrentRetryCount() {
                return 2;
            }

            @Override
            public void retry(VolleyError error) throws VolleyError {
            Log.e("RetryPolicy", error.toString());
            }
        });
        return new RequestHandler(mVolleyManager.addToRequestQueue(gsonRequest));
    }
}
