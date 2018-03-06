package com.example.admin.tripmex;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
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
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    public EditText correo;
    public EditText pass;
    public Button registro, login;

    FirebaseAuth.AuthStateListener authListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        correo = (EditText) findViewById(R.id.email);
        pass = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.BotonLogin);
        registro = (Button) findViewById(R.id.BotonRegister);
        authListener = new FirebaseAuth.AuthStateListener(){
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser usuario = firebaseAuth.getCurrentUser(); //Se verifica el estado de la sesion
                if(usuario != null) { //Si el objeto de tipo FirebaseUser es diferente a null, entonces existe una sesion abierta
                    //Intent i = new Intent(LoginActivity.this, RecyclerLibrosActivity.class);
                    //startActivity(i); //Inicia la activdad RecyclerLibrosActivity
                    Toast.makeText(getApplicationContext(), "Sesion iniciada como " + usuario.getEmail(), Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);
                }else{
                    //Toast.makeText(getApplicationContext(),"No hay sesion iniciada",Toast.LENGTH_SHORT).show();
                }
            }
        };
    }

    @Override
    public void onResume(){
        super.onResume();
        FirebaseAuth.getInstance().addAuthStateListener(authListener);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean camposLlenos = validate(new EditText[]{correo,pass}); //Funcion que valida que todos los campos esten llenos
                if(camposLlenos){
                    String user = correo.getText().toString();
                    String contra = pass.getText().toString();
                    //Crea un usuario con un Email y Password
                    FirebaseAuth.getInstance().signInWithEmailAndPassword(user,contra).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override//addOnCompleteListener tiene como funcion avisar el estado de la tarea
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){//Si se cumplio la tarea exitosamente, regresara un true y se concluye que se registro el usuario
                                Toast.makeText(getApplicationContext(),"Sesion iniciada correctamente",Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(i);

                            }else{ //En caso contrario, regresara un false | Con la funcion .getMessage() se puede acceder al mensaje del error
                                Toast.makeText(getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }else{ //De existir algun campo vacio, se notificara el campo y mostrara un Toast
                    Toast.makeText(getApplicationContext(),"Debe completar todos los campos",Toast.LENGTH_SHORT).show();
                }
            }
        });
        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(i); //inicia la actividad del registro del usuario


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
