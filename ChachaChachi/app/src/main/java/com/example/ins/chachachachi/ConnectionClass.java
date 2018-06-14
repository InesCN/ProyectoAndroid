package com.example.ins.chachachachi;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;

import com.mysql.jdbc.PreparedStatement;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * Created by Inés on 29/04/2018.
 */

public class ConnectionClass {

    @SuppressLint("NewApi")
    public java.sql.Connection conectar(){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        java.sql.Connection conn = null;
        //String connURL = null;

        try{
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://10.60.10.78:3306/ChachaChachi", "root2","root2");
            System.out.println("Connectado.");
           // conn = DriverManager.getConnection(connURL);
        } catch (Exception e){
            Log.e("ERROR ", e.getMessage());
            e.printStackTrace();
        }
        return conn;
    }

}
