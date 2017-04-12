package com.polytech.config;


import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

/**
 * Polytech Marseille
 * Created by Lucile Texier on 14/03/2017.
 */


@PropertySource("classpath:/applications.properties")
@Import(SecurityConfig.class)
public class InfrastructureConfig {


    @Value("${dataSource.driverName}")
    private String driverName;

    @Value("${dataSource.url}")
    private String url;

    @Value("${dataSource.username}")
    private String username;

    @Value("${dataSource.password}")
    private String password;

    @Value("${datasource.options}")
    private String options;

    @Bean
    @Profile("PROD")
    public DataSource dataSourcePROD() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUsername(this.username);
        dataSource.setPassword(this.password);
        dataSource.setUrl(this.url + (this.options != null ? ("?" + this.options) : ""));
        dataSource.setDriverClassName(this.driverName);

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
