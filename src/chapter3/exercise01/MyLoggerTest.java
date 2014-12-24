package chapter3.exercise01;

import static org.junit.Assert.assertEquals;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Test;

public class MyLoggerTest {
    private MyLogger logger;

    @Before
    public void setup() {
        logger = new MyLogger(Logger.getLogger(Logger.GLOBAL_LOGGER_NAME));
    }

    @Test
    public void testNotEvaluateCondition() {
        logger.setLevel(Level.INFO);
        CounterHelper counter = new CounterHelper();
        logger.logIf(Level.CONFIG, () -> {
            counter.countup();
            return true;
        }, () -> "CONFIG");
        assertEquals(0, counter.getCounterValue());
    }

    @Test
    public void testEvaluateCondition() {
        logger.setLevel(Level.INFO);
        CounterHelper counter = new CounterHelper();
        logger.logIf(Level.SEVERE, () -> {
            counter.countup();
            return true;
        }, () -> "SEVERE");
        assertEquals(1, counter.getCounterValue());
    }

    private class CounterHelper {
        private int counter;

        public CounterHelper() {
            this.counter = 0;
        }

        public void countup() {
            this.counter++;
        }

        public int getCounterValue() {
            return this.counter;
        }

    }

}
