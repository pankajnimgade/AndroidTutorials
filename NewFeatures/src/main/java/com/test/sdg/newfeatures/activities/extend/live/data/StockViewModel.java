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

package com.test.sdg.newfeatures.activities.extend.live.data;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.graphics.Canvas;

/**
 * Created by Pankaj Nimgade on 2/15/2018.
 */

public class StockViewModel extends ViewModel {

    private MutableLiveData<StockLiveData> stockLiveData;

    public StockViewModel() {
        this.stockLiveData = new MutableLiveData<>();
        this.stockLiveData.setValue(new StockLiveData());


    }

    public MutableLiveData<StockLiveData> getStockLiveData() {
        return stockLiveData;
    }
}
