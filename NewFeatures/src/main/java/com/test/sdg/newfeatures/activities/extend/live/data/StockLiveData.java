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

import android.arch.lifecycle.LiveData;
import android.support.annotation.Nullable;

/**
 * Created by Pankaj Nimgade on 2/14/2018.
 */

public class StockLiveData extends LiveData<Stock> {

    private StockMarket stockMarket;

    private StockChangeListener stockChangeListener = new StockChangeListener(){
        @Override
        public void onChanged(@Nullable Stock stock) {
            super.onChanged(stock);
            setValue(stock);
        }
    };

    @Override
    protected void onActive() {
        super.onActive();
        stockMarket.requestStockUpdate(stockChangeListener);
    }

    @Override
    protected void onInactive() {
        super.onInactive();
        stockMarket.removeUpdates(stockChangeListener);
    }
}
