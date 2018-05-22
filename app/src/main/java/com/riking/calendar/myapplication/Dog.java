package com.riking.calendar.myapplication;


import android.util.Log;

import javax.inject.Inject;

public class Dog {
    @Inject
    public Dog() {
        Log.d("dagger", "dog create!!!");
    }
}
