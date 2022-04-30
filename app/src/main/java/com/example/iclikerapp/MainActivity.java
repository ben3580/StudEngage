package com.example.iclikerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.example.iclikerapp.Server.Communication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// public class MainActivity{ //extends AppCompatActivity {
// //
// //    private static String ip =
// //    private static String port =
// //    private static String Classs =
// //    private static String database =
//     private static String sererUser = "studengage";
//     private static String serverPass = "WSUpullman123*";
//     private static String serverURL = "jdbc:sqlserver://studengage.database.windows.net:1433;database=StudEngage;user=studengage@studengage;password=WSUpullman123*;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";


//     public static void main(String[] args) {

//         Connection con = null;

//         String serverUser = "studengage";
//         String serverPass = "WSUpullman123*";
//         ResultSet rs = null;

//         try {
//             con = DriverManager.getConnection(serverURL);
//             Statement statement = con.createStatement();
//             String qry = "SELECT stud_username FROM tblStudentUser WHERE stud_name = Sarah Harrison";

//             rs = statement.executeQuery(qry);

//             while(rs.next()){

//                 System.out.println(rs.getString(2));
//             }

//         } catch (SQLException throwables) {
//             throwables.printStackTrace();
//         }
//}}
        
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Make the flash screen looks better by hiding the Action bar
        getSupportActionBar().hide();
        // Show the flash screen (with logo of our app) for 2.5s then go to Home screen

        Communication home = new Communication();
        Connection homeCon = home.getConnection();
        String checkPassword = "";
        String error = "";
        String test = "";

        try{
            if(homeCon == null){
                System.out.println("Check Connection");
            }
            else{
                test = "Sarahharrisonb";
                //String query = "SELECT user_password FROM tblUser WHERE user_username = 'Sarahharrisonb'";
                String query = "SELECT * FROM tblUser";
                //String query = "UPDATE tblUser SET user_email = 'testing chris', user_password = 'passwordchange' WHERE user_name = 'Chris'";

                // statement is used for the command we run to the sql
                Statement stmt = homeCon.createStatement();
                // resultSet is used to fetch the data from sql, the object can be used like a iterator through rows
                ResultSet rs = stmt.executeQuery(query);

                // executeQuery(String) will execute the query with the command string
                stmt.executeQuery(query);
//                while(rs.next()){
//                    //the variable to compare
//
//                    checkPassword = rs.getString("user_name") + rs.getString("user_username") + rs.getString("user_password") + rs.getString("user_email") + rs.getInt("user_joinedClassroom") + rs.getInt("user_isProfessor");
//                    System.out.println(checkPassword);
//                    //Toast.makeText(this, checkPassword, Toast.LENGTH_SHORT).show();
//                    checkPassword = "";
//                }


                homeCon.close();
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
            Log.d("sql error", error);
        }

        System.out.println(checkPassword);

//        Communication home = new Communication();
//        Connection homeCon = home.getConnection();
//        String error = "";
//
//        try{
//            if(homeCon == null){
//                System.out.println("Check Connection");
//            }
//            else{
//                String query = "INSERT INTO tblUser (user_name, user_username, user_password, user_email, user_joinedClassroom, user_isProfessor) Values ('Roy', 'RoyUser', '1234', 'roy@wsu.edu', 1, 0);";
//                Statement stmt = homeCon.createStatement();
//                //ResultSet rs = stmt.executeQuery(query);
//
//                stmt.executeQuery(query);
//
//                homeCon.close();
//            }
//        }catch (SQLException throwables) {
//            throwables.printStackTrace();
//            Log.d("sql error", error);
//        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, Home.class);
                startActivity(intent);
                finish();
            }
        }, 2500);

    }
} 
