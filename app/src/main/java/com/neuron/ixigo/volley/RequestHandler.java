package com.neuron.ixigo.volley;

import com.android.volley.Request;

public class RequestHandler {
    final private Request mRequest;
    public RequestHandler(Request request) {
        mRequest = request;
    }
    public void cancel() {
        mRequest.cancel();
    }
}