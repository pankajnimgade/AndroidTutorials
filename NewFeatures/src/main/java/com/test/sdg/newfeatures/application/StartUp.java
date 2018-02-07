package com.test.sdg.newfeatures.application;

import android.app.Application;
import android.util.Log;

import com.test.sdg.newfeatures.application.constants.Constants;

/**
 * Created by Pankaj Nimgade on 2/4/2018.
 */

public class StartUp extends Application {

    public static final String TAG = "START_UP";


    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: " + Constants.APPLICATION_NAME);
    }
}
