package com.cruzhacks.todo2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class TodoAdaptor extends RecyclerView.Adapter {

    private ArrayList<String> myTasks;

    public TodoAdaptor(ArrayList<String> tasks){
        this.myTasks = tasks;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View taskView = LayoutInflater.from(parent.getContext()).inflate(R.layout.todo_task,parent,false);
        return new MyHolder(taskView);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyHolder myHolder = (MyHolder)holder;
        myHolder.task.setText(myTasks.get(position));
    }

    @Override
    public int getItemCount() {
        return myTasks.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {
        private TextView task;

        private MyHolder(View layout){
            super(layout);
            this.task = layout.findViewById(R.id.task_name);
        }
    }
}
