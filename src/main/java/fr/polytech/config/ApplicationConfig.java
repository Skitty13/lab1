package fr.polytech.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@Import({InfrastructureConfig.class, SecurityConfig.class})
@ComponentScan(basePackages = "fr.polytech")
@EntityScan("fr.polytech")
@EnableJpaRepositories("fr.polytech.repository")
public class ApplicationConfig {
}
