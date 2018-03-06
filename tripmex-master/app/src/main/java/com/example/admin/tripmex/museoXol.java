package com.example.admin.tripmex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class museoXol extends AppCompatActivity {

    Button Mapa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_museo_xol);
        Mapa = (Button) findViewById(R.id.butmap);
        Mapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Mapa = new Intent(museoXol.this, mapxol.class);
                startActivity(Mapa);
            }
        });
    }
}
