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
    String email;
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
            email = ((EditText)findViewById(R.id.enter_email)).getText().toString().toLowerCase();
            password = ((EditText) findViewById(R.id.enter_password)).getText().toString();

            // Connect to the database
            Communication home = new Communication();
            Connection homeCon = home.getConnection();
            String checkPassword;
            String checkEmail;
            String error = "";

            try{
                if(homeCon == null){
                    System.out.println("Check Connection");
                }
                else{
                    //String query = "SELECT user_password FROM tblUser WHERE user_email = '" + email + "'";
                    String query = "SELECT user_email, user_password FROM tblUser";
                    Statement stmt = homeCon.createStatement();
                    ResultSet rs = stmt.executeQuery(query);
                    Boolean findEmail = false;
                    String output;
                    while(rs.next()){
                        //the variable to compare
                        checkPassword = rs.getString("user_password");
                        checkEmail = rs.getString("user_email");
                        // Check to see if email matches with the one in the database
                        if(checkEmail.equals(email)) {
                            findEmail = true;
                        }
                        else {
                            continue;
                        }
                        // Check to see if the password matches with the one in the database
                        if (checkPassword.equals(password)) {
                            Intent intent = new Intent(this, User.class);
                            startActivity(intent);
                        }
                    }
                    Toast.makeText(this, output = findEmail ? "Login!" : "User not found", Toast.LENGTH_SHORT).show();
                    homeCon.close();
                }

            }catch (SQLException throwables) {
                throwables.printStackTrace();
                Log.d("sql error", error);
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