package net.mirwaldt.aoc.year2015.day14;

import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;

import static java.lang.Math.min;

public class EfficientLeadScoringReindeerRaceSimulator extends AbstractReindeerRaceSimulator {
    @Override
    public Map<String, Integer> simulateRace(int time) {
        return new ReindeerRace().simulateRace(time, reindeers);
    }

    static class ReindeerRace {
        private final ReindeerRaceScore reindeerRaceScore = new ReindeerRaceScore();
        private final ReindeerHerd reindeerHerd = new ReindeerHerd();

        public Map<String, Integer> simulateRace(int time, List<Reindeer> reindeers) {
            reindeerRaceScore.init(reindeers);
            reindeerHerd.init(reindeers);
            simulate(time);
            return reindeerRaceScore.convertToResultMap();
        }

        private void simulate(int time) {
            for (int elapsedTime = 0; elapsedTime < time; ) {
                elapsedTime += letReindeersFlyAndRest(time, elapsedTime);
             }
        }

        private int letReindeersFlyAndRest(int time, int elapsedTime) {
            final int remainingTime = min(time - elapsedTime, getTimeOfFirstEntry());
            reindeerRaceScore.letReindeersFly(remainingTime, reindeerHerd.getAllFlyingReindeers());
            reindeerHerd.updateFlyingAndRestingReindeers(remainingTime);
            return remainingTime;
        }

        private int getTimeOfFirstEntry() {
            final NavigableMap<Integer, Set<Reindeer>> flyingReindeers = reindeerHerd.getFlyingReindeers();
            final NavigableMap<Integer, Set<Reindeer>> restingReindeers = reindeerHerd.getRestingReindeers();
            if (!flyingReindeers.isEmpty() && restingReindeers.isEmpty()) {
                return flyingReindeers.firstKey();
            } else if (flyingReindeers.isEmpty() && !restingReindeers.isEmpty()) {
                return restingReindeers.firstKey();
            } else if (!flyingReindeers.isEmpty()) {
                return min(flyingReindeers.firstKey(), restingReindeers.firstKey());
            } else {
                throw new AssertionError("This should never happen." + toString());
            }
        }

        @Override
        public String toString() {
            return "ReindeerRace{" +
                    "reindeerRaceScore=" + reindeerRaceScore +
                    ", reindeerHerd=" + reindeerHerd +
                    '}';
        }
    }
}
