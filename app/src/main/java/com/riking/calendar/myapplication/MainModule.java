package com.riking.calendar.myapplication;

import android.content.Context;

import com.riking.calendar.myapplication.annotation.CatForContext;
import com.riking.calendar.myapplication.annotation.CatForName;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module   //提供依赖对象的实例
public class MainModule {
    private Context mContext;

    public MainModule(Context context) {
        mContext = context;
    }

    @Provides
        // 关键字，标明该方法提供依赖对象
    Person providerPerson() {
        //提供Person对象
        return new Person();
    }

    @Provides
    Context providesContext() {
        // 提供上下文对象
        return mContext;
    }

    @Provides
    @CatForContext  // 通过context创建Person 对象
//    @Named("context")  // 通过context创建Person 对象
    @Singleton
        // 关键字，标明该方法提供依赖对象
    Cat providerCat(Context context) {
        //提供Person对象
        return new Cat(context);
    }

    @CatForName// 通过name创建Person 对象
//    @Named("name")// 通过name创建Person 对象
    @Provides
    Cat provissderdCatName() {
        return new Cat("name");
    }

}