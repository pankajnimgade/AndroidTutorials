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

/**
 * Created by Pankaj Nimgade on 2/14/2018.
 */

public class TestUser {

    private String emailAddress;
    private String phoneNumber;

    public TestUser() {
    }

    public TestUser(String emailAddress, String phoneNumber) {
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        if (emailAddress != null && !emailAddress.trim().isEmpty()) {
            return emailAddress;
        }
        return "";
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        if (phoneNumber != null && !phoneNumber.trim().isEmpty()) {
            return phoneNumber;
        }
        return "";
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
