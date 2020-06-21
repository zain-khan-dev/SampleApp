package com.example.android.podcast;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {




    Context context;
    List<Podcast>dataset;

    public MyAdapter(Context context)
    {
        this.context=context;
        dataset=new ArrayList<>();

    }
    class MyViewHolder extends RecyclerView.ViewHolder
    {
        View myView;
        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);
            myView=itemView;
        }
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View v=(View) LayoutInflater.from(parent.getContext()).inflate(R.layout.listview,parent,false);
        MyViewHolder viewHolder=new MyViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        ((TextView)holder.myView.findViewById(R.id.title)).setText(dataset.get(position).getTitle());
        RecyclerView miniRecycler=((RecyclerView)holder.myView.findViewById(R.id.miniRecycler));
        miniRecycler.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        MiniAdapter miniAdapter=new MiniAdapter(dataset.get(position).getData());
        miniRecycler.setAdapter(miniAdapter);
    }
    public void setData(List<Podcast> podcast)
    {
        this.dataset=podcast;

    }
    @Override
    public int getItemCount() {
        return dataset.size();
    }


}
