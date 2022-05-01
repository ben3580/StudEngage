package com.example.iclikerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.iclikerapp.Server.Communication;
import com.example.iclikerapp.Server.Login;
import com.google.android.material.snackbar.Snackbar;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

            // Get connection
            Communication home = new Communication();
            Connection SignUpCon = home.getConnection();
            String error = "";
            int new_isProfessor = 0;

            try{
                if(SignUpCon == null){
                    System.out.println("Check Connection");
                }
                else{
                    String query = "INSERT INTO tblUser (user_email, user_password, user_isProfessor) Values ('"  + email + "', '" + pw + "', " + new_isProfessor + ");";
                    // statement is used for the command we run to the sql
                    Statement stmt = SignUpCon.createStatement();
                    // executeQuery(String) will execute the query with the command string
                    stmt.executeQuery(query);
                    SignUpCon.close();
                }
            }catch (SQLException throwables) {
                throwables.printStackTrace();
                Log.d("sql error", error);
            }

            // Show the name of the user that has been created
            Toast.makeText(this, new_username + " created!", Toast.LENGTH_LONG).show();
            // Go back to login page
            Intent intent = new Intent(this, Login.class);
            startActivity(intent);
        });

        // Function of Sign in button (go back to Home screen)
        btn_signIn = (TextView) findViewById(R.id.click_signIn);
        btn_signIn.setOnClickListener(view -> {
            Intent intent = new Intent(this, Home.class);
            startActivity(intent);
        });
    }
}