package net.mirwaldt;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

import static net.mirwaldt.ReindeerRaceSimulator.simulateRaceAndReturnWinningDistance;

public class ReindeerRaceSimulatorMain {
    public static void main(String[] args) throws IOException {
        final List<String> lines = Files.readAllLines(Path.of("input.txt"), StandardCharsets.US_ASCII);
        final ReindeerRaceSimulator reindeerRaceSimulator = new DistanceReindeerRaceSimulator();
        for (String line : lines) {
            final String[] tokens = line.split(" ");
            final String name = tokens[0];
            final int velocityInKmPerSecond = Integer.parseInt(tokens[3]);
            final int flyingTimeInSeconds = Integer.parseInt(tokens[6]);
            final int restTimeInSeconds = Integer.parseInt(tokens[13]);
            reindeerRaceSimulator.addReindeer(name, velocityInKmPerSecond, flyingTimeInSeconds, restTimeInSeconds);
        }

        final Map<String, Integer> raceResults = reindeerRaceSimulator.simulateRace(2503);

        // {Donner=2655, Vixen=2640, Comet=2493, Prancer=2484, Dasher=2460, Blitzen=2496, Dancer=2516, Rudolph=2540, Cupid=2592}
        System.out.println(raceResults);
        // 2655
        System.out.println(simulateRaceAndReturnWinningDistance(raceResults));


    }
}
