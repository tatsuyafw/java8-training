package chapter6.exercise02;

import java.util.concurrent.atomic.LongAdder;

public class IDCreatorWithLongAdder implements IDCreator {
    private LongAdder counter;

    public IDCreatorWithLongAdder() {
        this.counter = new LongAdder();
    }

    @Override
    public long getId() {
        this.counter.increment();
        return this.counter.longValue();
    }
}
