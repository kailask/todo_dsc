package com.cruzhacks.todo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.TodoHolder> {

    private ArrayList<String> tasks;

    public TodoAdapter(ArrayList<String> tasks) {
        this.tasks = tasks;
    }

    @NonNull
    @Override
    public TodoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View taskCard = LayoutInflater.from(parent.getContext()).inflate(R.layout.todo_task,parent,false);
        return new TodoHolder(taskCard);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoHolder holder, int position) {
        holder.name.setText(tasks.get(position));
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    class TodoHolder extends RecyclerView.ViewHolder {
        private TextView name;

        private TodoHolder(View layout) {
            super(layout);
            this.name = layout.findViewById(R.id.task_name);
        }
    }

    public void removeItem(int position){
        tasks.remove(position);
        this.notifyItemRemoved(position);
    }
}
