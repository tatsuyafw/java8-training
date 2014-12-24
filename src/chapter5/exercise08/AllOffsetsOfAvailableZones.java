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
        for (Map.Entry<ZoneId, ZoneOffset> e : getAllOffsetsOfAvailableZones().entrySet()) {
            System.out.println("Zone: " + e.getKey() + "\tOffset: " + e.getValue());
        }
    }

    public static Map<ZoneId, ZoneOffset> getAllOffsetsOfAvailableZones() {
        Instant now = Instant.now();
        Stream<ZoneId> zoneStream = zoneIdStream();
        return zoneStream.collect(Collectors.toMap(
                Function.identity(),
                zoneId -> {
                    return now.atZone(zoneId).getOffset();
                }));
    }

    public static Stream<ZoneId> zoneIdStream() {
        return ZoneId.getAvailableZoneIds().stream().map(id -> ZoneId.of(id));
    }
}
