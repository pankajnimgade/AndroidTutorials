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

package com.test.sdg.newfeatures.application.model

/**
 * Created by Pankaj Nimgade on 2/7/2018.
 */
class SingleMenuItem {

    val title_Activity: String
    var description_Activity: String? = null
    val class_Activity: Class<*>

    constructor(title_Activity: String, class_Activity: Class<*>) {
        this.title_Activity = title_Activity
        this.class_Activity = class_Activity
    }

    constructor(title_Activity: String, description_Activity: String, class_Activity: Class<*>) {
        this.title_Activity = title_Activity
        this.description_Activity = description_Activity
        this.class_Activity = class_Activity
    }

    override fun toString(): String {
        return title_Activity
    }
}