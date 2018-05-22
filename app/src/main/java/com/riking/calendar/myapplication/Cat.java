package com.riking.calendar.myapplication;


import android.content.Context;
import android.util.Log;

public class Cat {
    Context context;

    public Cat(Context context) {
        this.context = context;
        Log.d("dagger", "Cat create!!!");
    }

    public Cat(String name) {
        Log.d("dagger", "Cat create!!! + by name");
    }
}
