package com.example.admin.tripmex;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {
    public EditText nombre;
    public EditText correo;
    public EditText password;
    public EditText telefono;
    public Button terminarRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        correo = (EditText) findViewById(R.id.emailRegister);
        password = (EditText) findViewById(R.id.passwordRegister);
        nombre = (EditText) findViewById(R.id.nombreRegister);
        telefono = (EditText) findViewById(R.id.telefonoRegister);
        //Referencias a Firebase
        //FirebaseDatabase tripmex = FirebaseDatabase.getInstance();//Haciendo conexion con nuestra Database
        //final DatabaseReference usuario = tripmex.getReference("usuarios");
        terminarRegistro = (Button) findViewById(R.id.BotonRegisterComplete);
        terminarRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean camposLlenos = validate(new EditText[]{correo,password,nombre,telefono});
                if(camposLlenos){
                    final String newEmail = correo.getText().toString();
                    final String newPassword = password.getText().toString();
                    final String newTelefono = telefono.getText().toString();
                    final String newNombre = nombre.getText().toString();
                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(newEmail,newPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(getApplicationContext(),"Usuario registrado existosamente",Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(i);
                            }
                            else{
                                Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
                }
                else{
                    Toast.makeText(getApplicationContext(),"Debe completar todos los campos",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    private boolean validate(EditText[] fields){
        for(int i=0; i<fields.length; i++){
            EditText currentField=fields[i];
            if(currentField.getText().toString().equals("")){
                currentField.setError("Este campo es requerido");
                return false;
            }
        }
        return true;
    }

}
