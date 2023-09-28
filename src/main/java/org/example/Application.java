package org.example;

import org.example.smarthome.SmartHomeRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Application {

    public static void main(String... args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        SmartHomeRunner smartHomeRunner = context.getBean(SmartHomeRunner.class);
        smartHomeRunner.run();
    }
}
