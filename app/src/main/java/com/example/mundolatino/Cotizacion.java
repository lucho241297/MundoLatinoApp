package com.example.mundolatino;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Cotizacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cotizacion);
    }

    public void realizarCotizacion(View view){
        Toast.makeText(this, "Cotización Realizada",Toast.LENGTH_SHORT).show();
    }
}