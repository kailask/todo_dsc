package com.cruzhacks.todo2;

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

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements TodoFragment.AddDialogListener {

    private ArrayList<String> myTasks;
    TodoAdaptor adaptor;

    @Override
    public void onAddElement(String newTask) {
        myTasks.add(0,newTask);
        adaptor.notifyDataSetChanged();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView myList = findViewById(R.id.list);
        myList.setLayoutManager(new LinearLayoutManager(this));

        myTasks = new ArrayList<String>();

        myTasks.add("task 1");
        myTasks.add("task 1");
        myTasks.add("task 1");
        myTasks.add("task 1");
        myTasks.add("task 1");
        myTasks.add("task 1");
        myTasks.add("task 1");
        myTasks.add("task 1");
        myTasks.add("task 1");
        myTasks.add("task 1");
        myTasks.add("task 1");
        myTasks.add("task 1");
        myTasks.add("task 1");
        myTasks.add("task 1");
        myTasks.add("task 1");
        myTasks.add("task 1");


        adaptor = new TodoAdaptor(myTasks);
        myList.setAdapter(adaptor);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TodoFragment fragment = new TodoFragment();
                fragment.show(getSupportFragmentManager(),"ADD_FRAGMENT");
            }
        });
    }

}
