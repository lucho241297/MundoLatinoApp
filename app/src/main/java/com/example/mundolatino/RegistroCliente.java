package com.example.mundolatino;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class RegistroCliente extends AppCompatActivity {

    DatabaseReference referencia;
    Button btnRegistrar;
    EditText nombreCliente;
    EditText telCliente;
    EditText emailCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_cliente);

        btnRegistrar = findViewById(R.id.btnRegistrar);
        nombreCliente = findViewById(R.id.txtNombre);
        telCliente = findViewById(R.id.txtTelefono);
        emailCliente = findViewById(R.id.txtEmailCliente);

        referencia = FirebaseDatabase.getInstance().getReference();

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = nombreCliente.getText().toString();
                String tel = telCliente.getText().toString();
                String email = emailCliente.getText().toString();


                if (nombre.equals("") || (tel.equals("")) || email.equals("")) {
                    validacion();
                } else {
                    Map<String, Object> datosCliente = new HashMap<>();
                    datosCliente.put("nombre", nombre);
                    datosCliente.put("telefono", tel);
                    datosCliente.put("email", email);
                    referencia.child("Cliente").push().setValue(datosCliente);
                    mensaje();
                    limpiar();
                }
            }


        });

    }

    private void mensaje() {
        Toast.makeText(this, "Cliente Registrado", Toast.LENGTH_SHORT).show();
    }

    private void validacion() {
        String nombre = nombreCliente.getText().toString();
        String tel = telCliente.getText().toString();
        String email = emailCliente.getText().toString();

        if(nombre.equals("")){
            nombreCliente.setError("ingresar");
        }else if(tel.equals("")){
            telCliente.setError("ingresar");
        }else if(email.equals("")){
            emailCliente.setError("ingresar");
        }

    }

    private void limpiar() {
        nombreCliente.setText("");
        telCliente.setText("");
        emailCliente.setText("");
    }



}