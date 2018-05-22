package com.riking.calendar.myapplication;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {MainModule.class})  // 作为桥梁，沟通调用者和依赖对象库
public interface MainComponent {

    //定义注入的方法
    void inject(MainActivity activity);

}