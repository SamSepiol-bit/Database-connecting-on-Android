package com.example.db;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.databaseoprations.DatabaseHelper;
import com.example.databaseoprations.R;

import java.util.ArrayList;

public class TaskListActivity extends AppCompatActivity {
    ListView listView;
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);
        listView = findViewById(R.id.listView);
        dbHelper = new DatabaseHelper(this);
        displayTasks();

    }
    private void displayTasks(){
        //Initializes an ArrayList that will hold the
        // task descriptions retrived from the database
        ArrayList<String> taskList = new ArrayList<>();
        //This method is used to open the database for read-only operations
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        //Executes a database query to retrieve data from the "Tasks" table.
        //It specifically selects the "Task_Description" column from the Tasks table
        Cursor cursor = database.query("Tasks", new String[]{"Task_Description"},
                null, null, null, null, null);
        //This loop iterates over the rows in the cursor,
        // which represent the result set of the database query
        while(cursor.moveToNext()){
            @SuppressLint("Range") String TaskDescription = cursor.getString
                    (cursor.getColumnIndex("Task_Description"));
            taskList.add(TaskDescription);
        }
        cursor.close();
        //database.close();
        //Display the tasks in the ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, R.layout.list_iteam, R.id.list_item, taskList);
        listView.setAdapter(adapter);
    }
}