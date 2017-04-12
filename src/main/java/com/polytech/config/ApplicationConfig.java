package com.polytech.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


/**
 * Created by Utilisateur on 13/03/2017.
 */

@Configuration
@Import({InfrastructureConfig.class})
@ComponentScan(basePackages= "com.polytech")

public class ApplicationConfig {

/*
    @Bean
    public PostReposit postRepository(DataSource dataSource){

        return new JdbcPostReposit(dataSource);
    }

    @Bean
    public PublicationService publicationService ( PostReposit postReposit){

        return new PublicationServiceImp(postReposit);
    }*/
}
