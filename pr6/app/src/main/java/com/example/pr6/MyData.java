package com.example.pr6;

import android.widget.CheckBox;

public class MyData {
    private String name;
    private String message;
    private String rating;
    public MyData(String name, String message , String rating) {
        this.name = name;
        this.message = message;
        this.rating = rating;
    }
    public String getname() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getmessage() {
        return message;
    }
    public void setmessage(String message) {
        this.message=message;
    }

    public String getRating() {
        return rating;
    }
    public void setRating(String rating) {
        this.rating = rating;
    }

}