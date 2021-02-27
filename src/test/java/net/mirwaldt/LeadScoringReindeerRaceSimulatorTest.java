package net.mirwaldt;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeadScoringReindeerRaceSimulatorTest {
    private static Stream<Arguments> reindeerRaceSimulator() {
        return Stream.of(Arguments.of(new LeadScoringReindeerRaceSimulator()),
                Arguments.of(new EfficientLeadScoringReindeerRaceSimulator()));
    }

    @ParameterizedTest
    @MethodSource("reindeerRaceSimulator")
    void test_example(ReindeerRaceSimulator reindeerRaceSimulator) {
        reindeerRaceSimulator.addReindeer("Comet", 14, 10, 127);
        reindeerRaceSimulator.addReindeer("Dancer", 16, 11, 162);
        assertEquals(Map.of("Comet", 0, "Dancer", 1),
                reindeerRaceSimulator.simulateRace(1));
        assertEquals(Map.of("Comet", 0, "Dancer", 2),
                reindeerRaceSimulator.simulateRace(2));
        assertEquals(Map.of("Comet", 1, "Dancer", 139),
                reindeerRaceSimulator.simulateRace(140));
        assertEquals(Map.of("Comet", 2, "Dancer", 139),
                reindeerRaceSimulator.simulateRace(141));
        assertEquals(Map.of("Comet", 34, "Dancer", 139),
                reindeerRaceSimulator.simulateRace(173));
        assertEquals(Map.of("Comet", 35, "Dancer", 139),
                reindeerRaceSimulator.simulateRace(174));
        assertEquals(Map.of("Comet", 312, "Dancer", 689),
                reindeerRaceSimulator.simulateRace(1000));
    }
}
