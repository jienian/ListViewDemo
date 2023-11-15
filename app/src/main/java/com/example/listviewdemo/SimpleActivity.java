package com.example.listviewdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleActivity extends AppCompatActivity {

   private List<Map<String,Object>> data = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);

        //获取ListView对象

        ListView listView2 = findViewById(R.id.list_view2);

        //实例化适配器对象
        //参数1：this
        //参数2：数据源
        initData();
        //参数3：每一项布局
        //参数4：数据来源的key数组
        String[] from = {"img","name","mood"};
        //参数5：数据去向的id数组
        int [] to = {R.id.qq_img,R.id.qq_name,R.id.qq_mood};
        //参数45对应索引上，from数组的元素代码数据源每个map的key，该key所指代的数据
        //会作为to数组对应索引上id所代表的控件的内容显示出来
        SimpleAdapter adapter = new SimpleAdapter(this,data,R.layout.item3,from,to);
        //为ListView设置适配器
        listView2.setAdapter(adapter);

        //点击事件
        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                //用Toast提示Name Mood
                Map<String,Object> map = data.get(i);
                String name = map.get("name").toString();
                String mood = map.get("mood").toString();
                Toast.makeText(SimpleActivity.this,name+""+mood,Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void initData(){
        //左边：头像  右上：名字  右下：心情
        Map<String,Object> map1 = new HashMap<>();
        map1.put("img",R.mipmap.link);
        map1.put("name","link");
        map1.put("mood","乾坤未定，你我皆是黑马");

        Map<String,Object> map2 = new HashMap<>();
        map2.put("img",R.mipmap.zhenji);
        map2.put("name","甄姬");
        map2.put("mood","飘摇兮若流风之回雪");

        Map<String,Object> map3 = new HashMap<>();
        map3.put("img",R.mipmap.simayi);
        map3.put("name","司马懿");
        map3.put("mood","无奈天命之子");

        Map<String,Object> map4 = new HashMap<>();
        map4.put("img",R.mipmap.guojia);
        map4.put("name","Nimyears");
        map4.put("mood","我又emo了");

        Map<String,Object> map5 = new HashMap<>();
        map5.put("img",R.mipmap.link);
        map5.put("name","link");
        map5.put("mood","乾坤未定，你我皆是黑马");

        Map<String,Object> map6 = new HashMap<>();
        map6.put("img",R.mipmap.zhenji);
        map6.put("name","甄姬");
        map6.put("mood","飘摇兮若流风之回雪");

        Map<String,Object> map7 = new HashMap<>();
        map7.put("img",R.mipmap.simayi);
        map7.put("name","司马懿");
        map7.put("mood","无奈天命之子");

        Map<String,Object> map8 = new HashMap<>();
        map8.put("img",R.mipmap.guojia);
        map8.put("name","Nimyears");
        map8.put("mood","我又emo了");




        data.add(map1);
        data.add(map2);
        data.add(map3);
        data.add(map4);
        data.add(map5);
        data.add(map6);
        data.add(map7);
        data.add(map8);

    }
}
