package com.example.admin.tripmex;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

public class TemplateLugar extends AppCompatActivity {

    TextView tituloXML;
    TextView descripcionXML;
    TextView ubicacionXML;
    TextView paginaWebXML;
    TextView puntuacionXML;
    TextView telefonoXML;
    ImageView imagenXML;
    Context con;
    String latitud2;
    String longitud2;

    Button botonGoogle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        con = this;
        setContentView(R.layout.activity_template_lugar);
        Intent intent = getIntent();
        //getStringExtra recibe los valores de un contexto enviados desde otro Activity
        final String titulo = intent.getStringExtra("nombre");
        String descripcion = intent.getStringExtra("descripcion");
        String url = intent.getStringExtra("url");
        String longitud = intent.getStringExtra("longitud");
        String latitud = intent.getStringExtra("latitud");
        String ubicacion = intent.getStringExtra("ubicacion");
        String paginaWeb = intent.getStringExtra("paginaWeb");
        String puntuacion = intent.getStringExtra("puntuacion");
        String telefono = intent.getStringExtra("telefono");
        longitud2 = longitud;
        latitud2 = latitud;
        tituloXML = (TextView) findViewById(R.id.NombreTemplate);
        tituloXML.setText(titulo);
        descripcionXML = (TextView) findViewById(R.id.DescripcionTemplate);
        descripcionXML.setText(descripcion);
        ubicacionXML = (TextView) findViewById(R.id.Ubicacion);
        paginaWebXML = (TextView) findViewById(R.id.PaginaWebTemplate);
        telefonoXML = (TextView) findViewById(R.id.Telefono);
        puntuacionXML = (TextView) findViewById(R.id.Puntuacion);
        imagenXML = (ImageView) findViewById(R.id.ImagenTemplate);
        ubicacionXML.setText("Ubicacion: "+ ubicacion);
        paginaWebXML.setText("Pagina Web: "+paginaWeb);
        telefonoXML.setText("Telefono: "+telefono);
        puntuacionXML.setText("Puntuacion del lugar: "+puntuacion);
        Picasso.with(this).load(url).into(imagenXML);
        botonGoogle = (Button) findViewById(R.id.butmap);
        botonGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(con,mapxol.class);
                i.putExtra("longitud", longitud2);
                i.putExtra("latitud", latitud2);
                i.putExtra("nombre", titulo);
                startActivity(i);
            }
        });
    }
}
