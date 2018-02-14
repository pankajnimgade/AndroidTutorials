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

package com.test.sdg.newfeatures.activities.live.data;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.test.sdg.newfeatures.R;

public class LiveDataActivity extends AppCompatActivity {

    private static final String TAG = "LIVE_DATA_ACTIVITY";

    private TestViewModel testViewModel;

    private EditText emailAddressEditText;
    private EditText phoneNumberEditText;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_data);
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
        emailAddressEditText = findViewById(R.id.LiveDataActivity_email_address_editText);
        phoneNumberEditText = findViewById(R.id.LiveDataActivity_phone_number_editText);
        saveButton = findViewById(R.id.LiveDataActivity_save_button);

        testViewModel = ViewModelProviders.of(this).get(TestViewModel.class);
        testViewModel.getMutableLiveData().observe(this, testUser -> {
            emailAddressEditText.setText(testUser.getEmailAddress());
            phoneNumberEditText.setText(testUser.getPhoneNumber());
        });

        saveButton.setOnClickListener(view -> {
            testViewModel.setTestUser(emailAddressEditText.getText().toString(),
                    phoneNumberEditText.getText().toString());
        });
    }
}
