package com.example.listviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ArrayActivity extends AppCompatActivity {

    /**
     * 1.准备布局（每一项的显示效果）
     * 2.准备数据源
     * 3.实例化适配器（布局+数据源）
     * 4.为ListView设置适配器
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array);

        ListView listView1 = findViewById(R.id.list_view1);


        //参数1，环境上下文（this）
        //参数2，代表数据项所应用的布局
        //参数3，数据源（数组）

        String[] data = {"AA","BB","CC","DD","EE","FF","GG","AA","BB","CC","DD","EE","FF","GG","AA","BB","CC","DD","EE","FF","GG"};

        //使用Android自带的资源
        ArrayAdapter adapter = new ArrayAdapter(this,R.layout.item2,R.id.txt1,data);
        listView1.setAdapter(adapter);

    }
}