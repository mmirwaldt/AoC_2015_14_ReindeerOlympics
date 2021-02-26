package net.mirwaldt;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReindeerRaceSimulatorTest {
    private static Stream<Arguments> reindeerRaceSimulator() {
        return Stream.of(Arguments.of(new DefaultReindeerRaceSimulator()));
    }

    @ParameterizedTest
    @MethodSource("reindeerRaceSimulator")
    void test_example(ReindeerRaceSimulator reindeerRaceSimulator) {
        reindeerRaceSimulator.addReindeer("Comet", 14, 10, 127);
        reindeerRaceSimulator.addReindeer("Dancer", 16, 11, 162);
        assertEquals(Map.of("Comet", 1120, "Dancer", 1056),
                reindeerRaceSimulator.simulateRace(1000));
    }
}
