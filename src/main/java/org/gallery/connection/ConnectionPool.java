package org.gallery.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionPool {


    String connectionUrl = "jdbc:postgresql://localhost:5432/gallery";
    String dbUser = "postgres";
    String dbPwd = "postgres";

    private static ConnectionPool instance = null;



    public Connection getConnection() throws SQLException {


        Connection conn = null;
        try {
            conn = null;
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }



}
