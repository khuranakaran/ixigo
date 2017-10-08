package com.neuron.ixigo.volley;

import com.android.volley.Response;
import com.android.volley.VolleyError;

public interface ResponseListener<T> extends Response.Listener<T>, Response.ErrorListener {
    void onSuccessResponse(T responseData);
    void onErrorResponse(VolleyError error);
}
