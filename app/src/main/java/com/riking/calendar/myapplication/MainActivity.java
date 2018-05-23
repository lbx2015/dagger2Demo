package com.riking.calendar.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.NumberPicker;

import com.riking.calendar.myapplication.annotation.CatForContext;
import com.riking.calendar.myapplication.annotation.CatForName;

import javax.inject.Inject;
import javax.inject.Provider;

import dagger.Lazy;

public class MainActivity extends AppCompatActivity {
    //标明需要注入的对象
    @Inject
    Person person;
    @Inject
    Lazy<Person> person2;// 注入Lazy元素
    NumberPicker picker;
    @CatForName // 标记
    @Inject
    Provider<Cat> providerCat; // 注入Provider
    @Inject
    Dog dog;
    @CatForName // 标记
//    @Named("context") // 标记
    @Inject
    Cat cat;
    @CatForContext  // 标记
    @Inject
    Cat ca2;
    /**
     * 不使用静态的，因为该Component只是针对于该Activity，而不是全局的
     */
    ActivityComponent activityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        picker = findViewById(R.id.number_picker);
        String[] data = new String[]{"Berlin", "Moscow", "Tokyo", "Paris"};
        picker.setMinValue(0);
        picker.setMaxValue(data.length - 1);
        picker.setDisplayedValues(data);

        // 构造桥梁对象
//        MainComponent component = DaggerMainComponent.builder().mainModule(new MainModule(this)).build();
//
//        //注入
//        component.inject(this);
        //another way by sub component
//        AppComponent appCom = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
//        DaggerActivityComponent.builder().appComponent(appCom).activityMoudule(new ActivityMoudule()).build().inject(this);

        activityComponent = DaggerActivityComponent.builder()
                .appComponent(ZApplication.appComponent)  // 添加了全局的AppComponent组件,可以使用全局的实例化对象
                .activityMoudule(new ActivityMoudule())
                .build();


        activityComponent.inject(this);
        Person person = person2.get();// 调用该方法时才会去创建Person,以后每次调用获取的是同一个对象
        // 调用该方法时才回去创建Person1，以后每次调用都会重新加载Module中的具体方法，根据Module中的实现，可能相同，可能不相同。
        Cat person1 = providerCat.get();
        Log.d("dagger cat1:", cat.toString());
        Log.d("dagger cat2:", ca2.toString());

    }


}
