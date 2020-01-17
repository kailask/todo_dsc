package com.cruzhacks.todo;

//importing libraries
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AddTodoFragment.AddDialogListener {

    //fields
    private ArrayList<String> tasks;
    TodoAdapter listAdapter;

    /*
        onCreate() is the method responsible for creating an activity
        you can initialize code in this method
        takes in a savedInstanceState which preserves the state of the app
        eg: when you rotate your phone, savedInstanceState saves all the data your app currently has
        restores information after orientation has changed 
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        RecyclerView list = findViewById(R.id.list);
        list.setLayoutManager(new LinearLayoutManager(this));

        tasks = new ArrayList<String>();
        tasks.add("thing");
        tasks.add("thing");
        tasks.add("thing");
        tasks.add("thing");

        listAdapter = new TodoAdapter(tasks);
        list.setAdapter(listAdapter);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AddTodoFragment addFragment = new AddTodoFragment();
                addFragment.show(getSupportFragmentManager(),"AddTodoFragment");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onAddElement(String newTask) {
        tasks.add(0,newTask);
        listAdapter.notifyDataSetChanged();
    }
}
