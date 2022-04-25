package com.example.iclikerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class ResetPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        // Button to send reset link
        Button btn_sendResetLink = (Button) findViewById(R.id.btn_emailPwReset);
        btn_sendResetLink.setOnClickListener(view->{
            Intent intent = new Intent(this, Home.class);
            startActivity(intent);

            // Show successfully sent message
            Toast.makeText(this, "Password reset link sent!", Toast.LENGTH_LONG).show();
        });
    }
}