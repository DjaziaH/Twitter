package com.example.tweet.services;

import com.example.tweet.Data.Tweet;
import com.example.tweet.Data.User;
import com.example.tweet.R;

import java.text.ParseException;
import java.util.ArrayList;


public class ServiceTweet {

    private ArrayList<Tweet> mesDonnees = new ArrayList<>();
    private ArrayList<User> mesusers = new ArrayList<>();

    public ServiceTweet() throws ParseException {
       initialisation();
    }

    public ArrayList<Tweet> getMesDonnees(){
        return mesDonnees;
    }

    public ArrayList<User> getUsers(){
        return mesusers;
    }

    public void setNewTweet(Tweet tweet){

            mesDonnees.add(tweet);

    }

    public void initialisation() throws ParseException {

        User user1 = new User(1,"Hababela","Djazia", R.drawable.avat_1);
        User user2 = new User(2,"Elouali","Nadia", R.drawable.avat_2);

        mesusers.add(user1);
        mesusers.add(user2);


        String date = "Wed Mar 14 15:30:00 EET 2019";

        /* ************************************************************************************** */
        Tweet tweet = new Tweet(1,"Hello !",date,1);
        mesDonnees.add(tweet);

        tweet = new Tweet(2,"Love you guys !",date,2);
        mesDonnees.add(tweet);

        tweet = new Tweet(3,"Corona Go Please !",date,2);
        mesDonnees.add(tweet);

        tweet = new Tweet(4,"Stay Home !",date,1);
        mesDonnees.add(tweet);

    }

}
