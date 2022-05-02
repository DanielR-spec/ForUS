package com.example.forus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {
    EditText mail, password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mail = findViewById(R.id.Correo);
        password = findViewById(R.id.Password);
        login = findViewById(R.id.btnLogin);

        /*login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validarUsuario("localhost");
            }
        });
    }

    private void validarUsuario(String URL){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (!response.isEmpty()) {
                    Intent intent = new Intent(getApplicationContext(), Categoria.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(Login.this, "Usuario incorrecto", Toast.LENGTH_SHORT).show();
                }
            }
        },new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error){
                    Toast.makeText(Login.this, error.toString(), Toast.LENGTH_SHORT).show();
                }
            }){

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> parametros = new HashMap<>();
                parametros.put("usuario", mail.getText().toString());
                parametros.put("passwor", password.getText().toString());
                return parametros;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
*/
    }
    public void registrarse(View v)
    {
        Toast.makeText(v.getContext(), "Pasando a Registrarse", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(v.getContext(), Registrarse.class);
        startActivity(intent);
    }

    public void recordar(View v)
    {
        Toast.makeText(v.getContext(), "Pasando a Recordar", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(v.getContext(), MiCuenta.class);
        startActivity(intent);
    }

    public void privacy(View v)
    {
        Toast.makeText(v.getContext(), "Pasando a Privacy", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(v.getContext(), Privacy.class);
        startActivity(intent);
    }

    public void inicio(View v)
    {
        Toast.makeText(v.getContext(), "Pasando a Inicio", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(v.getContext(), Inicio.class);
        startActivity(intent);
    }
}