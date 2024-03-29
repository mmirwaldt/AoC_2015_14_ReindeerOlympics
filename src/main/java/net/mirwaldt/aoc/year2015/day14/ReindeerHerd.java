package net.mirwaldt.aoc.year2015.day14;

import java.util.*;
import java.util.stream.Collectors;

public class ReindeerHerd {
    private NavigableMap<Integer, Set<Reindeer>> flyingReindeers = new TreeMap<>();
    private NavigableMap<Integer, Set<Reindeer>> restingReindeers = new TreeMap<>();
    private NavigableMap<Integer, Set<Reindeer>> newFlyingReindeers;
    private NavigableMap<Integer, Set<Reindeer>> newRestingReindeers;

    public void init(List<Reindeer> reindeers) {
        for (Reindeer reindeer : reindeers) {
            flyingReindeers.computeIfAbsent(
                    reindeer.getFlyingTime(), key -> new HashSet<>()).add(reindeer);
        }
    }

    public NavigableMap<Integer, Set<Reindeer>> getFlyingReindeers() {
        return flyingReindeers;
    }

    public NavigableMap<Integer, Set<Reindeer>> getRestingReindeers() {
        return restingReindeers;
    }

    public Set<Reindeer> getAllFlyingReindeers() {
        return flyingReindeers.values().stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
    }

    public void updateFlyingAndRestingReindeers(int remainingTime) {
        newFlyingReindeers = new TreeMap<>();
        newRestingReindeers = new TreeMap<>();

        updateFlyingReindeersAndMakeThemRest(remainingTime);
        updateRestingReindeersAndMakeThemFlyAgain(remainingTime);

        flyingReindeers = newFlyingReindeers;
        restingReindeers = newRestingReindeers;
    }

    private void updateRestingReindeersAndMakeThemFlyAgain(int remainingTime) {
        for (Map.Entry<Integer, Set<Reindeer>> entry : restingReindeers.entrySet()) {
            final int remainingRestingTime = entry.getKey() - remainingTime;
            if (0 < remainingRestingTime) {
                newRestingReindeers.computeIfAbsent(remainingRestingTime,
                        key -> new HashSet<>()).addAll(entry.getValue());
            } else if(0 == remainingRestingTime) {
                for (Reindeer restedReindeer : entry.getValue()) {
                    newFlyingReindeers.computeIfAbsent(restedReindeer.getFlyingTime(),
                            key -> new HashSet<>()).add(restedReindeer);
                }
            }
        }
    }

    private void updateFlyingReindeersAndMakeThemRest(int remainingTime) {
        for (Map.Entry<Integer, Set<Reindeer>> entry : flyingReindeers.entrySet()) {
            final int remainingFlyingTime = entry.getKey() - remainingTime;
            if (0 < remainingFlyingTime) {
                newFlyingReindeers.computeIfAbsent(remainingFlyingTime,
                        key -> new HashSet<>()).addAll(entry.getValue());
            } else if(0 == remainingFlyingTime) {
                for (Reindeer nextRestingReindeer : entry.getValue()) {
                    newRestingReindeers.computeIfAbsent(nextRestingReindeer.getRestTime(),
                            key -> new HashSet<>()).add(nextRestingReindeer);
                }
            }
        }
    }

    @Override
    public String toString() {
        return "ReindeerHerd{" +
                "flyingReindeers=" + flyingReindeers +
                ", restingReindeers=" + restingReindeers +
                '}';
    }
}
