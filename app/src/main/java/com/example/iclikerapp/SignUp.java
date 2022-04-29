package com.example.iclikerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.iclikerapp.Server.Login;
import com.google.android.material.snackbar.Snackbar;

import java.util.Locale;

public class SignUp extends AppCompatActivity {
    // Initialization
    TextView btn_signIn;
    String new_username, new_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        // Function of signUp button
        Button btn_createAcc = (Button) findViewById(R.id.btn_createAcc);
        // After the create account button has been pressed
        btn_createAcc.setOnClickListener(view -> {
            new_username = ((EditText) findViewById(R.id.create_Email)).getText().toString();
            new_password = ((EditText) findViewById(R.id.create_Pw)).getText().toString();

            // Convert the input email into lowercase to make it convenient for user
            String email = new_username.toLowerCase();
            String pw = new_password;

            // Store email and password using Bundle (with keys that mapped to them)
            Intent intent = new Intent(this, Home.class);
            Bundle bundle = new Bundle();
            bundle.putString("email", email);
            bundle.putString("password", pw);
            intent.putExtras(bundle);
            SignUp.this.finish();
            startActivity(intent);

            // Show the name of the user that has been created
            Toast.makeText(this, new_username + " created!", Toast.LENGTH_LONG).show();
        });

        // Function of Sign in button (go back to Home screen)
        btn_signIn = (TextView) findViewById(R.id.click_signIn);
        btn_signIn.setOnClickListener(view -> {
            Intent intent = new Intent(this, Home.class);
            startActivity(intent);
        });
    }
}