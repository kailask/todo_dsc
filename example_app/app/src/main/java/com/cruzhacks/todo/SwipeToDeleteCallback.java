package com.cruzhacks.todo;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

/*
    This class lets us remove a swiped task from the app

 */

public class SwipeToDeleteCallback extends ItemTouchHelper.SimpleCallback {
    private TodoAdapter myAdapter;

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        return false;
    }

    //when an item is swiped off screen
    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
        int position = viewHolder.getAdapterPosition();
        myAdapter.removeItem(position);

    }

    public SwipeToDeleteCallback(TodoAdapter adapter) {
        super(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
        myAdapter = adapter;
    }


}
