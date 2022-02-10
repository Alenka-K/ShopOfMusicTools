package com.example.shopofmusictools;

import org.apache.log4j.Logger;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLInitializer {

    private static final Logger logger = Logger.getLogger(SQLInitializer.class);

    public static void run(){
        DataSource dataSource = DataSourceConfig.dataSource();
        int count = 0;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT COUNT(*)  FROM USER_TABLES where table_name LIKE ('LAB2_EK%')");
             ResultSet resultSet = statement.executeQuery()) {
                while ((resultSet.next())) {
                    count = resultSet.getInt("COUNT(*)");
                }
        } catch (SQLException throwables) {
            logger.error(throwables.getStackTrace());
        }
        if(count == 0) {
            Resource initShema = new ClassPathResource("shema.sql");
            Resource initData = new ClassPathResource("data.sql");
            DatabasePopulator databasePopulator = new ResourceDatabasePopulator(initShema,initData);
            DatabasePopulatorUtils.execute(databasePopulator, dataSource);
        }
    }

}
