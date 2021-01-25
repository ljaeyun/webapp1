package com.mycompany.webapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//service, repository 등을 붙이면 일단은 관리객체가 된다.
@Service
public class Ch13Service2 {
	private static final Logger logger = LoggerFactory.getLogger(Ch13Service2.class);
	
	public void method() {
		logger.info("실행");
	}
}
