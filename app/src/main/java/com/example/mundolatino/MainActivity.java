package com.example.mundolatino;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    private EditText txtemail;
    private EditText txtcontrasena;
    private Button btnIngresar;

    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=(TextView)findViewById(R.id.txtOlvide);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent olvide = new Intent(MainActivity.this, RecuperarContrasena.class);
                startActivity(olvide);
            }

        });

        firebaseAuth = FirebaseAuth.getInstance();
        txtemail = (EditText) findViewById(R.id.txtEmail);
        txtcontrasena = (EditText) findViewById(R.id.txtContrasena);
        btnIngresar = (Button) findViewById(R.id.btnIngresar);

        //btnIngresar.setOnClickListener(this);

    }

    private void ingresarUsuario() {
        //Obtenemos el email y la contraseña desde las cajas de texto
        final String email = txtemail.getText().toString().trim();
        String password = txtcontrasena.getText().toString().trim();

        //Verificamos que las cajas de texto no esten vacías
        if (TextUtils.isEmpty(email)) {//(precio.equals(""))
            Toast.makeText(this, "ingresar Email", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "ingresar contraseña", Toast.LENGTH_LONG).show();
            return;
        }


        //loguear usuario
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //checking if success
                        if (task.isSuccessful()) {
                            int pos = email.indexOf("@");
                            String user = email.substring(0, pos);
                            Intent menu = new Intent(getApplication(), Menu.class);
                            startActivity(menu);


                        } else {
                            if (task.getException() instanceof FirebaseAuthUserCollisionException) {//si se presenta una colisión
                                Toast.makeText(MainActivity.this, "Ese usuario ya existe ", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(MainActivity.this, "email o contraseña errados ", Toast.LENGTH_LONG).show();
                            }
                        }

                    }
                });


    }



    public void onClick(View view) {

                ingresarUsuario();

    }

 //   public void CambiarMenu(View view){
      // Intent menu = new Intent(this, Menu.class);
  //      startActivity(menu);
   // }



}