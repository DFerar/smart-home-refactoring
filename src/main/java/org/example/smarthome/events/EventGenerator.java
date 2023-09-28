package org.example.smarthome.events;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Math.random;
import static java.lang.String.valueOf;
import static java.util.concurrent.ThreadLocalRandom.current;

@Setter
@Component
@PropertySource("classpath:application.yml")
public class EventGenerator {
    private final ThreadLocalRandom random = current();
    @Value("${stop.probability}")
    private double stopProbability;

    public SensorEvent generateNextSensorEvent() {
        // pretend like we're getting the events from physical world, but here we're going to just generate some random events
        if (random() < stopProbability) return null; // null means end of event stream

        SensorEventType[] types = SensorEventType.values();
        int typeInd = random.nextInt(0, types.length);
        var type = types[typeInd];

        String objectId = valueOf(random.nextInt(0, 10));
        return new SensorEvent(type, objectId);
    }
}
