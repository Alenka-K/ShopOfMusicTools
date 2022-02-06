package com.example.shopofmusictools;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


@Configuration
public class DataSourceConfig {


    @Value("${spring.datasource.url}")
    private static final String datasourceUrl = "jdbc:oracle:thin:@//localhost:1521/XE";
    @Value("${spring.datasource.driver-class-name}")
    private static final String driverClassName = "oracle.jdbc.OracleDriver";
    @Value("${spring.datasource.username}")
    private static final String userName = "alena";
    @Value("${spring.datasource.password}")
    private static final String password = "123";

    @Bean
    public static DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(datasourceUrl);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);

        return dataSource;
    }



}
