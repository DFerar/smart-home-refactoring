package org.example.smarthome.loader;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.example.smarthome.SmartHome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


import java.nio.file.Paths;

import static java.nio.file.Files.readAllBytes;

@RequiredArgsConstructor
@PropertySource("classpath:application.yml")
public class SmartHomeLoader {
    @Value("${smart.home.dump.file}")
    private String fileName;
    @SneakyThrows

    public SmartHome load() {
        Gson gson = new Gson();
        String json = new String(readAllBytes(Paths.get(fileName)));
        return gson.fromJson(json, SmartHome.class);
    }
}
