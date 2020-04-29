package com.example.tweet.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.tweet.Data.Tweet;
import com.example.tweet.Data.User;
import com.example.tweet.R;
import com.example.tweet.services.ServiceTweet;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class TweetAdapter extends ArrayAdapter<Tweet> {

    ServiceTweet service = new ServiceTweet();

    List<Tweet> list ;
    ArrayList<User> users = service.getUsers();

    public TweetAdapter(@NonNull Context context, @NonNull List<Tweet> objects) throws ParseException {
        super(context, 0, objects);
        list = objects ;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//LayoutInflater : Instancie un fichier XML de mise en page dans les objets
        View correspondants;
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.tweet,parent, false);
        TextView user = (TextView)convertView.findViewById(R.id.user);
        TextView text = (TextView) convertView.findViewById(R.id.text);
        TextView id = (TextView) convertView.findViewById(R.id.id);
        TextView date = (TextView) convertView.findViewById(R.id.d);
        ImageView icon = (ImageView) convertView.findViewById(R.id.profile_image);
        user.setText(users.get(list.get(position).getIdUser()-1).getNom()+" "+users.get(list.get(position).getIdUser()-1).getPrenom());
        text.setText(list.get(position).getText());
        id.setText(String.valueOf(list.get(position).getId()));
        date.setText(list.get(position).getDate());
        icon.setImageResource(users.get(list.get(position).getIdUser()-1).getAvatare());
        return convertView;
    }


}
