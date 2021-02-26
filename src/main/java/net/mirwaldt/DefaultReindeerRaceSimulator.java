package net.mirwaldt;

import java.util.Collections;
import java.util.Map;

public class DefaultReindeerRaceSimulator implements ReindeerRaceSimulator {
    @Override
    public void addReindeer(String name, int velocityInKmPerSecond, int flyingTimeInSeconds, int restTimeInSeconds) {

    }

    @Override
    public Map<String, Integer> simulateRace(int timeInSeconds) {
        return Collections.emptyMap();
    }
}
