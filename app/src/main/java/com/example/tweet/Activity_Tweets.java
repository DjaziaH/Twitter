package com.example.tweet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.tweet.Data.Tweet;
import com.example.tweet.fragment.Detail_fragment;
import com.example.tweet.fragment.list_fragment;

import java.text.ParseException;
import java.util.Date;


public class Activity_Tweets extends AppCompatActivity {


    FragmentManager myManager;
    Detail_fragment detail;
    list_fragment list_land , list_port ;

    int idUser = 1;
    static int idTweet = 5;

    public Activity_Tweets(){
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__tweets);

        myManager = getSupportFragmentManager();
        detail = (Detail_fragment) myManager.findFragmentById(R.id.detail);

        list_land = (list_fragment) myManager.findFragmentById(R.id.list_land);
        list_port = (list_fragment) myManager.findFragmentById(R.id.list_port);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        final Dialog dialog = new Dialog(Activity_Tweets.this);
        dialog.setContentView(R.layout.dialogue);
        Button btnValider = dialog.findViewById(R.id.dialog_btn_valider);
        final EditText editText = dialog.findViewById(R.id.dialog_text);
        dialog.show();
        btnValider.setOnClickListener(new
                                              View.OnClickListener() {
                                                  @Override public void onClick(View v) {
                                                      if(!editText.getText().toString().equals("")){
                                                          list_land = (list_fragment) myManager.findFragmentById(R.id.list_land);
                                                          list_port = (list_fragment) myManager.findFragmentById(R.id.list_port);

                                                          int displaymode =
                                                                  getResources().getConfiguration().orientation;

                                                          if(displaymode == Configuration.ORIENTATION_PORTRAIT){
                                                              list_port.addTweet(idTweet,editText.getText().toString(),idUser);
                                                              idTweet++;
                                                          }
                                                          else{
                                                              list_land.addTweet(idTweet,editText.getText().toString(),idUser);
                                                              idTweet++;
                                                          }
                                                      }
                                                      dialog.hide();
                                                  }
                                              });

        return true;
    }

    public void onItemClick(final String name , final String date , final String text , final int img ){


        if(detail != null){

            //Toast.makeText(Activity_Tweets.this," not null",Toast.LENGTH_LONG).show();

            detail.setValues(name,date,text,img);
        }else{
            //Toast.makeText(Activity_Tweets.this,"null",Toast.LENGTH_LONG).show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent i = new Intent(Activity_Tweets.this , Activity_detail.class);
                    i.putExtra("name",name);
                    i.putExtra("text",text);
                    i.putExtra("date",date);
                    i.putExtra("img",img);
                    startActivity(i);
                    finish();
                }
            }, 0);
        }
    }
}
