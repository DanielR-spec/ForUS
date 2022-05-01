package com.example.forus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Privacy extends AppCompatActivity {

    TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy);

        texto = (TextView) findViewById(R.id.texto);
        texto.setText("Esta declaración de privacidad de datos explica cómo y qué datos personales recogemos de usted a través de " +
                "nuestro sitio web. Por datos personales se entienden todos los datos que pueden referirse a usted personalmente, " +
                "como su nombre, dirección, cuenta(s) de correo electrónico, comportamiento del usuario. Cuando usted se pone en " +
                "contacto con nosotros por correo electrónico o a través de un formulario de contacto, guardamos los datos que nos " +
                "ha proporcionado (su cuenta de correo electrónico, posiblemente su nombre y número de teléfono) para poder dar " +
                "respuesta a sus preguntas. Eliminamos los datos recogidos en este contexto cuando su almacenamiento ya no es " +
                "necesario, o limitamos su tratamiento cuando está sujeto a obligaciones legales de conservación de datos. " +
                "En caso de que contratemos a proveedores externos para apoyar funciones individuales de nuestra oferta o si queremos" +
                " utilizar sus datos para publicidad, los procedimientos aplicables pertinentes se describen en detalle a continuación." +
                " A continuación, también describimos los criterios establecidos para la duración del periodo de almacenamiento de datos." +
                " Los datos tratados por nosotros se eliminan o se limita su tratamiento de acuerdo con los artículos 17 y 18 del GDPR. " +
                "A menos que se indique explícitamente lo contrario en esta declaración de privacidad de datos, los datos almacenados " +
                "por nosotros se eliminan tan pronto como dejan de ser necesarios para los fines previstos y ninguna obligación legal " +
                "de conservar los datos impide su eliminación. Se imponen limitaciones al tratamiento de los datos que no se han" +
                " eliminado porque son necesarios para otros fines legalmente permitidos. En otras palabras, esos datos están bloqueados " +
                "y no son accesibles para su tratamiento con otros fines. Esta norma se aplica, por ejemplo, a los datos que deben " +
                "conservarse por motivos relacionados con el derecho mercantil o fiscal.");

    }

    public void iniciar(View v)
    {
        Toast.makeText(v.getContext(), "Pasando a Login", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(v.getContext(), Login.class);
        startActivity(intent);
    }
}