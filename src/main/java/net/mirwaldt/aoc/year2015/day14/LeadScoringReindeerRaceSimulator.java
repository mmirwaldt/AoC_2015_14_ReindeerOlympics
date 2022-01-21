package net.mirwaldt.aoc.year2015.day14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

public class LeadScoringReindeerRaceSimulator extends AbstractReindeerRaceSimulator {
    private final List<Reindeer> reindeers = new ArrayList<>();

    @Override
    public void addReindeer(String name, int velocity, int flyingTime, int restTime) {
        reindeers.add(new Reindeer(name, velocity, flyingTime, restTime));
    }

    @Override
    public Map<String, Integer> simulateRace(int time) {
        final Map<String, int[]> scores = new HashMap<>();
        for (Reindeer reindeer : reindeers) {
            scores.put(reindeer.getName(), new int[1]);
        }

        final List<Reindeer> leadingReindeers = new ArrayList<>();
        for (int elapsedTime = 1; elapsedTime <= time; elapsedTime++) {
            int maxDistance = 0;
            leadingReindeers.clear();
            for (Reindeer reindeer : reindeers) {
                final int distance = simulateRacingReindeer(reindeer, elapsedTime);
                if(maxDistance < distance) {
                    leadingReindeers.clear();
                    leadingReindeers.add(reindeer);
                    maxDistance = distance;
                } else if(maxDistance == distance) {
                    leadingReindeers.add(reindeer);
                }
            }
            for (Reindeer reindeer : leadingReindeers) {
                scores.get(reindeer.getName())[0]++;
            }
        }
        return scores.entrySet().stream().collect(toMap(Map.Entry::getKey, entry -> entry.getValue()[0]));
    }
}
