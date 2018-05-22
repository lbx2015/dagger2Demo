package com.riking.calendar.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.NumberPicker;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    //标明需要注入的对象
    @Inject
    Person person;
    NumberPicker picker;
    @Inject
    Dog dog;
    @Inject
    Cat cat;
    @Inject
    Cat ca2;

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
        MainComponent component = DaggerMainComponent.builder().mainModule(new MainModule(this)).build();

        //注入
        component.inject(this);
        Log.d("dagger cat1:", cat.toString());
        Log.d("dagger cat2:", ca2.toString());

    }


}
