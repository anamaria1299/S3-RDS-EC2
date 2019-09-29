package co.edu.escuelaing.arem.aws.application.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class DatabaseConfiguration {

    @Value("${spring.datasource.url}")
    private String databaseUrl;
    @Value("${spring.datasource.username}")
    private String databaseUsername;
    @Value("${spring.datasource.password}")
    private String databasePassword;


    @Bean
    public DataSource getDatabase() {

        BasicDataSource database = new BasicDataSource();
        database.setUrl(databaseUrl);
        database.setUsername(databaseUsername);
        database.setPassword(databasePassword);
        database.setMinIdle(1);
        database.setMaxIdle(5);
        return database;
    }
}

