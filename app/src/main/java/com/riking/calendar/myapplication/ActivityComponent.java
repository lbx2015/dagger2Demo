package com.riking.calendar.myapplication;

import javax.inject.Singleton;

import dagger.Component;

/**
 * 子的Component
 * Created by MH on 2016/7/18.
 */
@Singleton
@Component(dependencies = AppComponent.class, modules = {ActivityMoudule.class})
public interface ActivityComponent {

    // 注入
    void inject(MainActivity activity);
}