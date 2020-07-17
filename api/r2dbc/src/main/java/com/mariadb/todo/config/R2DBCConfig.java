package com.mariadb.todo.config;

import org.mariadb.r2dbc.MariadbConnectionConfiguration;
import org.mariadb.r2dbc.MariadbConnectionFactory;
import org.mariadb.r2dbc.SslMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Configuration
@EnableR2dbcRepositories
public class R2DBCConfig extends AbstractR2dbcConfiguration {
    @Override
    @Bean
    public MariadbConnectionFactory connectionFactory() {

        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Properties props = new Properties();

        try (InputStream f = loader.getResourceAsStream("db.properties")) {
            props.load(f);        
            return new MariadbConnectionFactory(MariadbConnectionConfiguration.builder()
                        .host(props.getProperty("host"))
                        .port(Integer.parseInt(props.getProperty("port")))
                        .username(props.getProperty("username"))
                        .password(props.getProperty("password"))
                        .database(props.getProperty("database"))
                        .sslMode(SslMode.ENABLE_TRUST)
                        .clientSslCert(props.getProperty("clientSslCert"))
                        .build());
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}