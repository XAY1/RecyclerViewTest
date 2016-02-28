package com.xushuzhan.recyclerviewtest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.HashMap;

/**
 * Created by Mr.Xu on 2016/2/25.
 */
public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> implements View.OnClickListener {

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }
    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取数据
            mOnItemClickListener.onItemClick(v, (HashMap) v.getTag());
        }
    }

    //定义一个接口
    public static interface OnRecyclerViewItemClickListener {
        void onItemClick(View view , HashMap data/*String data*/);
    }
    private OnRecyclerViewItemClickListener mOnItemClickListener = null;


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home, parent,
            false);
        MyViewHolder holder = new MyViewHolder(
                view);
        //将创建的View注册点击事件
        view.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position)
    {

        HashMap<String, Object> map = (HashMap<String, Object>) HomeActivity.datas.get(position);
        //holder.tv.setText(map.get("name").toString());
        holder.tv.setText(map.toString());
        try {
            holder.tv1.setText(HomeActivity.m2Datas.get(position).toString());
        }catch (Exception e){
            System.out.println(e.getMessage()+"999999999999999999999999999999999999999999999999999999999");
        }
        //将数据保存在itemView的Tag中，以便点击时进行获取
        holder.itemView.setTag(map);


    }

    @Override
    public int getItemCount()
    {
        return 26;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {

        TextView tv;
        TextView tv1;
        public MyViewHolder(View view)
        {
            super(view);
            tv = (TextView) view.findViewById(R.id.id_num);
            tv1=(TextView)view.findViewById(R.id.test);

        }
    }
}


