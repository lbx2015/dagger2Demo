package com.riking.calendar.myapplication;

import android.content.Context;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * 下层Module类
 * Created by MH on 2016/7/18.
 */
@Module
public class ActivityMoudule {

    @Provides
    Cat2 provideCat2(Context context) {
        //　此方法需要Context 对象
        return new Cat2(context);
    }

    @Provides
        // 关键字，标明该方法提供依赖对象
    Person providerPerson() {
        //提供Person对象
        return new Person();
    }

    @Provides
    @Named("context")  // 通过context创建Person 对象
    @Singleton
        // 关键字，标明该方法提供依赖对象
    Cat providerCat(Context context) {
        //提供Person对象
        return new Cat(context);
    }

    @Named("name")// 通过name创建Person 对象
    @Provides
    Cat providerCat2() {
        return new Cat("name");
    }
}