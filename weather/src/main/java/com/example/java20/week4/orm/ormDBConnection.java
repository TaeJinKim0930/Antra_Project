package com.example.java20.week4.orm;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * this is only used for checking DB connection.
 * ******* This file can be ignored *******
 */

public class ormDBConnection {
    public Connection connect_db(String dbname, String user, String pass) {
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbname, user, pass);
            // checking whether the connection is successful or not
            if(conn != null) {
                System.out.println("Connection Establishedd");
            } else {
                System.out.println("Connection Failedd");
            }
        } catch (Exception ex) {
            System.out.println("Connection error : " + ex);
        }
        return conn;
    }
}
