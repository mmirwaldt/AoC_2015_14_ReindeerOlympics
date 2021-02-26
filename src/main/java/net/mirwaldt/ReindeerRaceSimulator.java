package net.mirwaldt;

import java.util.Map;

public interface ReindeerRaceSimulator {
    void addReindeer(String name, int velocityInKmPerSecond, int flyingTimeInSeconds, int restTimeInSeconds);
    Map<String, Integer> simulateRace(int timeInSeconds);
    default int simulateRaceAndReturnWinningDistance(int timeInSeconds) {
        return simulateRace(timeInSeconds).values().stream().mapToInt(Integer::intValue).max().getAsInt();
    }
}
