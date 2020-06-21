package com.example.android.podcast;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MiniAdapter extends RecyclerView.Adapter<MiniAdapter.MyViewHolder> {



    List<PodcastHelper>dataset;

    public MiniAdapter(List<PodcastHelper> dataset)
    {
        this.dataset=dataset;

    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        View view;
        MyViewHolder(View v)
        {
            super(v);
            this.view=v;
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v=(View) LayoutInflater.from(parent.getContext()).inflate(R.layout.particularcard,parent,false);
        MyViewHolder viewHolder=new MyViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        View v=holder.view;
        final int index=position;
        ((TextView)v.findViewById(R.id.cardText)).setText(dataset.get(position).getT());
        Picasso.get().load(dataset.get(position).getPF()).into((ImageView)v.findViewById(R.id.cardimage));
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dataset.remove(index);
                notifyItemRemoved(index);
                notifyItemRangeChanged(index,dataset.size());
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }



}
