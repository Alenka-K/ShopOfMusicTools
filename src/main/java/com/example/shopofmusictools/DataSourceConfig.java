package com.example.shopofmusictools;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.DataSource;


@Configuration
public class DataSourceConfig {


    //@Value("${spring.datasource.url}")
    private static final String datasourceUrl = "jdbc:oracle:thin:@//localhost:1521/XE";
    //@Value("${spring.datasource.driver-class-name}")
    private static final String driverClassName = "oracle.jdbc.OracleDriver";
    //@Value("${spring.datasource.username}")
    private static final String userName = "alena";
    //@Value("${spring.datasource.password}")
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
