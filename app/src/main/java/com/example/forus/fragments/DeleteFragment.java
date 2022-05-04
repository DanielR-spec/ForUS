package com.example.forus.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;


import androidx.fragment.app.DialogFragment;

import com.example.forus.interfaces.DeleteInterface;

public class DeleteFragment extends DialogFragment {

    private String msn;
    private int id;
    private DeleteInterface deleteInterface;


    public DeleteFragment(String msn, int id, DeleteInterface deleteInterface) {
        this.msn = msn;
        this.id = id;
        this.deleteInterface = deleteInterface;
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(msn+id+"?").setPositiveButton("Accept ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                deleteInterface.delete(id);
            }
        }).setNegativeButton("Cancel ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Log.i("Action ","cancel");
            }
        });
        return builder.create();
    }
}
