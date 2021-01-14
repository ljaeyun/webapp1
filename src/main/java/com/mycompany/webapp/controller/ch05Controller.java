package com.mycompany.webapp.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ch05")
public class ch05Controller {
	private static final Logger logger = LoggerFactory.getLogger(ch05Controller.class);
	
	
	@GetMapping("/content")
	public String content() {
		logger.info("실행");
		return "ch05/content";
	}
	
	@GetMapping("/method1")
	//User-Agent의 값을 저장한ㄷ
	public String method1(@RequestHeader("User-Agent")String userAgent) {
		logger.info("실행");
		//logger.info(userAgent);
		if(userAgent.contains("Edg"))
		{
			logger.info("브라우저의 종류 : 엣지");
		} else if(userAgent.contains("Chrome")) {
			logger.info("브라우저의 종류 : 크롬");
		} else if(userAgent.contains("Trident/7.0")){
			logger.info("브라우저의 종류 : 인터넷익스플로어 11");
		} else if(userAgent.contains("Trident/7.0")) {
			logger.info("브라우저의 종류 : 인터넷익스플로어 10 이하");
		}
		
		return "ch05/content";
	}
	
	@GetMapping("/method2")
	// was가 제공
	public String method2(HttpServletRequest request) {
		logger.info("실행");
		
		String userAgent = request.getHeader("User-Agent");
		//logger.info(userAgent);
		if(userAgent.contains("Edg"))
		{
			logger.info("브라우저의 종류 : 엣지");
		} else if(userAgent.contains("Chrome")) {
			logger.info("브라우저의 종류 : 크롬");
		} else if(userAgent.contains("Trident/7.0")){
			logger.info("브라우저의 종류 : 인터넷익스플로어 11");
		} else if(userAgent.contains("Trident/7.0")) {
			logger.info("브라우저의 종류 : 인터넷익스플로어 10 이하");
		}
		
		return "ch05/content";
	}
	
	
	@GetMapping("/method3")
	// was가 제공
	public String method3(HttpServletRequest request, HttpServletResponse response) {
		//쿠키 생성
		Cookie cookie1 = new Cookie("memberId", "white");  
		Cookie cookie2 = new Cookie("loginStatus", "ok");
		
		//쿠키를 응답 헤더에 추가해서 클라이언트로 보내기
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		
		//응답 본문을 생성하는 뷰 리턴
		return "ch05/content";
	}
	
	@GetMapping("/method4")
	// was가 제공
	public String method4(HttpServletRequest request, HttpServletResponse response) {
		//브라우저가 요청헤더에 보낸쿠키 값을 읽기
		Cookie[] cookieArr = request.getCookies();
		
		 for(Cookie cookie : cookieArr) {
			 String name = cookie.getName();
			 String value = cookie.getValue();
			 logger.info(name +":" + value);
			 
		 }
		//응답 본문을 생성하는 뷰 리턴
		return "ch05/content";
	}
	
	@GetMapping("/method5")
	// was가 제공
	public String method5(@CookieValue("memberId") String memberId,@CookieValue("loginStatus") String loginStatus) {
		
		
		
		logger.info("memberId : " + memberId);
		logger.info("loginStatus : " + loginStatus);
			 
		
		
		return "ch05/content";
	}
	
}
