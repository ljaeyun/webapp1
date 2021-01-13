package com.mycompany;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Example {

	private static final Logger logger = LoggerFactory.getLogger(Example.class);
	public static void main(String[] args) {
			
			logger.debug("실행1");
			logger.info("실행2");
			logger.warn("실행3");
			logger.error("실행4");
			
			//로그 레벨이 있다 아래로 갈수록 높은레벨

	}

}

