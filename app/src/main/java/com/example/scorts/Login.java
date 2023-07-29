package com.example.scorts;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;

public class Login extends AppCompatActivity {

    // Variables
    TextInputEditText email, password;
    Button loginButton;
    TextView Register;

    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize variables
        email = findViewById(R.id.Email);
        password = findViewById(R.id.Password);
        loginButton = findViewById(R.id.Login);
        Register = findViewById(R.id.Register);
        mAuth = FirebaseAuth.getInstance();


        Register.setOnClickListener(v -> {

            startActivity(new Intent(Login.this, Registration.class));

        });

        loginButton.setOnClickListener(v -> {

            String email, password;

            email = Objects.requireNonNull(this.email.getText()).toString();
            password = Objects.requireNonNull(this.password.getText()).toString();

            if (email.isEmpty()) {

                this.email.setError("Please enter email");

            } else if (password.isEmpty()) {

                this.password.setError("Please enter password");

            } else {

                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this, task -> {

                            if (task.isSuccessful()) {

                                //TODO: GO TO MAIN ACTIVITY
                                Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();

                            } else {

                                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();


                            }

                        });

            }

        });


    }
}