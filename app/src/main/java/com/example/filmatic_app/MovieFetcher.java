package com.example.filmatic_app;

public class MovieFetcher {

    private int rating;
    private int runtime;
    private String title;
    private String description;
    private String cast;
    private String picture;
    private String services;

    public MovieFetcher(int rating, int runtime, String title, String description, String cast, String picture, String services) {
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

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }


}
