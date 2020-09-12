package org.geeksforgeeks.jbdl7.jdbc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class DBConfig {

    @Value("${db.my_user}")
    String user;

    @Value("${db.my_password}")
    String password;

    @Value("${db.my_url}")
    String url;

    @Bean
    public Connection getDBConnection() throws SQLException{
        System.out.println( "url - " + url + " name " + user);

        try {
            return DriverManager.getConnection(url,  user, password);
        }catch (SQLException e){
            e.printStackTrace();
            throw new SQLException("");
        }
    }
}
