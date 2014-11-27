package chapter3.exercise01;

import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyLogger {
	private Logger logger;

	public MyLogger(Logger logger) {
		this.logger = logger;
	}

	public void logIf(Level level, Supplier<Boolean> condition, Supplier<String> message) {
		if ( logger.isLoggable(level) ) {
			if ( condition.get() ) {
				logger.log(level, message.get());
			}
		}
	}

	public void setLevel(Level newLevel) {
		this.logger.setLevel(newLevel);
	}

	public Level getLevel() {
		return this.logger.getLevel();
	}

	public static void main(String[] args) {
	    MyLogger myLogger = new MyLogger(Logger.getLogger(Logger.GLOBAL_LOGGER_NAME));
	    myLogger.setLevel(Level.INFO);

	    myLogger.logIf(Level.CONFIG, () -> {
	        System.out.println("evaluation: CONFIG");
	        return true;
	    },
	    () -> "CONFIG");

	    myLogger.logIf(Level.SEVERE, () -> {
            System.out.println("evaluation: SEVERE");
            return true;
        },
        () -> "SEVERE");



	}
}
