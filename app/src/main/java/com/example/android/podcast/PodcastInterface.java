package com.example.android.podcast;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PodcastInterface
{
    @GET("android/v1/prod/Radio/hi/show.json")
    Call<List<Podcast>> getInfo();
}
