package com.riking.calendar.myapplication;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private Context mContext;

    public AppModule(Context context) {
        mContext = context;
    }

    @Provides
    Context providesContext() {
        //提供mContext对象
        return mContext;
    }
}
