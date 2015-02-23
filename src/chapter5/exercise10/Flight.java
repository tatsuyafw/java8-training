package chapter5.exercise10;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Flight {
    private ZoneId depature;
    private ZoneId arrival;

    public Flight(ZoneId depature, ZoneId arrival) {
        this.depature = depature;
        this.arrival = arrival;
    }

    public ZonedDateTime arrivalTime(LocalDateTime depatureTime, Duration flightTime) {
        ZonedDateTime depatureTimeInArrivalZone = depatureTime.atZone(depature).withZoneSameInstant(arrival);
        return depatureTimeInArrivalZone.plus(flightTime);
    }
}
