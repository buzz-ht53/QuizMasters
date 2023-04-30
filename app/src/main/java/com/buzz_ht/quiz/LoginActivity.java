package com.buzz_ht.quiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    EditText etemail, etpassword;
    Button btnLogin;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        intilz();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Login();
            }
        });


    }

    private void Login() {

        String email = etemail.getText().toString().trim();
        String password = etpassword.getText().toString().trim();

        if (email.isEmpty()) {
            etemail.setError("Email can't be empty");
            etemail.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etemail.setError("Enter valid email address");
            etemail.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            etpassword.setError("Password can't be empty");
            etpassword.requestFocus();
            return;
        }


        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    // Sign in success, update UI with the signed-in user's information
                    Toast.makeText(LoginActivity.this, "Authentication Successful.",
                            Toast.LENGTH_SHORT).show();
                    FirebaseUser user = firebaseAuth.getCurrentUser();
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();

                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(LoginActivity.this, "Authentication failed.",
                            Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    private void intilz() {

        etemail = findViewById(R.id.etemail);
        etpassword = findViewById(R.id.etpassword);
        btnLogin = findViewById(R.id.btnlogin);
        firebaseAuth = FirebaseAuth.getInstance();


    }

    public void goToSignUp(View view) {

        startActivity(new Intent(getApplicationContext(), SignUpActivity.class));
        finish();

    }
}