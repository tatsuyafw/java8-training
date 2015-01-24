package chapter6.exercise03;

import java.util.concurrent.atomic.AtomicLong;

public class CounterWithAtomicLong implements Counter {
    private AtomicLong counter;

    public CounterWithAtomicLong() {
        this.counter = new AtomicLong();
    }

    @Override
    public long countUp() {
        return this.counter.incrementAndGet();
    }

}
