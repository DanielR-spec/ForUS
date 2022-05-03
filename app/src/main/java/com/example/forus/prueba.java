package com.example.forus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.RequiresApi;

import android.os.Build;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.forus.activities.CreateActivity;
import com.example.forus.adapters.ImageListAdapter;
import com.example.forus.interfaces.CRUDInterface;
import com.example.forus.model.Imagen;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import com.example.forus.constants.Constants;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class prueba extends AppCompatActivity {
    List<Imagen> catalogo;
    CRUDInterface crudInterface;

    ListView listView;
    FloatingActionButton createButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prueba);
        listView = findViewById(R.id.ls1);
        createButton = findViewById(R.id.createButton);
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callCreate();
            }
        });
        getAll();
    }


    private void getAll() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        crudInterface = retrofit.create(CRUDInterface.class);
        Call<List<Imagen>> call = crudInterface.getAll();
        call.enqueue(new Callback<List<Imagen>>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<List<Imagen>> call, Response<List<Imagen>> response) {
                if(!response.isSuccessful()) {
                    Toast toast = Toast.makeText(getApplicationContext(), response.message(), Toast.LENGTH_LONG);
                    toast.show();
                    Log.e("Response err: ", response.message());
                    return;
                }
                catalogo = response.body();
                ImageListAdapter imageListAdapter = new ImageListAdapter(catalogo, getApplicationContext());
                listView.setAdapter(imageListAdapter);
                catalogo.forEach(p -> Log.i("Imgs: ", p.toString()));
            }

            @Override
            public void onFailure(Call<List<Imagen>> call, Throwable t) {
                Toast toast = Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG);
                toast.show();
                Log.e("Throw err: ", t.getMessage());
            }
        });
    }

    private void callCreate() {
        Intent intent = new Intent(getApplicationContext(), CreateActivity.class);
        startActivity(intent);
    }
}

