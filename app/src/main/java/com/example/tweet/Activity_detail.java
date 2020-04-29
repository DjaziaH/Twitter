package com.example.tweet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;

import com.example.tweet.fragment.Detail_fragment;

public class Activity_detail extends AppCompatActivity {

    FragmentManager myManager;
    Detail_fragment detail;

    String name, text, date;
    int img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        if(savedInstanceState!=null){
            name = savedInstanceState.getString("name");
            date = savedInstanceState.getString("date");
            text = savedInstanceState.getString("text");
            img  = savedInstanceState.getInt("img");
        }


        Intent i = getIntent();

        name = i.getStringExtra("name");
        date = i.getStringExtra("date");
        text = i.getStringExtra("text");
        img = i.getIntExtra("img", 0);
        myManager = getSupportFragmentManager();
        detail = (Detail_fragment) myManager.findFragmentById(R.id.activ_detail);

        if (detail != null) {
            detail.setValues(name, date, text, img);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle state) {

        super.onSaveInstanceState(state);
        state.putString("name", name);
        state.putString("date", date);
        state.putString("text", text);
        state.putInt("img", img);

    }
}