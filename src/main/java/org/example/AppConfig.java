package org.example;

import org.example.smarthome.SmartHome;
import org.example.smarthome.loader.SmartHomeLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan
@PropertySource("classpath:application.yml")
public class AppConfig {
    @Bean
    public SmartHome smartHome(SmartHomeLoader loader) {
        return loader.load();
    }
}
