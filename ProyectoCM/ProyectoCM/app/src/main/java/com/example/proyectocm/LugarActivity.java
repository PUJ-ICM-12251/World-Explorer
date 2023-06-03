package com.example.proyectocm;

import androidx.appcompat.app.AppCompatActivity;

import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyectocm.model.Lugar;
import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.ktx.Firebase;

public class LugarActivity extends AppCompatActivity {
    private static final String TAG = LugarActivity.class.getName();
    private FirebaseAuth mAuth;
    private FirebaseUser currentUser;

    Location mlocation;
    LocationManager  LocationM;

    // Variables for Firebase DB
    FirebaseDatabase database;
    DatabaseReference myRef;
    ValueEventListener valueEventListener;
    LatLng latLng;

    TextView nombreLgr;

    TextView lon, lat;

    Lugar lgr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lugar);

        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
        nombreLgr = findViewById(R.id.nombreLgr);
        lat = findViewById(R.id.latitud);
        lon = findViewById(R.id.longitud);


        String lugar = "Usted esta en: " + lgr.getnombre();
        Toast.makeText(LugarActivity.this, lugar, Toast.LENGTH_SHORT).show();


    }
}