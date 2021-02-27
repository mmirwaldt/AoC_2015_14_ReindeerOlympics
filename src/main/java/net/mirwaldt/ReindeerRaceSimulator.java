package net.mirwaldt;

import java.util.Map;

public interface ReindeerRaceSimulator {
    void addReindeer(String name, int velocity, int flyingTime, int restTime);
    Map<String, Integer> simulateRace(int time);
    default int simulateRaceAndReturnWinningDistance(int timeInSeconds) {
        return simulateRaceAndReturnWinningDistance(simulateRace(timeInSeconds));
    }
    static int simulateRaceAndReturnWinningDistance(Map<String, Integer> raceResults) {
        return raceResults.values().stream().mapToInt(Integer::intValue).max().getAsInt();
    }
}
