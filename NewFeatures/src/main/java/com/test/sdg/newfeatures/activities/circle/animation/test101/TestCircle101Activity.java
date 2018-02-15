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

package com.test.sdg.newfeatures.activities.circle.animation.test101;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;

import com.test.sdg.newfeatures.R;

public class TestCircle101Activity extends AppCompatActivity {

    private static final String TAG = "TEST_CIRCLE";

    private LinearLayout rootLayout;
    private float centerX;
    private float centerY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_circle101);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initializeUI();
    }

    private void initializeUI() {
        rootLayout = findViewById(R.id.TestCircle101Activity_root_layout);

        ViewTreeObserver vto = rootLayout.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                calculateCenterCoordinates();
            }
        });

    }

    private void calculateCenterCoordinates() {
        Display display = getWindowManager().getDefaultDisplay();
        centerX = rootLayout.getWidth() / 2;
        Log.d(TAG, "calculateCenterCoordinates: rootLayout.getHeight(): "+rootLayout.getHeight());
        centerY = rootLayout.getHeight() / 2;

        Log.d(TAG, "calculateCenterCoordinates: centerX: "+centerX);
        Log.d(TAG, "calculateCenterCoordinates: centerY: "+centerY);
    }

    private void createCircleWithRadius(float radius) {


    }

}
