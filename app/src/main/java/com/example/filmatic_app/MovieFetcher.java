package com.example.filmatic_app;

import com.google.gson.JsonArray;

import org.json.JSONArray;

import java.util.ArrayList;

public class MovieFetcher {

    private int rating;
    private int runtime;
    private String title;
    private String description;
    private JSONArray cast;
    private String picture;
    private JSONArray services;

    public MovieFetcher(int rating, int runtime, String title, String description, JSONArray cast, String picture, JSONArray services) {
        this.rating = rating;
        this.runtime = runtime;
        this.title = title;
        this.description = description;
        this.cast = cast;
        this.picture = picture;
        this.services = services;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    @Override
    public String toString() {
        return  title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public JSONArray getCast() {
        return cast;
    }

    public void setCast(JSONArray cast) {
        this.cast = cast;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public JSONArray getServices() {
        return services;
    }

    public void setServices(JSONArray services) {
        this.services = services;
    }


}
