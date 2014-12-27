package chapter5.exercise11;

import static chapter5.exercise11.Flight.flightTime;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Main {
    public static void main(String[] args) {
        ZoneId frankfurt = ZoneId.of("CET");
        ZoneId losangeles = ZoneId.of("America/Los_Angeles");

        LocalDateTime depatureTime = LocalDateTime.of(2014, 12, 10, 14, 5);
        ZonedDateTime depatureTimeInFrankfurt = ZonedDateTime.of(depatureTime, frankfurt);
        LocalDateTime arrivalTime = LocalDateTime.of(2014, 12, 10, 16, 40);
        ZonedDateTime arrivalTimeInLosAngeles = ZonedDateTime.of(arrivalTime, losangeles);
        Duration flightTime = flightTime(depatureTimeInFrankfurt, arrivalTimeInLosAngeles);

        System.out.println("The flight from Frankfurt to Los Angeles takes "
                + flightTime.toHours() + " hours and " + (flightTime.toMinutes() % 60) + " minutes.");
    }

}
