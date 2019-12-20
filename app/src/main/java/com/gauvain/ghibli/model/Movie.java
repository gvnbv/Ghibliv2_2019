package com.gauvain.ghibli.model;

public class Movie{

    private String title;
    private String desc;
    private String director;
    private String producer;
    private String date;

    public Movie(String title, String desc, String director, String producer, String date) {
        this.title = title;
        this.desc = desc;
        this.director = director;
        this.producer = producer;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public String getDirector() {
        return director;
    }

    public String getProducer() {
        return producer;
    }
}
