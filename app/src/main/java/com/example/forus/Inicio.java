package com.example.forus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class Inicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        //setHasOptionsMenu(true);

        Toolbar toolbar = findViewById(R.id.tb);
        setSupportActionBar(toolbar);
        //getSupportFragmentManager().beginTransaction().add(R.id.frameMicuenta, new MiCuenta()).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.nav_drawer_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.miItem1:
                Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(Inicio.this, Inicio.class);
                intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent1);
                return true;

            case R.id.miItem2:
                Toast.makeText(this, "Notificaciones", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(Inicio.this, GestionarPrenda.class);
                intent2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent2);
                return true;

            case R.id.miItem3:
                Toast.makeText(this, "MiCuenta", Toast.LENGTH_SHORT).show();
                Intent intent3 = new Intent(Inicio.this, MiCuenta .class);
                intent3.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent3);
                return true;

            case R.id.miItem4:
                Toast.makeText(this, "Saliendo...", Toast.LENGTH_SHORT).show();
                Intent intent4 = new Intent(Inicio.this, Login.class);
                intent4.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent4);
                return true;

            case R.id.miItem5:
                Toast.makeText(this, "Ayuda", Toast.LENGTH_LONG).show();
                //getSupportFragmentManager().beginTransaction().replace(R.id.frame1, new fragmento1()).commit();
                //Intent intent = new Intent(Inicio.this, Ayuda.class);
                //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                //startActivity(intent);
                return true;


        }
        return super.onOptionsItemSelected(item);
    }

    public void total(View v)
    {
        Toast.makeText(v.getContext(), "Pasando a registrarse", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(v.getContext(), Registrarse.class);
        startActivity(intent);
    }

    public void calidad(View v)
    {
        Toast.makeText(v.getContext(), "Pasando a registrarse", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(v.getContext(), Registrarse.class);
        startActivity(intent);
    }

    public void catalogo(View v)
    {
        Toast.makeText(v.getContext(), "Pasando a Catalogo", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(v.getContext(), Categoria.class);
        startActivity(intent);
    }

    public void donar(View v)
    {
        Toast.makeText(v.getContext(), "Pasando a registrarse", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(v.getContext(), Registrarse.class);
        startActivity(intent);
    }

    public void donaciones(View v)
    {
        Toast.makeText(v.getContext(), "Pasando a registrarse", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(v.getContext(), Registrarse.class);
        startActivity(intent);
    }

    public void recomendacion(View v)
    {
        Toast.makeText(v.getContext(), "Pasando a registrarse", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(v.getContext(), Registrarse.class);
        startActivity(intent);
    }
}