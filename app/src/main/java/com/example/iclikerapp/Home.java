package com.example.iclikerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Home extends AppCompatActivity {
    private Button btn_login;
    private Button btn_signUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Function of Login button
        btn_login = (Button) findViewById(R.id.btn_login);
        // After pressed Login
        btn_login.setOnClickListener(view -> {
           Intent intent = new Intent(this, User.class);
           startActivity(intent);
        });

        // Function of signUp button
        btn_signUp = (Button) findViewById(R.id.btn_signUp);
        // After pressed signUp
        btn_signUp.setOnClickListener(view -> {
            Intent intent = new Intent(this, SignUp.class);
            startActivity(intent);
        });
    }

}