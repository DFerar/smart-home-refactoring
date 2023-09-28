package org.example.smarthome.loader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.smarthome.devices.Door;
import org.example.smarthome.devices.Light;
import org.example.smarthome.Room;
import org.example.smarthome.SmartHome;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@PropertySource("classpath:application.yml")
public class SmartHomeBuilder {
    @Value("${smart.home.dump.file}")
    private static String fileName;

    public static void main(String[] args) throws IOException {
        SmartHome smartHome = createSmartHome();
        dumpSmartHome(smartHome);
    }

    private static SmartHome createSmartHome() {
        Room kitchen = new Room(
                List.of(new Light("1", false), new Light("2", true)),
                List.of(new Door("1", false)),
                "kitchen"
        );
        Room bathroom = new Room(
                List.of(new Light("3", true)),
                List.of(new Door("2", false)),
                "bathroom"
        );
        Room bedroom = new Room(
                List.of(new Light("4", false), new Light("5", false), new Light("6", false)),
                List.of(new Door("3", true)),
                "bedroom"
        );
        Room hall = new Room(
                List.of(new Light("7", false), new Light("8", false), new Light("9", false)),
                List.of(new Door("4", false)),
                "hall"
        );
        return new SmartHome(List.of(kitchen, bathroom, bedroom, hall));
    }

    private static void dumpSmartHome(SmartHome smartHome) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(smartHome);
        System.out.println(jsonString);
        Path path = Paths.get(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(jsonString);
        }
    }
}
