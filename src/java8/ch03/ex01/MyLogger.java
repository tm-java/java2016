package java8.ch03.ex01;

import java.util.function.BooleanSupplier;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyLogger {
	private final Logger logger;
	
	public MyLogger(Logger logger, Level level) {
		this.logger = logger;
		this.logger.setLevel(level);
	}
	public void logIf(Level level, BooleanSupplier bs, Supplier<String> message) {
		if (logger.isLoggable(level)) {
			if (bs.getAsBoolean()) {
				logger.log(level, message.get());
			}
		}
	}

}
