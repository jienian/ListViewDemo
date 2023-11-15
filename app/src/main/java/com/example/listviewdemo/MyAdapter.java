package com.example.listviewdemo;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.List;

//根据准备好的数据源和子项布局完成ListView效果的一一设置
//做出一些细节处理
public class MyAdapter extends BaseAdapter {
    private List<Msg> list;
    private Context ctx;
    public MyAdapter(List<Msg> list, Context ctx){
        this.list = list;
        this.ctx = ctx;
    }

    //获取数量(设置ListView的长度)
    @Override
    public int getCount() {
        return list.size();
    }



    //获取视图(设置ListView每一项的显示效果) --每个视图出现时都会执行
    @Override
    public View getView(int i, View view, ViewGroup parent) {
        //完成对view的设置
    //将布局资源转为View
        //参数1：你所要引用的布局资源
        //RecyclerBin
        ViewHolder holder;
        if (view == null) {
            Log.e("TAG", "===" + i);
            //优化1：利用进入RecyclerBin中的View,减少对view的复制
            view = LayoutInflater.from(ctx).inflate(R.layout.item4, null);
            holder = new ViewHolder();
            holder.profile = view.findViewById(R.id.profile);
            holder.nickname = view.findViewById(R.id.nickname);
            holder.content = view.findViewById(R.id.content);
            holder.like = view.findViewById(R.id.like);
            holder.comment = view.findViewById(R.id.comment);
            holder.repost = view.findViewById(R.id.repost);
            view.setTag(holder);

        }else {
            //通过getTag（）取出ViewHolder对象，然后能够直接通过holder.控件的方式在
            //外面操作控件，从而避免了大幅使用findViewById操作
            //而事实上，getTag（）本身操作效率高
            holder = (ViewHolder) view.getTag();
        }
        Msg m = list.get(i);


        //头像
        //ImageView profile = view.findViewById(R.id.profile);
        holder.profile.setImageResource(m.getProfile());

        //昵称
       // TextView nickname = view.findViewById(R.id.nickname);
        holder.nickname.setText(m.getNickname());


        //内容
        //TextView content = view.findViewById(R.id.content);
        holder.content.setText(m.getContent());

        //是否点赞
       // ImageView like = view.findViewById(R.id.like);

        if (m.isLike()){
            holder.like.setImageResource(R.mipmap.liked);
        }else {
            holder.like.setImageResource(R.mipmap.like);
        }

        //评论
        //ImageView comment = view.findViewById(R.id.comment);
        holder.comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ctx,"你点击了评论",Toast.LENGTH_SHORT).show();
            }
        });

        //转发
        //ImageView repost = view.findViewById(R.id.repost);
        holder.repost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ctx,"------转发",Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    //=====================酱油方法
    //获取子项
    @Override
    public Object getItem(int position) {
        return null;
    }

    //获取子项ID
    @Override
    public long getItemId(int position) {
        return 0;
    }

    //1.自定义一个类，叫做ViewHolder
    //2.将需要保存的视图声明为公开的属性
    //3.什么适合保存？当view为null时，完成对ViewHolder的实例化工作，并为各个控件属性附值
    //4.什么时候用？  什么时候都要用（性能的提升是在view不为null时体现，滚动ListView时体现）
    //5.怎么用？ 当view为null时，完成了ViewHolder及内部控件属性初始化工作后，调用一句代码
    //view.setTag(holder);
    //当view不为null时，holder = view.getTag();
    static class ViewHolder{
        public ImageView profile,like,comment,repost;
        public TextView nickname,content;

    }
}
