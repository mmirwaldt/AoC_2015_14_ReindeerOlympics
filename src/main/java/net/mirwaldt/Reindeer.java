package net.mirwaldt;

import java.util.Objects;

public class Reindeer {
    private final String name;
    private final int velocityInKmPerSecond;
    private final int flyingTimeInSeconds;
    private final int restTimeInSeconds;

    public Reindeer(String name, int velocityInKmPerSecond, int flyingTimeInSeconds, int restTimeInSeconds) {
        this.name = name;
        this.velocityInKmPerSecond = velocityInKmPerSecond;
        this.flyingTimeInSeconds = flyingTimeInSeconds;
        this.restTimeInSeconds = restTimeInSeconds;
    }

    public String getName() {
        return name;
    }

    public int getVelocityInKmPerSecond() {
        return velocityInKmPerSecond;
    }

    public int getFlyingTimeInSeconds() {
        return flyingTimeInSeconds;
    }

    public int getRestTimeInSeconds() {
        return restTimeInSeconds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reindeer reindeer = (Reindeer) o;
        return velocityInKmPerSecond == reindeer.velocityInKmPerSecond
                && flyingTimeInSeconds == reindeer.flyingTimeInSeconds
                && restTimeInSeconds == reindeer.restTimeInSeconds
                && Objects.equals(name, reindeer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, velocityInKmPerSecond, flyingTimeInSeconds, restTimeInSeconds);
    }

    @Override
    public String toString() {
        return "Reindeer{" +
                "name='" + name + '\'' +
                ", velocityInKmPerSecond=" + velocityInKmPerSecond +
                ", flyingTimeInSeconds=" + flyingTimeInSeconds +
                ", restTimeInSeconds=" + restTimeInSeconds +
                '}';
    }
}
