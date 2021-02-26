package net.mirwaldt;

import static java.lang.Math.min;

public abstract class AbstractReindeerRaceSimulator implements ReindeerRaceSimulator {

    public static int simulateRacingReindeer(Reindeer reindeer, int timeInSeconds) {
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
