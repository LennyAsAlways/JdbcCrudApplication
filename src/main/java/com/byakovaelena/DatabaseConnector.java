package com.byakovaelena;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnector {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "postgres";

    private static Connection connection;

    static {
        try{
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception d){
            d.printStackTrace();
        }
    }
    public static Connection getConnection (){
        return connection;
    }
}