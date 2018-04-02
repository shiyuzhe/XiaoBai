package com.example.administrator.xiaobai;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {
    private Context context;

    private List<String> mDatas;

    public HomeAdapter(Context context, List<String> mDatas) {
        this.context = context;
        this.mDatas = mDatas;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                context).inflate(R.layout.item_home, parent,
                false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv.setText(mDatas.get(position));
        Log.e("syz", "position:" + position);
        if (position == 8) {
            holder.rv.setVisibility(View.VISIBLE);
            List<String> datas = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                datas.add(mDatas.get(i));
            }
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context) {
                @Override
                public RecyclerView.LayoutParams generateDefaultLayoutParams() {

                    return new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                }
            };
            holder.rv.setLayoutManager(linearLayoutManager);
//            holder.rv.setLayoutManager(new LinearLayoutManager(context));
            holder.rv.setAdapter(new itemAdapter(context, datas));
        } else {
            holder.rv.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv;
        RecyclerView rv;

        public MyViewHolder(View view) {
            super(view);
            tv = view.findViewById(R.id.id_num);
            rv = view.findViewById(R.id.rv);
        }
    }
}