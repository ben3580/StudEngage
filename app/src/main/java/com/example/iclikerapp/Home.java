package com.example.iclikerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.iclikerapp.Server.Communication;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/* Our 1st screen after the splash screen
   This is where the login happens and user can also choose to create a new account
 */

public class Home extends AppCompatActivity {

    // Get username and password in string format
    String username;
    String password;

    // Click forgot password (to reset)
    TextView btn_forgotPw;
    // Sign up button
    Button btn_signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        // Function of Login button
        Button btn_login = (Button) findViewById(R.id.btn_login);
        // After pressed Login
        btn_login.setOnClickListener(view -> {
            // Get the username (in lowercase) and password given by the user
            username = ((EditText)findViewById(R.id.enter_email)).getText().toString().toLowerCase();
            password = ((EditText) findViewById(R.id.enter_password)).getText().toString();
            // Use Bundle to get data from another activity
            // Try & Catch will prevent app from crashing when try to login without registering
            try {
                Bundle bundle = getIntent().getExtras();
                // Get email and password from SignUp activity using Bundle
                String email = bundle.getString("email");
                String pw = bundle.getString("password");

                Communication home = new Communication();
                Connection homeCon = home.getConnection();
                String checkPassword = "";
                String error = "";

                try{
                    if(homeCon == null){
                        System.out.println("Check Connection");
                    }
                    else{
                        String query = "SELECT user_password FROM tblUser WHERE user_email = " + username;
                        Statement stmt = homeCon.createStatement();
                        ResultSet rs = stmt.executeQuery(query);

                        if(rs.next()){
                            //the variable to compare
                            checkPassword = rs.getString("user_password");
                        }
                        else{
                            error = "invalid query";
                        }

                        homeCon.close();
                    }
                }catch (SQLException throwables) {
                    throwables.printStackTrace();
                    Log.d("sql error", error);
                }

                // Tell user that they cannot have empty username or password
                if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
                    Toast.makeText(this, "Email and password can't be empty", Toast.LENGTH_LONG).show();
                }

                // Show message telling the user they logged in successfully
                // Can login only if match with sign up data
                else if (username.equals(email) && password.equals(pw)) {
                    Toast.makeText(this, username + " login successfully", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(this, User.class);
                    startActivity(intent);
                }
                // Show error message if username/password is incorrect
                else {
                    Toast.makeText(this, "INVALID credentials", Toast.LENGTH_LONG).show();
                }
            }
            catch (Exception e){
                Toast.makeText(this, "User must register first", Toast.LENGTH_LONG).show();
            }
        });

        // Function of forgot password
        btn_forgotPw = (TextView)findViewById(R.id.btn_forgotPw);
        btn_forgotPw.setOnClickListener(view -> {
            Intent intent = new Intent(this, ResetPassword.class);
            startActivity(intent);
        });

        // Function of signUp button
        btn_signUp = (Button) findViewById(R.id.btn_signUp);
        btn_signUp.setOnClickListener(view -> {
            Intent intent = new Intent(this, SignUp.class);
            startActivity(intent);
        });
    };
}