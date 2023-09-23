package org.example.smarthome.loader;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.example.smarthome.SmartHome;

import java.nio.file.Paths;

import static java.nio.file.Files.readAllBytes;

@RequiredArgsConstructor
public class SmartHomeLoader {
    private final String fileName;

    @SneakyThrows
    public SmartHome load() {
        Gson gson = new Gson();
        String json = new String(readAllBytes(Paths.get(fileName)));
        return gson.fromJson(json, SmartHome.class);
    }
}
