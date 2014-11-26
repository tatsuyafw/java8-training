package chapter3.exercise02;

import java.util.concurrent.locks.ReentrantLock;

public class LockUtil {
	public static void withLock(ReentrantLock lock, Runnable action) {
		lock.lock();
		try {
			action.run();
		} finally {
			lock.unlock();
		}
	}
}
