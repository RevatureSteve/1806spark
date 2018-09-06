package com.revature;

import org.apache.log4j.Logger;

public class Driver {
	
	final static Logger logger = Logger.getLogger(Driver.class);

	public static void main(String[] args) {
		if(logger.isInfoEnabled()) {
			logger.info("This is info: loggers are cool, right? Sugoi!");
		}
		logger.warn("This is a warning: it comes for me at dawn...");
		logger.error("This is an error: I can't fight it...I must accpet it", new IndexOutOfBoundsException());
		logger.fatal("This is fatal: It is easier to let it takes me...farewell");
		logger.info("");

	}

}
