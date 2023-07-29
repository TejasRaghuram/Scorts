package com.example.scorts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

    // Variables
    TextInputEditText email, password;
    Button loginButton;
    TextView Register;
    FirebaseAuth mAuth;

    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Make the activity full-screen
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_login);


        // Initialize variables
        email = findViewById(R.id.login_email);
        password = findViewById(R.id.login_password);
        loginButton = findViewById(R.id.login_submit);
        Register = findViewById(R.id.login_signup);
        mAuth = FirebaseAuth.getInstance();
        logo = findViewById(R.id.login_logo);


        Register.setOnClickListener(v -> {

            // Open Signup Activity
            startActivity(new Intent(LoginActivity.this, SignupActivity.class));

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

                                Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(LoginActivity.this, MainActivity.class));


                            } else {

                                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();


                            }

                        });

            }

        });

        // set login logo
        //logo.setImageResource(R.drawable.scorts_logo);


    }
}