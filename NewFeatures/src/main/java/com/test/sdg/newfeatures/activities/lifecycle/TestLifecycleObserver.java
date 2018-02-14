/*
 *  Copyright 2017 The Android Open Source Project
 *  Licensed under the @{PK Solutions} , Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *       http://www.example.org/licenses/LICENSE-2.0 {this is not required (^.^) }
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.test.sdg.newfeatures.activities.lifecycle;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.util.Log;

/**
 * Created by Pankaj Nimgade on 2/13/2018.
 */

public class TestLifecycleObserver implements LifecycleObserver {

    private static final String TAG = "TestLifecycleObserver";

    private Context context;
    private LifecycleOwner lifecycleOwner;
    private UiCallback uiCallback;
    private String testText;

    public void setTestText(String testText) {
        this.testText = testText;
    }

    public TestLifecycleObserver(Context context, LifecycleOwner lifecycleOwner, UiCallback uiCallback) {
        this.context = context;
        this.lifecycleOwner = lifecycleOwner;
        this.lifecycleOwner.getLifecycle().addObserver(this);
        this.uiCallback = uiCallback;
        testText = "";
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void createObserving() {
        Log.d(TAG, "createObserving: ");
        if (testText != null && !testText.isEmpty()) {
            Log.d(TAG, "createObserving: setting up the on create previous text");
            uiCallback.updateUI(testText);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    void startObserving() {
        Log.d(TAG, "startObserving: ");
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    void resumeObserving() {
        Log.d(TAG, "resumeObserving: ");
        if (testText != null && !testText.isEmpty()) {
            Log.d(TAG, "resumeObserving: setting up the previous text");
            uiCallback.updateUI(testText);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    void pauseObserving() {
        Log.d(TAG, "pauseObserving: ");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    void stopObserving() {
        Log.d(TAG, "stopObserving: ");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void destroyObserving() {
        Log.d(TAG, "destroyObserving: ");
        testText = "";
    }
}
