package chapter5.exercise11;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Flight {
    public static Duration flightTime(ZonedDateTime depatureTime, ZonedDateTime arrivalTime) {
        ZoneId arrivalZone = arrivalTime.getZone();
        ZonedDateTime depatureTimeInArrivalZone = depatureTime.withZoneSameInstant(arrivalZone);
        return Duration.between(depatureTimeInArrivalZone, arrivalTime);
    }
}
