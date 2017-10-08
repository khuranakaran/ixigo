package com.neuron.ixigo.volley;

import android.annotation.SuppressLint;
import android.util.Log;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;

public abstract class RequestCallback<T> implements ResponseListener<T> {


    @SuppressLint("LongLogTag")
    @Override
    public void onSuccessResponse(T responseData) {
       // NotificationUtils.dismissProgressDialog();
       // progressDialog.dismiss();
        Log.e("volley response responseData onSuccessResponse", responseData.toString());
        onSuccessRestResponse(null, responseData);
    }
    @SuppressLint("LongLogTag")
    @Override
    public void onErrorResponse(VolleyError error) {
       // NotificationUtils.dismissProgressDialog();
        //progressDialog.dismiss();
        if (error.networkResponse != null && error.networkResponse.data != null) {
            try {
                if (error.networkResponse.headers != null) {
                    String errorString = new String(error.networkResponse.data, HttpHeaderParser.parseCharset(error.networkResponse.headers));
                    Log.e("volleyresponse errorString onErrorResponse", errorString);
                    Log.d("volley response errorString onErrorResponse", errorString);
                    onErrorRestResponse(error);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* @Override
    public void onErrorResponse(VolleyError error) {
        NotificationUtils.dismissProgressDialog();
        if (error.networkResponse != null && error.networkResponse.data != null) {
            try {
                if (error.networkResponse.headers != null) {
                    String errorString = new String(error.networkResponse.data, HttpHeaderParser.parseCharset(error.networkResponse.headers));
                    Log.e("error", errorString);
                }
            } catch (Exception e) {
                e.printStackTrace();

            }
        }
    }*/

    public abstract void onSuccessRestResponse(Exception e, T result);

    public abstract void onErrorRestResponse(VolleyError error);

}
