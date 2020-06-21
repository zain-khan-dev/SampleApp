package com.example.android.podcast;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import javax.security.auth.callback.Callback;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Controller implements retrofit2.Callback<List<Podcast>> {
    static final String BASE_URL="https://d51md7wh0hu8b.cloudfront.net/";


    MyAdapter myAdapter;

    public void start(MyAdapter mAdapter)
    {
        Gson gson=new GsonBuilder().setLenient().create();
        Retrofit retrofit=new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).build();
        PodcastInterface podcast=retrofit.create(PodcastInterface.class);
        Call<List<Podcast>>call=podcast.getInfo();
        call.enqueue(this);
        this.myAdapter=mAdapter;
    }

    @Override
    public void onResponse(Call<List<Podcast>> call, Response<List<Podcast>> response) {

        if(response.isSuccessful())
        {
            List<Podcast>podcast=response.body();
            myAdapter.setData(podcast);
            myAdapter.notifyDataSetChanged();
        }
        else
        {
            System.out.println("here");
        }
    }
    @Override
    public void onFailure(Call<List<Podcast>> call, Throwable t)
    {
        t.getStackTrace();
    }
}
