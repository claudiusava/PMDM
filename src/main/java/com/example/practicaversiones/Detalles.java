package com.example.practicaversiones;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.example.practicaversiones.utils.Version;

public class Detalles extends AppCompatActivity {

    ImageView imagen;
    TextView nombre, fecha, numeroVersion;
    TextView textoScroll;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);
        instancias();
        recuperarDatos();
    }

    private void instancias() {
        nombre = findViewById(R.id.nombreDetalles);
        fecha = findViewById(R.id.fechaDetalles);
        numeroVersion = findViewById(R.id.versionDetalles);
        imagen = findViewById(R.id.logoDetalles);
        textoScroll = findViewById(R.id.scroll);
    }

    private void recuperarDatos() {

        Version vRecuperada = null;
        vRecuperada = (Version) getIntent().getExtras().get(MainActivity.TAG_1);

        nombre.setText(vRecuperada.getNombre());
        fecha.setText(vRecuperada.getFecha());
        System.out.println(vRecuperada.getNumeroVersion());
        numeroVersion.setText(String.valueOf(vRecuperada.getNumeroVersion()));
        imagen.setImageResource(vRecuperada.getFoto());
        textoScroll.setText(vRecuperada.getDescripcion());
        textoScroll.setMovementMethod(new ScrollingMovementMethod());

    }
}