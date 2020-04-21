package com.example.tweet;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.tweet.Data.Tweet;
import com.example.tweet.adapter.TweetAdapter;
import com.example.tweet.services.ServiceTweet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class Activity_Tweets extends AppCompatActivity {

    int idUser = 1;
    static int idTweet = 5;
    ListView maListView;
    ServiceTweet service = new ServiceTweet();
    ArrayList<Tweet> mesDonnees =service.getMesDonnees();
    SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy");


    public Activity_Tweets() throws ParseException {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__tweets);
        maListView = findViewById(R.id.list);

        /*if(savedInstanceState !=null){
            mesDonnees = (ArrayList<Tweet>) savedInstanceState.getParcelable("donnees");
        }*/


        try {

            final TweetAdapter adapter = new TweetAdapter(Activity_Tweets.this, mesDonnees);
            maListView.setAdapter(adapter);

            maListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

                    AlertDialog.Builder confirm = new AlertDialog.Builder(Activity_Tweets.this);
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

                    return false;
                }
            });


        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialogue);
        Button btnValider = dialog.findViewById(R.id.dialog_btn_valider);
        final EditText editText = dialog.findViewById(R.id.dialog_text);
        dialog.show();
        btnValider.setOnClickListener(new
                                              View.OnClickListener() {
                                                  @Override public void onClick(View v) {
                                                      if(!editText.getText().toString().equals("")){
                                                          Date date = new Date();
                                                          String currentDate = formatter.format(date);
                                                          Tweet newTweet = new Tweet(idTweet,editText.getText().toString(),currentDate,idUser);
                                                          mesDonnees.add(newTweet);
                                                      }
                                                      dialog.hide();
                                                  }
                                              });
        return true;

    }
    /*@Override
    public void onSaveInstanceState(Bundle state) {
        super.onSaveInstanceState(state);
        state.putParcelable("donnees", (Parcelable) mesDonnees);
    }*/
}
