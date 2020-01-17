package com.cruzhacks.todo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

/*
    This class allows us to create a popup that asks you to implement a task
 */

public class AddTodoFragment extends DialogFragment {

    AddDialogListener myListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        myListener = (AddDialogListener)context;

        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            myListener = (AddTodoFragment.AddDialogListener) context;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(context.toString()
                    + " must implement NoticeDialogListener");
        }

    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());

        dialogBuilder.setTitle(R.string.enter_task);

        LayoutInflater layoutInflater = requireActivity().getLayoutInflater();

        final View myLayout = layoutInflater.inflate(R.layout.add_todo_dialog,null);

        dialogBuilder.setView(myLayout).setPositiveButton("Add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                EditText textInput = (EditText)myLayout.findViewById(R.id.add_task_text);
                myListener.onAddElement(textInput.getText().toString());
            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        return dialogBuilder.create();
    }

    public interface AddDialogListener{
        void onAddElement(String newTask);
    }
}
