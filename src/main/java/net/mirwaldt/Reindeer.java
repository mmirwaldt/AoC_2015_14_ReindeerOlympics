package net.mirwaldt;

import java.util.Objects;

public class Reindeer {
    private final String name;
    private final int velocity;
    private final int flyingTime;
    private final int restTime;

    public Reindeer(String name, int velocity, int flyingTime, int restTime) {
        this.name = name;
        this.velocity = velocity;
        this.flyingTime = flyingTime;
        this.restTime = restTime;
    }

    public String getName() {
        return name;
    }

    public int getVelocity() {
        return velocity;
    }

    public int getFlyingTime() {
        return flyingTime;
    }

    public int getRestTime() {
        return restTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reindeer reindeer = (Reindeer) o;
        return velocity == reindeer.velocity
                && flyingTime == reindeer.flyingTime
                && restTime == reindeer.restTime
                && Objects.equals(name, reindeer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, velocity, flyingTime, restTime);
    }

    @Override
    public String toString() {
        return "Reindeer{" +
                "name='" + name + '\'' +
                ", velocity=" + velocity +
                ", flyingTime=" + flyingTime +
                ", restTime" + restTime +
                '}';
    }
}
