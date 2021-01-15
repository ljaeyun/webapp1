package com.mycompany.webapp.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.webapp.dto.ch08Board;

@Controller
@RequestMapping("/ch08")
public class ch08Controller {
	private static final Logger logger = LoggerFactory.getLogger(ch08Controller.class);
	
	
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
	
	@PostMapping("/join")
	public String join() {
		logger.info("실행");
		return "ch13/content";
	}
	
	@PostMapping("/boardWrite")
	public String boardWrite(ch08Board board, HttpSession session)
	{
		String uid = (String)session.getAttribute("loginStatus");
		if(uid == null) {  //로그인이 되어있다면
			board.setWriter(uid);
			
			logger.info("title:" + board.getTitle());
			logger.info("content:" + board.getContent());
			logger.info("writer:" + board.getWriter());
			logger.info("게시물을 성공적으로 저장함");
		} else {
			logger.info("로그인이 되어 있지 않습니다");
		}
		return "redirect:/ch13/content";
	}
}
