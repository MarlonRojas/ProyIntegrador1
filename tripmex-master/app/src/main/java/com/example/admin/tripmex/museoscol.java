package com.example.admin.tripmex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class museoscol extends AppCompatActivity {
    ImageButton MuseoX;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_museoscol);

        MuseoX = (ImageButton) findViewById(R.id.imgbmusX);
        MuseoX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent MuseoX = new Intent(museoscol.this, museoXol.class);
                startActivity(MuseoX);
            }
        });
    }
}
