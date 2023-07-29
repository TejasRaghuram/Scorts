package com.example.scorts;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

import java.util.Objects;

public class Registration extends AppCompatActivity {

    // Variables
    TextInputEditText email, password;
    Button registerButton;
    TextView Login;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        // Initialize variables
        email = findViewById(R.id.Email);
        password = findViewById(R.id.Password);
        registerButton = findViewById(R.id.Register);
        Login = findViewById(R.id.Login);
        mAuth = FirebaseAuth.getInstance();

        registerButton.setOnClickListener(v -> {

            String email, password;

            email = Objects.requireNonNull(this.email.getText()).toString();
            password = Objects.requireNonNull(this.password.getText()).toString();

            if (TextUtils.isEmpty(email)) {

                Toast.makeText(Registration.this, "Please enter email", Toast.LENGTH_SHORT).show();

            } else if (TextUtils.isEmpty(password)) {

                Toast.makeText(Registration.this, "Please enter password", Toast.LENGTH_SHORT).show();

            } else {

                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {

                                    FirebaseUser user = mAuth.getCurrentUser();
                                    Toast.makeText(Registration.this, "Account created", Toast.LENGTH_SHORT).show();
                                    //TODO: GO TO MAIN ACTIVITY

                                } else {
                                    Toast.makeText(Registration.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }

        });

        Login.setOnClickListener(v -> {

            startActivity(new Intent(Registration.this, Login.class));

        });


    }
}