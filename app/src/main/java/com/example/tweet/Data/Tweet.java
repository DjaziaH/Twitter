package com.example.tweet.Data;

import java.util.Date;

public class Tweet {


    private int id ;
    private String text ;
    private String  date ;
    private int idUser;


    public Tweet(int id, String text, String date) {
        this.id = id;
        this.text = text;
        this.date = date;
    }
    public Tweet(int id, String text, String date,int idUser) {
        this.id = id;
        this.text = text;
        this.date = date;
        this.idUser = idUser;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }



}
