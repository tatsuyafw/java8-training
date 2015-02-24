package utils;

import java.time.Duration;
import java.time.Instant;

public class BenchMark {
    public static Duration benchmark(Runnable measuredJob) {
        Instant start = Instant.now();
        measuredJob.run();
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        return timeElapsed;
    }
}
