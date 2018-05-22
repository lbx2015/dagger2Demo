package com.riking.calendar.myapplication;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

public class ZApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                Log.i("dagger", "onActivityCreated " + activity);
            }

            @Override
            public void onActivityStarted(Activity activity) {
                Log.i("dagger", "onActivityStarted " + activity.getClass().getSimpleName());
            }

            @Override
            public void onActivityResumed(Activity activity) {
                Log.i("dagger", "onActivityResumed " + activity.getClass().getSimpleName());
            }

            @Override
            public void onActivityPaused(Activity activity) {
                Log.i("dagger", "onActivityPaused " + activity.getClass().getSimpleName());
            }

            @Override
            public void onActivityStopped(Activity activity) {
                Log.i("dagger", "onActivityStopped " + activity.getClass().getSimpleName());
            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
                Log.i("dagger", "onActivitySaveInstanceState " + activity.getClass().getSimpleName());
            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                Log.i("dagger", "onActivityDestroyed " + activity.getClass().getSimpleName());
            }
        });
    }
}
