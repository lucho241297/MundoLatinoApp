package com.example.mundolatino;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    //metodo que permite ir a la vista de cliente al dar clic sobre el icono de clientes
    public void Cliente(View view){
        Intent cliente = new Intent(this, Cliente.class);
        startActivity(cliente);
    }

    public void Cotizacion(View view){
        Intent cotizacion = new Intent(this, Cotizacion.class);
        startActivity(cotizacion);
    }

    public void Factura(View view){
        Intent factura = new Intent(this, Factura.class);
        startActivity(factura);
    }



}