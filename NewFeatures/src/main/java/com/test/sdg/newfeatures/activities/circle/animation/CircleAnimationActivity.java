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

package com.test.sdg.newfeatures.activities.circle.animation;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.test.sdg.newfeatures.R;

public class CircleAnimationActivity extends AppCompatActivity {

    private static final String TAG = "CIRCLE_ANIMATION";
    private Button referencePointButton;
    private LinearLayout linearLayout;

    private CircleView[] cardViews = new CircleView[5];
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_animation);
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
        handler = new Handler();


        cardViews[0] = findViewById(R.id.CircleView_0);
        cardViews[0].setStrokeWidth(5);
        cardViews[0].invalidate();

        cardViews[1] = findViewById(R.id.CircleView_1);
        cardViews[1].setStrokeWidth(2);
        cardViews[1].invalidate();

        cardViews[2] = findViewById(R.id.CircleView_2);
        cardViews[2].setStrokeWidth(5);
        cardViews[2].invalidate();

        cardViews[3] = findViewById(R.id.CircleView_3);
        cardViews[3].setStrokeWidth(2);
        cardViews[3].invalidate();

        cardViews[4] = findViewById(R.id.CircleView_4);
        cardViews[4].setStrokeWidth(5);
        cardViews[4].invalidate();

        int counter = 0;
        for (CircleView circleView : cardViews) {
            counter += 200;
            handler.postDelayed(() -> circleView.setVisibility(View.VISIBLE), counter);
        }
    }


}
