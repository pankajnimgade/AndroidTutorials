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

package com.test.sdg.newfeatures.activities.user.profile;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

/**
 * Created by Pankaj Nimgade on 2/7/2018.
 */

public class UserProfileViewModel extends ViewModel {

    private static final String TAG = "USER_PROFILE_VIEW_MODEL";

    private String userId;
    private LiveData<UserProfile> userProfile;
    private UserProfileRepository userProfileRepository = new UserProfileRepository();

    public void init(String userId) {
        this.userId = userId;
        if (userProfile != null) {
            Log.d(TAG, "##init: not null##");
            return;
        }else{
            Log.e(TAG, "init: null__");
        }
        Log.d(TAG, "init: didn't break so create user profile");
        userProfile = userProfileRepository.getUserProfile("initialFirstName", "initialLastName");
    }

    public String getUserId() {
        return userId;
    }


    public LiveData<UserProfile> getUserProfile() {
        return userProfile;
    }
}
