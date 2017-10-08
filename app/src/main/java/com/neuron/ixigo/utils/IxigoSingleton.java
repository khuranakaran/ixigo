package com.neuron.ixigo.utils;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.StrictMode;

import com.neuron.ixigo.volley.RestClient;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Karan on 7/10/17.
 */

public class IxigoSingleton extends Application
{
    public static RestClient restClient;
    public boolean wasinbackground;
    Timer transitiontimer;
    int Thresholdtime=500;
    TimerTask mActivityTransitionTimerTask;
    private static IxigoSingleton singleton = null;
    @Override
    public void onCreate() {
        super.onCreate();
        init();
        singleton = this;

        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            builder.detectFileUriExposure();
        }

    }

   /* @Override
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        MultiDex.install(this);
    }*/

    public static IxigoSingleton getInstance() {

        return singleton;
    }

    public static Context getContext() {

        return singleton.getApplicationContext();
    }
    private void init(){
        restClient=new RestClient(this);
    }

    public static RestClient getRestClient() {
        return restClient;
    }
}
