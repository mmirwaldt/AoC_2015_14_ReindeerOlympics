package net.mirwaldt.aoc.year2015.day14;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class ReindeerRaceSimulatorMain {
    public static void main(String[] args) throws IOException {
        final List<String> lines = Files.readAllLines(Path.of("input.txt"), StandardCharsets.US_ASCII);
        final ReindeerRaceSimulator reindeerRaceSimulatorForPartOne = new DistanceReindeerRaceSimulator();
        addReindeers(lines, reindeerRaceSimulatorForPartOne);

        final Map<String, Integer> raceResultsForPartOne = reindeerRaceSimulatorForPartOne.simulateRace(2503);

        // {Donner=2655, Vixen=2640, Comet=2493, Prancer=2484, Dasher=2460, Blitzen=2496, Dancer=2516, Rudolph=2540, Cupid=2592}
        System.out.println(raceResultsForPartOne);
        // 2655
        System.out.println(ReindeerRaceSimulator.simulateRaceAndReturnWinning(raceResultsForPartOne));


        final ReindeerRaceSimulator reindeerRaceSimulatorForPartTwo = new EfficientLeadScoringReindeerRaceSimulator();
        addReindeers(lines, reindeerRaceSimulatorForPartTwo);

        final Map<String, Integer> raceResultsPartTwo = reindeerRaceSimulatorForPartTwo.simulateRace(2503);

        // {Donner=414, Vixen=1059, Comet=22, Prancer=153, Dasher=0, Blitzen=5, Dancer=1, Rudolph=887, Cupid=13}
        System.out.println(raceResultsPartTwo);
        // 1059
        System.out.println(ReindeerRaceSimulator.simulateRaceAndReturnWinning(raceResultsPartTwo));
    }

    public static void addReindeers(List<String> lines, ReindeerRaceSimulator reindeerRaceSimulator) {
        for (String line : lines) {
            final String[] tokens = line.split(" ");
            final String name = tokens[0];
            final int velocity = Integer.parseInt(tokens[3]);
            final int flyingTime = Integer.parseInt(tokens[6]);
            final int restTime = Integer.parseInt(tokens[13]);
            reindeerRaceSimulator.addReindeer(name, velocity, flyingTime, restTime);
        }
    }
}
