package chapter5.exercise08;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AllOffsetsOfAvailableZones {
    public static void main(String[] args) {
        for (Map.Entry<String, ZoneOffset> e : getAllOffsetsOfAvailableZones().entrySet()) {
            System.out.println("Zone: " + e.getKey() + "\tOffset: " + e.getValue());
        }
    }

    public static Map<String, ZoneOffset> getAllOffsetsOfAvailableZones() {
        Instant now = Instant.now();
        Stream<String> zoneStream = zoneStream();
        return zoneStream.collect(Collectors.toMap(
                Function.identity(),
                zone -> {
                    return now.atZone(ZoneId.of(zone)).getOffset();
                }));
    }

    public static Stream<String> zoneStream() {
        return ZoneId.getAvailableZoneIds().stream();
    }
}
