package net.mirwaldt;

import java.util.*;

import static java.lang.Math.min;

public class DistanceReindeerRaceSimulator extends AbstractReindeerRaceSimulator {
    private final List<Reindeer> reindeers = new ArrayList<>();

    @Override
    public void addReindeer(String name, int velocityInKmPerSecond, int flyingTimeInSeconds, int restTimeInSeconds) {
        reindeers.add(new Reindeer(name, velocityInKmPerSecond, flyingTimeInSeconds, restTimeInSeconds));
    }

    @Override
    public Map<String, Integer> simulateRace(int timeInSeconds) {
        final Map<String, Integer> distancesAfterTimeByReindeers = new HashMap<>();
        for (Reindeer reindeer : reindeers) {
            distancesAfterTimeByReindeers.put(reindeer.getName(), simulateRacingReindeer(reindeer, timeInSeconds));
        }
        return distancesAfterTimeByReindeers;
    }
}
