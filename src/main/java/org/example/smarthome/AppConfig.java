package org.example.smarthome;

import org.example.SmartHomeRunner;
import org.example.smarthome.eventProcessors.DoorEventProcessor;
import org.example.smarthome.eventProcessors.EventProcessor;
import org.example.smarthome.eventProcessors.LightEventProcessor;
import org.example.smarthome.events.EventGenerator;
import org.example.smarthome.events.SensorEvent;
import org.example.smarthome.loader.SmartHomeLoader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

@Configuration
@ComponentScan(basePackages = "org.example.smarthome")
@PropertySource("classpath:application.yml")
public class AppConfig {

    @Value("${smart.home.dump.file}")
    private String smartHomeDumpFile;

    @Bean
    public SmartHomeLoader smartHomeLoader() {
        return new SmartHomeLoader();
    }

    @Bean
    public SmartHomeRunner smartHomeRunner(List<EventProcessor> eventProcessors, EventGenerator eventGenerator) {
        return new SmartHomeRunner(eventProcessors, eventGenerator);
    }
}
