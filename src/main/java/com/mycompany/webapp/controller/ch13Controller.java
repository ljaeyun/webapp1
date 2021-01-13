package com.mycompany.webapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/ch13")
public class ch13Controller {
	private static final Logger logger = LoggerFactory.getLogger(ch13Controller.class);
	
	
	@GetMapping("/content")
	public String content() {
		logger.info("실행");
		return "ch13/content";
	}
	
	@RequestMapping(value="/joinReal", method=RequestMethod.GET)
	public String joinFormAsync1() {
		logger.info("이거시 깃헙의 위엄인가");
		return "ch13/joinReal";
	}	
}
