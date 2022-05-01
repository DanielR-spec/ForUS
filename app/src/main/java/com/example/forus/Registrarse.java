package com.example.forus;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;


public class Registrarse extends AppCompatActivity {
    EditText etName,etPassword,etEmail,etPhone,etId;
    Button btnRegistrar;


    RequestQueue requestQueue;

    //private static final String URL1 = "http://192.168.0.6/android/save.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);

        requestQueue = Volley.newRequestQueue(this);

        //initUI();

        //btnRegistrar.setOnClickListener(this);

    }

    /*private void initUI(){
        etName = findViewById(R.id.Nombre);
        etEmail = findViewById(R.id.Mail);
        etPhone = findViewById(R.id.Cel);
        etPassword = findViewById(R.id.Pass);

        btnRegistrar = findViewById(R.id.btnRegistrarse);
    }

    @Override
    public void onClick(View v) {

        int id = v.getId();

        if(id == R.id.btnRegistrarse){
            String name =  etName.getText().toString().trim();
            String email = etEmail.getText().toString().trim();
            String password = etPassword.getText().toString().trim();
            String phone = etPhone.getText().toString().trim();

            createUser(name, email, password, phone);
        }

    }
    private void createUser(final String name, final String email, final String password, final String phone){
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                URL1,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(Registrarse.this, "Correct", Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error){

                    }
                }
            ){
            //@Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("name", name);
                params.put("email", email);
                params.put("password", password);
                params.put("phone", phone);
                return params;

            }
        };
        requestQueue.add(stringRequest);
    }*/

    public void iniciar(View v)
    {
        Toast.makeText(v.getContext(), "Pasando a Login", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(v.getContext(), Login.class);
        startActivity(intent);
    }

    public void inicio(View v)
    {
        Toast.makeText(v.getContext(), "Pasando a Inicio", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(v.getContext(), Inicio.class);
        startActivity(intent);
    }
}