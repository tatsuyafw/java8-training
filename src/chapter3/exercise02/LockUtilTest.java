package chapter3.exercise02;

import static chapter3.exercise02.LockUtil.withLock;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.locks.ReentrantLock;

import org.junit.Test;

public class LockUtilTest {

    @Test
    public void testLockedWhileProcessing() {
        ReentrantLock lock = new ReentrantLock();
        withLock(lock, () -> {
            assertTrue(lock.isLocked());
        });
    }

    @Test
    public void testUnlockedWhenNormalTermination() {
        ReentrantLock lock = new ReentrantLock();
        withLock(lock, () -> {});
        assertFalse(lock.isLocked());
    }

    @Test(expected = RuntimeException.class)
    public void testUnlockedWhenAbnormalTermination() {
        ReentrantLock lock = new ReentrantLock();
        try {
            withLock(lock, () -> {
                throw new RuntimeException();
            });
        } finally {
            assertFalse(lock.isLocked());
        }
    }
}
