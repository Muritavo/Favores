package com.paladino.favores.business;

import android.app.Application;

import com.facebook.FacebookSdk;

/**
 * Created by murit on 19/11/2016.
 */

public class Favores extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FacebookSdk.sdkInitialize(getApplicationContext());
    }
}
