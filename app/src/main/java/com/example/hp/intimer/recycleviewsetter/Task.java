package com.example.hp.intimer.recycleviewsetter;

/**
 * Created by hp on 020 20.07.2017.
 */

public class Task {
    private String title;
    private String time;

    public Task() {
    }

    public Task(String title, String description, String time) {
        this.title = title;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
