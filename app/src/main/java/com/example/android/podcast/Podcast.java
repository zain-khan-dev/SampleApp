package com.example.android.podcast;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Podcast {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("data")
    @Expose
    private List<PodcastHelper> data = null;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<PodcastHelper> getData() {
        return data;
    }

    public void setData(List<PodcastHelper> data) {
        this.data = data;
    }

}
