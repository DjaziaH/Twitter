package com.example.tweet.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.tweet.R;

public class Detail_fragment extends Fragment {

    ImageView image;
    TextView name, date, text;


    public Detail_fragment(){ }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View myView = inflater.inflate(R.layout.more_detail_fragment, container,false);

        image = myView.findViewById(R.id.img);
        name = myView.findViewById(R.id.nom);
        text = myView.findViewById(R.id.text2);
        date = myView.findViewById(R.id.date);

        return myView;
    }

    public void setValues(String name , String date , String text , int img){
        this.text.setText(text);
        this.name.setText(name);
        this.date.setText(date);
        this.image.setImageResource(img);
    }



}
