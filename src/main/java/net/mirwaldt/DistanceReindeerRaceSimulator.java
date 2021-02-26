package net.mirwaldt;

import java.util.*;

import static java.lang.Math.min;

public class DistanceReindeerRaceSimulator implements ReindeerRaceSimulator {
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

    int simulateRacingReindeer(Reindeer reindeer, int timeInSeconds) {
        int traveledDistanceInKm = 0;
        for (int elapsedTimeInSeconds = 0; elapsedTimeInSeconds < timeInSeconds; ) {
            final int remainingTime = timeInSeconds - elapsedTimeInSeconds;
            final int remainingFlyingTime = min(remainingTime, reindeer.getFlyingTimeInSeconds());
            traveledDistanceInKm += reindeer.getVelocityInKmPerSecond() * remainingFlyingTime;
            elapsedTimeInSeconds += reindeer.getFlyingTimeInSeconds() + reindeer.getRestTimeInSeconds();
        }
        return traveledDistanceInKm;
    }
}
