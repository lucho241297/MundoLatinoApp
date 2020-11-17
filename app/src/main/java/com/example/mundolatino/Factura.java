package com.example.mundolatino;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Factura extends AppCompatActivity {

    private Button btnGenerarFactura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factura);

        btnGenerarFactura = (Button) findViewById(R.id.btnGenerarFactura);
    }

    public void generarFactura(View view){
        Toast.makeText(this, "Fatura generada",Toast.LENGTH_SHORT).show();
    }


}