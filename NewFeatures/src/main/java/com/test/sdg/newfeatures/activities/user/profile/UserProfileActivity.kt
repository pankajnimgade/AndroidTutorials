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

package com.test.sdg.newfeatures.activities.user.profile

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.test.sdg.newfeatures.R
import kotlinx.android.synthetic.main.activity_user_profile.*

class UserProfileActivity : AppCompatActivity() {

    val TAG = "USER_PROFILE_ACTIVITY"
    val FRAGMENT_TAG = "FRAGMENT_CALLED"

    private lateinit var userProfile: UserProfile
    private  var isFragmentCalled:Boolean = false

    private lateinit var firstNameEditText: EditText
    private lateinit var lastNameEditText: EditText
    private lateinit var submitButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate(): ")
        setContentView(R.layout.activity_user_profile)
        setSupportActionBar(toolbar)

        if (savedInstanceState != null) {
            isFragmentCalled = savedInstanceState.getBoolean(FRAGMENT_TAG, false)
        }
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        initializeUI()
    }

    private fun initializeUI() {
        if (!isFragmentCalled) {
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            var fragment = UserProfileFragment.newInstance("123")
            fragmentTransaction.replace(R.id.UserProfileActivity_container_ContentFrameLayout, fragment,
                    "1123")
            fragmentTransaction.commit()
            isFragmentCalled = true
        }


        firstNameEditText = findViewById(R.id.UserProfileActivity_firstName_editText)
        lastNameEditText = findViewById(R.id.UserProfileActivity_lastName_editText)
        submitButton = findViewById(R.id.UserProfileActivity_submit_button)
        submitButton.setOnClickListener {
            if (!firstNameEditText.text.isNullOrEmpty() && !lastNameEditText.text.isNullOrEmpty()) {
                val firstNameText = firstNameEditText.text.toString()
                val lastNameText = lastNameEditText.text.toString()
                Log.d(TAG, ": Change $firstNameText and $lastNameText")
                val response = UserProfileRepository().getUserProfile(firstNameText, lastNameText)
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        Log.d(TAG, ": ")
        outState?.putBoolean(FRAGMENT_TAG,isFragmentCalled)
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, ": onStart()")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, ": onRestart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, ": onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, ": onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, ": onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, ": onDestroy()")
    }

}
