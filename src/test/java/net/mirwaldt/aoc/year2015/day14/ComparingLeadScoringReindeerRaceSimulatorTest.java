package net.mirwaldt.aoc.year2015.day14;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static net.mirwaldt.aoc.year2015.day14.ReindeerRaceSimulatorMain.addReindeers;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComparingLeadScoringReindeerRaceSimulatorTest {
    @Test
    void test_example() {
        final ReindeerRaceSimulator expectedScoresSimulator = new LeadScoringReindeerRaceSimulator();
        expectedScoresSimulator.addReindeer("Comet", 14, 10, 127);
        expectedScoresSimulator.addReindeer("Dancer", 16, 11, 162);
        final ReindeerRaceSimulator actualScoresSimulator = new EfficientLeadScoringReindeerRaceSimulator();
        actualScoresSimulator.addReindeer("Comet", 14, 10, 127);
        actualScoresSimulator.addReindeer("Dancer", 16, 11, 162);
        for (int i = 0; i < 1000; i++) {
            assertEquals(expectedScoresSimulator.simulateRace(i), actualScoresSimulator.simulateRace(i), "i=" + i);
        }
//        assertEquals(expectedScoresSimulator.simulateRace(685), actualScoresSimulator.simulateRace(685));
    }

    @Test
    void test_examplesWithMultiples() {
        final ReindeerRaceSimulator expectedScoresSimulator = new LeadScoringReindeerRaceSimulator();
        expectedScoresSimulator.addReindeer("Comet", 10, 10, 20);
        expectedScoresSimulator.addReindeer("Dancer", 12, 11, 30);
        final ReindeerRaceSimulator actualScoresSimulator = new EfficientLeadScoringReindeerRaceSimulator();
        actualScoresSimulator.addReindeer("Comet", 10, 10, 20);
        actualScoresSimulator.addReindeer("Dancer", 12, 11, 30);
        for (int i = 0; i < 1000; i++) {
            assertEquals(expectedScoresSimulator.simulateRace(i), actualScoresSimulator.simulateRace(i), "i=" + i);
        }
//        assertEquals(expectedScoresSimulator.simulateRace(47), actualScoresSimulator.simulateRace(47));
    }

    @Test
    void test_partTwo() throws IOException {
        final List<String> lines = Files.readAllLines(Path.of("input.txt"), StandardCharsets.US_ASCII);
        final ReindeerRaceSimulator expectedScoresSimulator = new LeadScoringReindeerRaceSimulator();
        final ReindeerRaceSimulator actualScoresSimulator = new EfficientLeadScoringReindeerRaceSimulator();
        addReindeers(lines, expectedScoresSimulator);
        addReindeers(lines, actualScoresSimulator);
        for (int i = 0; i < 2503; i++) {
            assertEquals(expectedScoresSimulator.simulateRace(i), actualScoresSimulator.simulateRace(i), "i=" + i);
        }
//        assertEquals(expectedScoresSimulator.simulateRace(2066), actualScoresSimulator.simulateRace(2066));
    }
}
