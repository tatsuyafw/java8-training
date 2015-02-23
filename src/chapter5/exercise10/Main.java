package chapter5.exercise10;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class Main {
    public static void main(String[] args) {
        ZoneId losangeles = ZoneId.of("America/Los_Angeles");
        ZoneId frankfurt = ZoneId.of("CET");
        Flight losangelesToFrankfurt = new Flight(losangeles, frankfurt);

        LocalDateTime depatureTime = LocalDateTime.of(2014, 12, 10, 3, 5);
        Duration flightTime = Duration.ofHours(10).plusMinutes(50);
        System.out.println(losangelesToFrankfurt.arrivalTime(depatureTime, flightTime));
    }
}
