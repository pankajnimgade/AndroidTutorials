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

import java.math.BigDecimal;

/**
 * Created by Pankaj Nimgade on 2/14/2018.
 */

public class Stock {

    private String stockSymbol;
    private BigDecimal stockPrice;

    public Stock() {
    }

    public Stock(String stockSymbol, BigDecimal stockPrice) {
        this.stockSymbol = stockSymbol;
        this.stockPrice = stockPrice;
    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    public void setStockSymbol(String stockSymbol) {
        if (stockSymbol != null && !stockSymbol.trim().isEmpty()) {
            this.stockSymbol = stockSymbol;
        }
    }

    public BigDecimal getStockPrice() {
        return stockPrice.setScale(2).stripTrailingZeros();
    }

    public void setStockPrice(BigDecimal stockPrice) {
        this.stockPrice = stockPrice;
    }
}
