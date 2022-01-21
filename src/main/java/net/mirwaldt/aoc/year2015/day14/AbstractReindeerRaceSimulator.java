package net.mirwaldt.aoc.year2015.day14;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.min;

public abstract class AbstractReindeerRaceSimulator implements ReindeerRaceSimulator {
    protected final List<Reindeer> reindeers = new ArrayList<>();

    @Override
    public void addReindeer(String name, int velocity, int flyingTime, int restTime) {
        reindeers.add(new Reindeer(name, velocity, flyingTime, restTime));
    }

    public static int simulateRacingReindeer(Reindeer reindeer, int time) {
        int traveledDistance = 0;
        for (int elapsedTime = 0; elapsedTime < time; ) {
            final int remainingTime = time - elapsedTime;
            final int remainingFlyingTime = min(remainingTime, reindeer.getFlyingTime());
            traveledDistance += reindeer.getVelocity() * remainingFlyingTime;
            elapsedTime += reindeer.getFlyingTime() + reindeer.getRestTime();
        }
        return traveledDistance;
    }
}
