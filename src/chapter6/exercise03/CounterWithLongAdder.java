package chapter6.exercise03;

import java.util.concurrent.atomic.LongAdder;

public class CounterWithLongAdder implements Counter {
    private LongAdder counter;

    public CounterWithLongAdder() {
        this.counter = new LongAdder();
    }

    @Override
    public long countUp() {
        return counter.longValue();
    }
}
