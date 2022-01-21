package net.mirwaldt.aoc.year2015.day14;

import java.util.Map;

public interface ReindeerRaceSimulator {
    void addReindeer(String name, int velocity, int flyingTime, int restTime);
    Map<String, Integer> simulateRace(int time);
    static int simulateRaceAndReturnWinning(Map<String, Integer> raceResults) {
        return raceResults.values().stream().mapToInt(Integer::intValue).max().getAsInt();
    }
}
