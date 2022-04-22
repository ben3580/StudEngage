package com.example.iclikerapp.Server;

import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Login {

    public Login(){

    }

    public Connection getConnection(){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection connection = null;
        String ConnectionURL = null;
        try{
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            ConnectionURL = "jdbc:jtds:sqlserver://studengage.database.windows.net:1433;DatabaseName=StudEngage;user=studengage@studengage;password=WSUpullman123;encrypt=true;trustServerCertificate=false;hostNameInCertificate=.database.windows.net;loginTimeout=30;ssl=request";
            connection = DriverManager.getConnection(ConnectionURL);
        } catch (ClassNotFoundException e) {
            Log.e("error here 1 : ", e.getMessage());
        } catch (SQLException se){
            Log.e("error here 2 : ", se.getMessage());
        } catch (Exception e){
            Log.e("error here 3 : ", e.getMessage());
        }
        return connection;
    }
}
