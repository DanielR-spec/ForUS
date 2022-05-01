package com.example.forus;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.InputStream;

public class RegistrarRopa extends AppCompatActivity {

    Spinner spinner;
    Button seleccionar, tomar;
    ImageView imagen;
    RadioButton rbh, rbm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_ropa);

        Toolbar toolbar = findViewById(R.id.tb);
        setSupportActionBar(toolbar);

        seleccionar = findViewById(R.id.btnGaleria);
        tomar = findViewById(R.id.btnCamara);
        imagen = findViewById(R.id.prenda);
        rbh = (RadioButton) findViewById(R.id.rbHombre);
        rbm = (RadioButton) findViewById(R.id.rbMujer);
        spinner = (Spinner) findViewById(R.id.tipoPrenda);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String nivel = (String) spinner.getSelectedItem();
                Toast.makeText(getBaseContext(), "El item seleccionado es: "+
                                spinner.getSelectedItemId()+" "+nivel,
                        Toast.LENGTH_LONG).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        tomar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    if(checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED){
                        String [] permiso = {Manifest.permission.CAMERA};
                        requestPermissions(permiso,10);
                    }
                    else{
                        abrirCamara();
                    }
                }
                else {
                    abrirCamara();
                }
            }
        });
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
                Intent intent1 = new Intent(RegistrarRopa.this, Inicio.class);
                intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent1);
                return true;

            case R.id.miItem2:
                Toast.makeText(this, "Notificaciones", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(RegistrarRopa.this,  GestionarPrenda.class);
                intent2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent2);
                return true;

            case R.id.miItem3:
                Toast.makeText(this, "MiCuenta", Toast.LENGTH_SHORT).show();
                Intent intent3 = new Intent(RegistrarRopa.this, MiCuenta .class);
                intent3.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent3);
                return true;

            case R.id.miItem4:
                Toast.makeText(this, "Saliendo...", Toast.LENGTH_SHORT).show();
                Intent intent4 = new Intent(RegistrarRopa.this, Login.class);
                intent4.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent4);
                return true;

            case R.id.miItem5:
                Toast.makeText(this, "Ayuda", Toast.LENGTH_LONG).show();
                //getSupportFragmentManager().beginTransaction().replace(R.id.frame1, new fragmento1()).commit();
                //Intent intent = new Intent(RegistrarRopa.this, Ayuda.class);
                //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                //startActivity(intent);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    public void tomarFoto(View v) {
        abrirCamara();

    }

    public void tomarGaleria(View v){
        cargarImagen();
    }

    public void abrirCamara(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                if(checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED){
                    String [] permiso = {Manifest.permission.CAMERA};
                    requestPermissions(permiso,10);
                }
                else{
                    startActivityForResult(intent,10);
                }
            }
            else {
                startActivityForResult(intent,10);
            }
        }
    }

    public void cargarImagen(){
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/");
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if(checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED){
                String [] permiso = {Manifest.permission.READ_EXTERNAL_STORAGE};
                requestPermissions(permiso,20);
            }
            else{
                startActivityForResult(intent.createChooser(intent,"Seleccione la aplicacion"),20);
            }
        }
        else {
            startActivityForResult(intent.createChooser(intent,"Seleccione la aplicacion"),20);
        }
        //startActivityForResult(intent, IMAGE_PICKER_REQUEST);
    }

    /*public void abrirCamara(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivityForResult(intent.createChooser(intent,"Seleccione la aplicacion"),10);
        }
    }*/

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 10: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    abrirCamara();

                } else {
                    Toast.makeText(RegistrarRopa.this, "Permiso denegado....", Toast.LENGTH_LONG).show();
                }
            }
            case 20: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    cargarImagen();

                } else {
                    Toast.makeText(RegistrarRopa.this, "Permiso denegado....", Toast.LENGTH_LONG).show();
                }
            }
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK ) {
            Uri path = data.getData();
            imagen.setImageURI(path);
        }
        if(requestCode == 10 && resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imagen.setImageBitmap(imageBitmap);
        }
    }
/*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imagen.setImageBitmap(imageBitmap);
        }*/
    }
