package com.example.databaseoprations;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME= "TaskDB";
    private static final int DB_VERSION = 1;
    public static final String TABLE_NAME = "Tasks";
    public  static  final String COLUMN_TASK = "Task_Description";
    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createSQL = "CREATE TABLE Tasks (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "Task_Description TEXT);";
        db.execSQL(createSQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
