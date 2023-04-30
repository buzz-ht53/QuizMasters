package com.buzz_ht.quiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.buzz_ht.quiz.MainActivity;
import com.buzz_ht.quiz.R;
import com.buzz_ht.quiz.LoginActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUpActivity extends AppCompatActivity {

    FirebaseAuth firebaseAuth;
    EditText etEmail, etPassword;
    Button btnSignUp;
    ConstraintLayout ll;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        intilz();


        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signUp();
            }
        });

    }

    private void signUp() {

        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if (email.isEmpty()) {
            etEmail.setError("Email can't be empty");
            etEmail.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmail.setError("Enter valid email address");
            etEmail.requestFocus();
            return;
        }
        if (password.isEmpty()) {
            etPassword.setError("Password can't be empty");
            etPassword.requestFocus();
            return;
        }


        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    // Sign in success, update UI with the signed-in user's information
                    FirebaseUser user = firebaseAuth.getCurrentUser();
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    Toast.makeText(SignUpActivity.this, "Authentication Successful.",
                            Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(SignUpActivity.this, "Authentication failed.",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void intilz() {

        firebaseAuth = FirebaseAuth.getInstance();
        etEmail = findViewById(R.id.etemail1);
        etPassword = findViewById(R.id.etpassword1);
        btnSignUp = findViewById(R.id.btnsignup);
        ll = findViewById(R.id.ll);

    }

    public void goToLogin(View view) {

        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        finish();


    }
}