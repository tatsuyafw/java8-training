package chapter5.exercise09;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex09 {
    private static final int SECOND_OF_DAY = 3600;

    public static void main(String[] args) {
        for (Map.Entry<ZoneId, ZoneOffset> e : getAllOffsetsHavingInfoLessThanOneHour().entrySet()) {
            System.out.println("Zone: " + e.getKey() + "\tOffset: " + e.getValue());
        }
    }

    public static Map<ZoneId, ZoneOffset> getAllOffsetsHavingInfoLessThanOneHour() {
        Instant now = Instant.now();
        Stream<ZoneId> zoneIdStream = zoneIdStream();
        Predicate<ZoneId> hasInfoLessThanOneHour = zoneId -> {
            ZoneOffset offset = now.atZone(zoneId).getOffset();
            if ( (offset.getTotalSeconds() % SECOND_OF_DAY) != 0 ) {
                return true;
            } else {
                return false;
            }
        };
        return zoneIdStream.filter(hasInfoLessThanOneHour).collect(
                Collectors.toMap(
                        Function.identity(),
                        zone -> {
                            return now.atZone(zone).getOffset();
                        }
                ));
    }

    public static Stream<ZoneId> zoneIdStream() {
        return ZoneId.getAvailableZoneIds().stream().map(id -> ZoneId.of(id));
    }
}
