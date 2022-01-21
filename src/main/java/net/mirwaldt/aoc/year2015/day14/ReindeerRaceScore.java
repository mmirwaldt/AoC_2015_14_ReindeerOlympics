package net.mirwaldt.aoc.year2015.day14;

import java.util.*;

import static java.util.stream.Collectors.toMap;

public class ReindeerRaceScore {
    private final Map<String, int[]> scores = new HashMap<>();
    private final Map<String, int[]> distancesByReindeers = new HashMap<>();
    private final Set<Reindeer> leadingReindeers = new HashSet<>();
    private int maxDistance = 0;

    public void init(List<Reindeer> reindeers) {
        for (Reindeer reindeer : reindeers) {
            scores.put(reindeer.getName(), new int[1]);
            distancesByReindeers.put(reindeer.getName(), new int[1]);
        }
    }

    public void letReindeersFly(int remainingFlyingTime, Set<Reindeer> flyingReindeers) {
        for (int i = 0; i < remainingFlyingTime; i++) {
            letReindeersFlyForAMoment(flyingReindeers);
            scoreLeadingReindeers();
        }
    }

    private void letReindeersFlyForAMoment(Set<Reindeer> flyingReindeers) {
        for (Reindeer flyingReindeer : flyingReindeers) {
            int[] newTotalDistance = distancesByReindeers.get(flyingReindeer.getName());
            newTotalDistance[0] += flyingReindeer.getVelocity();
            if (maxDistance < newTotalDistance[0]) {
                leadingReindeers.clear();
                leadingReindeers.add(flyingReindeer);
                maxDistance = newTotalDistance[0];
            } else if (maxDistance == newTotalDistance[0]) {
                leadingReindeers.add(flyingReindeer);
            }
        }
    }

    private void scoreLeadingReindeers() {
        for (Reindeer reindeer : leadingReindeers) {
            scores.get(reindeer.getName())[0] += 1;
        }
    }

    public Map<String, Integer> convertToResultMap() {
        return scores.entrySet().stream().collect(toMap(Map.Entry::getKey, entry -> entry.getValue()[0]));
    }

    @Override
    public String toString() {
        return "ReindeerRaceScore{" +
                "scores=" + scores +
                ", distancesByReindeers=" + distancesByReindeers +
                ", leadingReindeers=" + leadingReindeers +
                ", maxDistance=" + maxDistance +
                '}';
    }
}

