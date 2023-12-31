package com.example.listviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class BaseActivity extends AppCompatActivity {
    private ListView listView3;
    private ImageView write;
    private List<Msg> list = new ArrayList<>();
    private int[] ps = {R.mipmap.profile1,R.mipmap.profile2,R.mipmap.profile3,R.mipmap.profile4,
            R.mipmap.profile5,R.mipmap.profile6,R.mipmap.profile7,R.mipmap.profile8};
    private BaseAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        listView3 = findViewById(R.id.list_view3);
        write = findViewById(R.id.write);

        initData();
        //需要传的参数：环境，数据源，

      adapter = new MyAdapter(list,this);

        //设置适配器
        listView3.setAdapter(adapter);

        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Msg m = new Msg(R.mipmap.profile9,"paradox","这是动态新增的说说",false);
                list.add(m);
                //通知适配器更新数据
                adapter.notifyDataSetChanged();
                //设置listview自动显示到最新数据
                listView3.setTranscriptMode(AbsListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);

            }
        });





    }

    private void initData() {
        for (int i = 1 ; i<=8;i++){
            Msg m = new Msg(ps[i-1],"用户"+i,"今天天气好晴朗"+i,i%2==0?true:false);
            list.add(m);
        }
    }
}