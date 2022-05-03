package com.example.forus.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.example.forus.activities.*;

import com.example.forus.R;
import com.example.forus.model.Imagen;


import java.util.List;

public class ImageListAdapter extends BaseAdapter {

    List<Imagen> catalogo;

    Context context;
    TextView nameText;
    Button viewButton;

    public ImageListAdapter(List<Imagen> catalogo, Context context) {
        this.catalogo = catalogo;
        this.context = context;
    }

    @Override
    public int getCount() {
        return catalogo.size();
    }

    @Override
    public Object getItem(int i) {
        return catalogo.get(i);
    }

    @Override
    public long getItemId(int i) {
        return catalogo.get(i).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if(view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.activity_imagelist, viewGroup, false);
        }
        nameText = view.findViewById(R.id.nameText);
        nameText.setText(catalogo.get(position).getFecha());
        viewButton = view.findViewById(R.id.viewButton);
        viewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callDetail(catalogo.get(position).getId());
            }
        });
        return view;
    }
    private void callDetail(int id) {
        Intent intent = new Intent(context,DetailActivity.class);
        intent.putExtra("id", id);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
