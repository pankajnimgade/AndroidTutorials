package com.test.sdg.newfeatures.application;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.util.Log;

import com.test.sdg.newfeatures.application.constants.Constants;

/**
 * Created by Pankaj Nimgade on 2/4/2018.
 */

public class StartUp extends Application {

    public static final String TAG = "START_UP";
    private RoomDatabase roomDatabase;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: " + Constants.APPLICATION_NAME);
    }

    public RoomDatabase getRoomDatabase() {
        return roomDatabase;
    }
}
