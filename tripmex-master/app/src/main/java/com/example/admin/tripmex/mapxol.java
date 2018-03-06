package com.example.admin.tripmex;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class mapxol extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    Double longitud;
    Double latitud;
    String nombreDelLugar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapxol);
        Intent intent = getIntent();
        longitud = Double.valueOf(intent.getStringExtra("longitud"));
        latitud = Double.valueOf(intent.getStringExtra("latitud"));
        nombreDelLugar = intent.getStringExtra("nombre");
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng museoXol = new LatLng(latitud, longitud);
        mMap.addMarker(new MarkerOptions().position(museoXol).title(nombreDelLugar));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(museoXol));
    }
}
