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

	public static void main(String[] args) {
	    ReentrantLock lock = new ReentrantLock();
	    withLock(lock, () -> {
	        System.out.println("lock status: " + lock.isLocked());
	    });

	    System.out.println("lock status: " + lock.isLocked());
	}
}
