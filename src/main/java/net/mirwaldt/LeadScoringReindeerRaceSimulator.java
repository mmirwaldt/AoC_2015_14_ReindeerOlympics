package net.mirwaldt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

public class LeadScoringReindeerRaceSimulator extends AbstractReindeerRaceSimulator {
    private final List<Reindeer> reindeers = new ArrayList<>();

    @Override
    public void addReindeer(String name, int velocityInKmPerSecond, int flyingTimeInSeconds, int restTimeInSeconds) {
        reindeers.add(new Reindeer(name, velocityInKmPerSecond, flyingTimeInSeconds, restTimeInSeconds));
    }

    @Override
    public Map<String, Integer> simulateRace(int timeInSeconds) {
        final Map<String, int[]> scores = new HashMap<>();
        for (Reindeer reindeer : reindeers) {
            scores.put(reindeer.getName(), new int[1]);
        }

        final List<Reindeer> leadingReindeers = new ArrayList<>();
        for (int elapsedTimeInSeconds = 1; elapsedTimeInSeconds <= timeInSeconds; elapsedTimeInSeconds++) {
            int maxDistance = 0;
            leadingReindeers.clear();
            for (Reindeer reindeer : reindeers) {
                final int distance = simulateRacingReindeer(reindeer, elapsedTimeInSeconds);
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
