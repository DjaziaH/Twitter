package com.example.tweet.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.tweet.Activity_Tweets;
import com.example.tweet.Data.Tweet;
import com.example.tweet.R;
import com.example.tweet.adapter.TweetAdapter;
import com.example.tweet.services.ServiceTweet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class list_fragment extends Fragment {

    private Activity_Tweets myActivity;
    ListView maListView;
    static ServiceTweet service;

    static {
        try {
            service = new ServiceTweet();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    static ArrayList<Tweet> mesDonnees =service.getMesDonnees();
    SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy");

    View myView;


    public list_fragment() throws ParseException {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


            myView = inflater.inflate(R.layout.list_tweets_fragment, container,false);

            maListView = myView.findViewById(R.id.list);

            if(savedInstanceState !=null) {
                mesDonnees = (ArrayList<Tweet>) savedInstanceState.getSerializable("donnees");
            }

            try {

            final TweetAdapter adapter = new TweetAdapter(myActivity, mesDonnees);
            maListView.setAdapter(adapter);

            maListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                    AlertDialog.Builder confirm = new AlertDialog.Builder(myActivity);
                    confirm.setTitle("Suppression");
                    confirm.setIcon(android.R.drawable.ic_dialog_alert);
                    confirm.setMessage("Vous confirmez la suppression ?");
                    confirm.setPositiveButton(android.R.string.yes,
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int idBtn) {
                                    mesDonnees.remove(position);
                                    adapter.notifyDataSetChanged();
                                }
                            });
                    confirm.setNegativeButton(android.R.string.no, null);
                    confirm.show();

                }
            });
            maListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {


                     String name = service.getUsers().get(adapter.getItem(position).getIdUser()-1).getNom();
                     String date = adapter.getItem(position).getDate();
                     String text = adapter.getItem(position).getText();
                     int img = service.getUsers().get(adapter.getItem(position).getIdUser()-1).getAvatare();


                    Toast.makeText(myActivity,text,Toast.LENGTH_SHORT).show();

                    myActivity.onItemClick(name,date,text,img);
                    return false;
                }


            });
        } catch (ParseException e) {
            e.printStackTrace();
        }

            return myView;
    }

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        myActivity = (Activity_Tweets) context;
    }

    @Override
    public void onSaveInstanceState(Bundle state) {
        super.onSaveInstanceState(state);
        state.putSerializable("donnees", mesDonnees);
    }

    public void addTweet(int idTweet,String text,int idUser){
        Date date = new Date();
        String currentDate = formatter.format(date);
        Tweet newTweet = new Tweet(idTweet,text,currentDate,idUser);
        mesDonnees.add(newTweet);
        }

}
