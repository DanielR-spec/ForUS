package com.example.forus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.nio.channels.Channel;

public class Notificaciones extends AppCompatActivity {

    private Button botonN;
    NotificationCompat.Builder notifica;
    private static final int id = 1;
    private String CHANNEL_ID = "channel ID";
    private String channel_name = "channel Name";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificaciones);
        botonN = findViewById(R.id.btnNotificar);
        notifica = new NotificationCompat.Builder(this);

        notifica.setAutoCancel(true);

        botonN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notifica.setSmallIcon(R.drawable.notificaciones);
                notifica.setTicker("Nueva notificacion");
                notifica.setWhen(System.currentTimeMillis());
                notifica.setContentTitle("Titulo");
                notifica.setContentText("Donar es bueno para el ambiente");

                Intent intent = new Intent(Notificaciones.this, Notificaciones.class);
                PendingIntent pIntent = PendingIntent.getActivity(Notificaciones.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                notifica.setContentIntent(pIntent);

                NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                nm.notify(id, notifica.build());
                int a = 1;
                Log.d("a", String.valueOf(a));
            }
        });
    }
}