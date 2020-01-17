package com.cruzhacks.todo;

//importing libraries
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity implements AddTodoFragment.AddDialogListener {

    //fields
    private ArrayList<String> tasks;
    TodoAdapter listAdapter;

    private final String PREF_KEY = "TASKS";

    /*
        onCreate() is the method responsible for creating an activity
        you can initialize code in this method
        takes in a savedInstanceState which preserves the state of the app
        eg: when you rotate your phone, savedInstanceState saves all the data your app currently has
        restores information after orientation has changed 
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //pass savedInstanceState to parent
        super.onCreate(savedInstanceState);

        //sets the design of the app
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //RecyclerView containerizes the list of views
        RecyclerView list = findViewById(R.id.list);
        list.setLayoutManager(new LinearLayoutManager(this));

        tasks = new ArrayList<String>();

        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        Set<String> storedTasks = sharedPref.getStringSet(PREF_KEY,new HashSet<String>());
        tasks.addAll(storedTasks);

        listAdapter = new TodoAdapter(tasks);
        list.setAdapter(listAdapter);

        ItemTouchHelper myHelper = new ItemTouchHelper(new SwipeToDeleteCallback(listAdapter));
        myHelper.attachToRecyclerView(list);

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
    public void onAddElement(String newTask) {
        tasks.add(0,newTask);
        listAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putStringSet(PREF_KEY,new HashSet<String>(tasks));
        editor.apply();
    }
}
