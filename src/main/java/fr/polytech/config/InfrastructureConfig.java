package fr.polytech.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:/applications.properties")
public class InfrastructureConfig {

    @Value("${datasource.driverName}")
    private String driverName;

    @Value("${datasource.url}")
    private String url;

    @Value("${datasource.username}")
    private String username;

    @Value("${datasource.password}")
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
    public DataSource dataSourceDEV() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        return builder
                .setType(EmbeddedDatabaseType.H2)
                .addScript("database/create-schema.sql")
                .addScript("database/create-defaults.sql")
                .build();
    }
}
