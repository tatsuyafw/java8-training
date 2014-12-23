package chapter5.exercise07;

import java.time.LocalDateTime;

/*
 * Note: This TimeInterval class is supported to use in a same time zone.
 */
public class TimeInterval {
    private LocalDateTime start;
    private LocalDateTime end;

    public TimeInterval(LocalDateTime start, LocalDateTime end) {
        if (start.isAfter(end)) {
            throw new IllegalArgumentException("start must be before end");
        }
        this.start = start;
        this.end = end;
    }

    public boolean isOverlapped(TimeInterval other) {
        if ( this.start.isBefore(other.start)
                && this.end.isAfter(other.start)) {
            return true;
        } else if ( this.start.isBefore(other.end)
                && this.end.isAfter(other.end)) {
            return true;
        } else if ( this.start.isAfter(other.start)
                && this.start.isBefore(other.end)) {
            return true;
        } else if ( this.start.equals(other.start) ) {
            return true;
        } else if ( this.end.equals(other.end) ) {
            return true;
        }
        return false;
    }
}
