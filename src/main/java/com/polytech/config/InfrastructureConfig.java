package com.polytech.config;

import com.polytech.business.PublicationService;
import com.polytech.business.PublicationServiceImp;
import com.polytech.repository.JdbcPostReposit;
import com.polytech.repository.PostReposit;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * Polytech Marseille
 * Created by Lucile Texier on 14/03/2017.
 */

@Component
@Configuration
@Import(SecurityConfig.class)
@PropertySource("classpath:/applications.properties")
public class InfrastructureConfig {

    @Autowired
    private Environment environment;

    @Value("${dataSource.driverName}")
    private String driverName;

    @Value("${dataSource.url}")
    private String url;

    @Value("${dataSource.username}")
    private String username;

    @Value("${dataSource.password}")
    private String password;

    @Bean
    @Profile("PROD")
    public DataSource prodDataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(environment.getProperty("dataSource.driverName"));
        dataSource.setUrl(environment.getProperty("dataSource.url"));
        dataSource.setUsername(environment.getProperty("dataSource.username"));
        dataSource.setPassword(environment.getProperty("dataSource.password"));
        return dataSource;
    }


    @Bean
    @Profile("DEV")
    public DataSource devDataSource(){
        EmbeddedDatabaseBuilder embeddedDatabaseBuilder = new EmbeddedDatabaseBuilder();
        return embeddedDatabaseBuilder
                .setType(EmbeddedDatabaseType.H2)
                .addScript("database/create-schema.sql")
                .addScript("database/default-users.sql")
                .build();
    }

}
