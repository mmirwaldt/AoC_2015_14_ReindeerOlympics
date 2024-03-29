package net.mirwaldt.aoc.year2015.day14;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DistanceReindeerRaceSimulatorTest {
    private static Stream<Arguments> reindeerRaceSimulator() {
        return Stream.of(Arguments.of(new DistanceReindeerRaceSimulator()));
    }

    @ParameterizedTest
    @MethodSource("reindeerRaceSimulator")
    void test_simulateRace(ReindeerRaceSimulator reindeerRaceSimulator) {
        reindeerRaceSimulator.addReindeer("Comet", 14, 10, 127);
        reindeerRaceSimulator.addReindeer("Dancer", 16, 11, 162);
        assertEquals(Map.of("Comet", 140, "Dancer", 160),
                reindeerRaceSimulator.simulateRace(10));
        assertEquals(Map.of("Comet", 140, "Dancer", 176),
                reindeerRaceSimulator.simulateRace(11));
        assertEquals(Map.of("Comet", 140, "Dancer", 176),
                reindeerRaceSimulator.simulateRace(12));
        assertEquals(Map.of("Comet", 154, "Dancer", 176),
                reindeerRaceSimulator.simulateRace(138));
        assertEquals(Map.of("Comet", 280, "Dancer", 176),
                reindeerRaceSimulator.simulateRace(148));
        assertEquals(Map.of("Comet", 280, "Dancer", 192),
                reindeerRaceSimulator.simulateRace(174));
        assertEquals(Map.of("Comet", 280, "Dancer", 352),
                reindeerRaceSimulator.simulateRace(185));
        assertEquals(Map.of("Comet", 1120, "Dancer", 1056),
                reindeerRaceSimulator.simulateRace(1000));
    }
}
