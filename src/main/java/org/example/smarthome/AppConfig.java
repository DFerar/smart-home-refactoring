package org.example.smarthome;

import org.example.SmartHomeRunner;
import org.example.smarthome.eventProcessors.EventProcessor;
import org.example.smarthome.eventProcessors.LightEventProcessor;
import org.example.smarthome.events.EventGenerator;
import org.example.smarthome.loader.SmartHomeLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ComponentScan
public class AppConfig {
    @Bean
    public SmartHomeLoader smartHomeLoader() {
        return new SmartHomeLoader();
    }

    @Bean
    public EventGenerator eventGenerator() {
        return new EventGenerator();
    }

    @Bean
    public SmartHomeRunner smartHomeRunner(List<EventProcessor> eventProcessors, EventGenerator eventGenerator) {
        return new SmartHomeRunner(eventProcessors, eventGenerator);
    }
}
