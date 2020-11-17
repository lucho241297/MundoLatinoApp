package com.example.mundolatino;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Cliente extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente);
    }

    public void Registrar(View view){
        Intent registrar = new Intent(this, RegistroCliente.class);
        startActivity(registrar);
    }

    public void VerClientes(View view){
        Intent ver = new Intent(this, VistaClientes.class);
        startActivity(ver);
    }

    private String nombre;
    private String telefono;
    private String email;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}