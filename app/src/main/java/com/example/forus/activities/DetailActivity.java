package com.example.forus.activities;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.forus.R;
import com.example.forus.interfaces.CRUDInterface;
import com.example.forus.model.Imagen;
import com.example.forus.constants.Constants;

import java.io.Serializable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailActivity extends AppCompatActivity {

    TextView idText;
    TextView nameText;
    TextView priceText;
    Button editButton;

    CRUDInterface crudInterface;

    Imagen imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activiy_detail);
        idText = findViewById(R.id.idText);
        nameText = findViewById(R.id.nameText);
        priceText = findViewById(R.id.priceText);
        int id = getIntent().getExtras().getInt("id");
        editButton = findViewById(R.id.editButton);
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callEdit();
            }
        });
        getOne(id);
    }

    private void getOne(int id) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        crudInterface = retrofit.create(CRUDInterface.class);
        Call<Imagen> call = crudInterface.getOne(id);
        call.enqueue(new Callback<Imagen>() {
            @Override
            public void onResponse(Call<Imagen> call, Response<Imagen> response) {
                if(!response.isSuccessful()) {
                    Toast toast = Toast.makeText(getApplicationContext(), response.message(), Toast.LENGTH_LONG);
                    toast.show();
                    Log.e("Response err: ", response.message());
                    return;
                }
                imagen = response.body();
                idText.setText(String.valueOf(imagen.getId()));
                nameText.setText(imagen.getGenero());
                priceText.setText(String.valueOf(imagen.getDias()));
            }

            @Override
            public void onFailure(Call<Imagen> call, Throwable t) {
                Toast toast = Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG);
                toast.show();
                Log.e("Throw err: ", t.getMessage());
            }
        });
    }

    private void callEdit() {
        Intent intent = new Intent(getApplicationContext(), EditActivity.class);
        intent.putExtra("imagen", imagen);
        startActivity(intent);
    }
}