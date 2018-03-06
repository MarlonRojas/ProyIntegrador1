package com.example.admin.tripmex;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;

import java.io.PrintWriter;

public class lugares extends AppCompatActivity {

    ImageButton iglesias, museos, parques, pueblo, monumentos, otros;
    String estado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lugares);
        final Intent intent = getIntent();
        estado = intent.getStringExtra("nombreEstado");
        iglesias = (ImageButton) findViewById(R.id.imgbiglesia);
        museos = (ImageButton) findViewById(R.id.imgbmuseo);
        parques = (ImageButton) findViewById(R.id.imgbparque);
        pueblo = (ImageButton) findViewById(R.id.imgbpueblo);
        monumentos = (ImageButton) findViewById(R.id.imgbmonu);
        otros = (ImageButton) findViewById(R.id.imgbotros);
        iglesias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Museos = new Intent(lugares.this, RecyclerIglesias.class);
                Museos.putExtra("nombreEstado",estado);
                Museos.putExtra("Opcion","Iglesias");
                startActivity(Museos);
            }
        });
        museos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iglesia = new Intent(lugares.this, RecyclerIglesias.class);
                iglesia.putExtra("nombreEstado",estado);
                iglesia.putExtra("Opcion","Museos");
                startActivity(iglesia);
            }
        });
        parques.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent parque = new Intent(lugares.this,RecyclerIglesias.class);
                parque.putExtra("nombreEstado",estado);
                parque.putExtra("Opcion","Parques");
                startActivity(parque);

            }
        });
        pueblo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pueblos = new Intent(lugares.this,RecyclerIglesias.class);
                pueblos.putExtra("nombreEstado",estado);
                pueblos.putExtra("Opcion","Pueblos");
                startActivity(pueblos);

            }
        });
        monumentos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent monumento = new Intent(lugares.this,RecyclerIglesias.class);
                monumento.putExtra("nombreEstado",estado);
                monumento.putExtra("Opcion","Monumentos");
                startActivity(monumento);

            }
        });
        otros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent otro = new Intent(lugares.this,RecyclerIglesias.class);
                otro.putExtra("nombreEstado",estado);
                otro.putExtra("Opcion","Otros");
                startActivity(otro);
            }
        });
    }

}
