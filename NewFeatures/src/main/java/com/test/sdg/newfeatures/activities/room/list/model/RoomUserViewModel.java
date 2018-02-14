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

package com.test.sdg.newfeatures.activities.room.list.model;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pankaj Nimgade on 2/10/2018.
 */

public class RoomUserViewModel extends ViewModel {

    private static final String TAG = "ROOM_USER_VIEW_MODEL";

    private LiveData<List<RoomUser>> listLiveData;

    public void init(){
        if (listLiveData == null) {
            MutableLiveData<List<RoomUser>> mutableLiveData = new MutableLiveData<>();
            List<RoomUser> roomUsers = new ArrayList<>();
            mutableLiveData.setValue(roomUsers);
            listLiveData = mutableLiveData;
        }

    }

    public LiveData<List<RoomUser>> getListLiveData() {

        return listLiveData;
    }
}
