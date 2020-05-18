package com.mariadb.backend;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class MariaDBClient {
    public static Connection getConnection() throws SQLException {
        Connection conn = null;

        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Properties props = new Properties();

        try (InputStream f = loader.getResourceAsStream("db.properties")) {
            props.load(f);
            conn = DriverManager.getConnection(String.format("jdbc:mariadb://%s:%s/", props.getProperty("host"), props.getProperty("port")), props);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
        return conn;
    }
}