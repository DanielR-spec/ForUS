package com.example.forus;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class prueba extends AppCompatActivity {

    private RequestQueue queue;
    String name;

    private static String JSON_URL = "http://localhost:8080/api";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prueba);


        queue = Volley.newRequestQueue(this);
        //HttpHandler handler = new HttpHandler();
        //String txt = handler.post("http://localhost:8080/api");

        //TextView t = (TextView) findViewById(R.id.texto1);
        //t.setText(txt);
        datos();


    }

    public void datos() {
      // String URL = "http://127.0.0.1:8080";
        String url = "https://restcountries.com/v3.1/all";

        Log.d("my Tag", "Entre");

        //JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, URL, null, new Response.Listener<JSONObject>()
        //com.android.volley.Request<String> request = new Request<String>(Request.Method.GET, URL, null)
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("my Tag", "Mande algo");
                Log.d("my Tag", response.toString());

            }
        },
                    new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.d("my Tag", error.toString());
                }
            });
        queue.add(request);
    }
}