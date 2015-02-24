package chapter6.exercise02;

import java.util.concurrent.atomic.AtomicLong;

public class IDCreatorWithAtomicLong implements IDCreator {
    private AtomicLong counter;

    public IDCreatorWithAtomicLong() {
        this.counter = new AtomicLong();
    }

    @Override
    public long getId() {
        return counter.addAndGet(1);
    }
}
