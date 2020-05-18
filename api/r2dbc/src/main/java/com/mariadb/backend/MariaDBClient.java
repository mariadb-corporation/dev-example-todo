package com.mariadb.backend;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

import org.mariadb.r2dbc.MariadbConnectionConfiguration;
import org.mariadb.r2dbc.MariadbConnectionFactory;
import org.mariadb.r2dbc.SslMode;

import io.r2dbc.spi.Connection;

public class MariaDBClient {

    public static Connection getConnection() throws SQLException {
        MariadbConnectionConfiguration conf;
        MariadbConnectionFactory connFactory;
        Connection conn = null;

        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Properties props = new Properties();

        try (InputStream f = loader.getResourceAsStream("db.properties")) {
            props.load(f);

            // Configuration the Connection
            conf = MariadbConnectionConfiguration.builder()
                    .host(props.getProperty("host"))
                    .port(Integer.parseInt(props.getProperty("port")))
                    .username(props.getProperty("username"))
                    .password(props.getProperty("password"))
                    .database(props.getProperty("database"))
                    .sslMode(SslMode.ENABLE_TRUST)
                    .clientSslCert(props.getProperty("clientSslCert"))
                    .build();

            // Instantiate Connection Factory
            connFactory = new MariadbConnectionFactory(conf);

            // Instantiate Connection
            conn = connFactory.create().block();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }

}