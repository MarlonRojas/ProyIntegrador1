package com.example.admin.tripmex;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class RecyclerIglesias extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Iglesias> iglesias;
    private Adaptador adaptador;
    Context con;

    DatabaseReference referencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        con = this;
        Intent intent = getIntent();
        String estado = (String)intent.getStringExtra("nombreEstado");
        String opcion = (String) intent.getStringExtra("Opcion");
        setContentView(R.layout.activity_recycler_iglesias);
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        referencia = database.getReference("Estados/"+estado+"/"+opcion);
        iglesias= new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.ContenidoIglesias);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
        adaptador = new Adaptador(iglesias, con);
        recyclerView.setAdapter(adaptador); //Se usar el adaptador en el RecyclerView
        referencia.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot Q : dataSnapshot.getChildren()){
                    Iglesias l = Q.getValue(Iglesias.class);
                    iglesias.add(l);
                    adaptador.notifyDataSetChanged();
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

}
