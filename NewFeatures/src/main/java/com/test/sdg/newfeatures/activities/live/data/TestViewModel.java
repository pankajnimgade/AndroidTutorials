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

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

/**
 * Created by Pankaj Nimgade on 2/14/2018.
 */

public class TestViewModel extends ViewModel {

    private MutableLiveData<TestUser> mutableLiveData;


    public MutableLiveData<TestUser> getMutableLiveData() {
        if (mutableLiveData == null) {
            mutableLiveData = new MutableLiveData<>();
            mutableLiveData.setValue(new TestUser());
        }
        return mutableLiveData;
    }

    public void setTestUser(String emailAddress, String phoneNumber) {
        if (emailAddress == null || phoneNumber == null || emailAddress.trim().isEmpty() ||
                phoneNumber.trim().isEmpty()) {
            //ignore invalid information
            return;
        }
        this.mutableLiveData.setValue(new TestUser(emailAddress, phoneNumber));
    }
}
