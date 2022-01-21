package net.mirwaldt.aoc.year2015.day14;

import java.util.HashMap;
import java.util.Map;

public class DistanceReindeerRaceSimulator extends AbstractReindeerRaceSimulator {
    @Override
    public Map<String, Integer> simulateRace(int time) {
        final Map<String, Integer> distancesAfterTimeByReindeers = new HashMap<>();
        for (Reindeer reindeer : reindeers) {
            distancesAfterTimeByReindeers.put(reindeer.getName(), simulateRacingReindeer(reindeer, time));
        }
        return distancesAfterTimeByReindeers;
    }
}
