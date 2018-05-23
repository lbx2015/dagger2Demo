package com.riking.calendar.myapplication.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

@Qualifier//关键词
@Retention(RetentionPolicy.RUNTIME)//运行时可用
public @interface CatForName {
    //Name 注解对象
}
