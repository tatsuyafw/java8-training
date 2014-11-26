package chapter3.exercise17;

import java.util.function.Consumer;

public class AsynUtil {
	public static void doInParallelAsync(Runnable first, Runnable second, Consumer<Throwable> handler) {
	    new Thread(() -> {
	        try {
	          first.run();
	        } catch (Throwable e) {
	            handler.accept(e);
	        }
	    }).start();
	    new Thread(() -> {
	        try {
	            second.run();
	        } catch(Throwable e) {
	            handler.accept(e);
	        }
	    }).start();
	}
}
