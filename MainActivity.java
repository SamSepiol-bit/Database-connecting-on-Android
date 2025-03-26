package com.example.databaseoprations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etTaskDescription;
    Button btnAddTask, btnViewTasks;

    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etTaskDescription = findViewById(R.id.etTaskDescription);
        btnAddTask = findViewById(R.id.btnAddTask);
        btnViewTasks = findViewById(R.id.btnViewTask);
        dbHelper = new DatabaseHelper(this);

        btnAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String TaskDescription = etTaskDescription.getText().toString();
                if(!TaskDescription.isEmpty()) {
                    insertTask(TaskDescription);
                    etTaskDescription.setText("");
                }
            }
        });
    }
    private void insertTask(String TaskDescription){
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Task_Description", TaskDescription);
        long newRowId = database.insert("Tasks", null, values);
//        database.close();
    }
}