package com.example.gestion_alumnos.windows;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.gestion_alumnos.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class SignUp extends AppCompatActivity {

    TextView  nameText, surnameText, dniText, emailText, passwordText, courseText;
    Button buttonSignUpUserr;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        instances();
        actions();
    }

    private void instances() {
        nameText = findViewById(R.id.nameSignUp);
        surnameText = findViewById(R.id.surnameSignUp);
        dniText = findViewById(R.id.dniSignUp);
        emailText = findViewById(R.id.emailSignUp);
        passwordText = findViewById(R.id.passwordSignUp);
        courseText = findViewById(R.id.courseSignUp);
        buttonSignUpUserr = findViewById(R.id.buttonSignUpUser);
        firebaseAuth = FirebaseAuth.getInstance();
    }

    private void actions() {
        buttonSignUpUserr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signupUser();
            }
        });
    }

    private void signupUser() {
        String email = emailText.getText().toString().trim();
        String password = passwordText.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Debe ingresar un email.", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Debe ingresar una contraseña.", Toast.LENGTH_LONG).show();
            return;
        }

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference();
        reference.child("uno").child("dos").setValue("tres");


        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){

                            Toast.makeText(SignUp.this,"Usuario registrado: "+ emailText.getText(),Toast.LENGTH_LONG).show();
                        }else{

                            Toast.makeText(SignUp.this,"Usuario no registrado. ",Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}