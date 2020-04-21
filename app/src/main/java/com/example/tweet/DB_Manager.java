package com.example.tweet;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DB_Manager extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "TweetsDB";
    private static final int DATABASE_VERSION = 1;

    
    public DB_Manager(@Nullable Context context ) {
        super(context,  DATABASE_NAME,null  ,DATABASE_VERSION  );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
