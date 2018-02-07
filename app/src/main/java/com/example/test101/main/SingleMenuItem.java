package com.example.test101.main;

import android.app.Activity;

/**
 * Created by Heidi on 5/6/2017.
 */

public final class SingleMenuItem {

    private final String title_Activity;
    private String description_Activity;
    private final Class class_Activity;

    public SingleMenuItem(String title_Activity, Class class_Activity) {
        this.title_Activity = title_Activity;
        this.class_Activity = class_Activity;
    }

    public SingleMenuItem(String title_Activity, String description_Activity, Class class_Activity) {
        this.title_Activity = title_Activity;
        this.description_Activity = description_Activity;
        this.class_Activity = class_Activity;
    }


    public String getTitle_Activity() {
        return title_Activity;
    }

    public void setDescription_Activity(String description_Activity) {
        this.description_Activity = description_Activity;
    }

    public String getDescription_Activity() {
        return description_Activity;
    }

    public Class getClass_Activity() {
        return class_Activity;
    }

    @Override
    public String toString() {
        return title_Activity;
    }
}
