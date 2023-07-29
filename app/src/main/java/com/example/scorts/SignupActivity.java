package com.example.scorts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;

public class SignupActivity extends AppCompatActivity {


    // Variables
    TextInputEditText signup_email, signup_password, signup_name, signup_runs, signup_wickets;
    String email, password, name, runs, wickets;
    Button signup_submit;
    TextView signup_login;
    FirebaseAuth mAuth;
    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Make the activity full-screen
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_signup);


        // Initialize variables
        signup_email = findViewById(R.id.signup_email);
        signup_password = findViewById(R.id.signup_password);
        signup_name = findViewById(R.id.signup_name);
        signup_runs = findViewById(R.id.signup_runs);
        signup_wickets = findViewById(R.id.signup_wickets);
        signup_login = findViewById(R.id.signup_login);
        signup_submit = findViewById(R.id.signup_submit);
        logo = findViewById(R.id.login_logo);

        mAuth = FirebaseAuth.getInstance();


        // Buttons
        signup_submit.setOnClickListener(v -> {

            String email, password;

            email = Objects.requireNonNull(this.signup_email.getText()).toString();
            password = Objects.requireNonNull(this.signup_password.getText()).toString();

            if (TextUtils.isEmpty(email)) {

                Toast.makeText(SignupActivity.this, "Please enter email", Toast.LENGTH_SHORT).show();

            } else if (TextUtils.isEmpty(password)) {

                Toast.makeText(SignupActivity.this, "Please enter password", Toast.LENGTH_SHORT).show();

            } else {

                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {

                                    FirebaseUser user = mAuth.getCurrentUser();
                                    Toast.makeText(SignupActivity.this, "Account created", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(SignupActivity.this, MainActivity.class));

                                } else {
                                    Toast.makeText(SignupActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }

        });

        signup_login.setOnClickListener(v -> {

            startActivity(new Intent(SignupActivity.this, LoginActivity.class));

        });

        // set login logo
        //logo.setImageResource(R.drawable.scorts_logo);
    }
}