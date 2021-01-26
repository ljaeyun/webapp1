package com.mycompany.webapp.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.webapp.dto.Ch07Board;
import com.mycompany.webapp.dto.ch08Board;

@Controller
@RequestMapping("/ch08")
public class ch08Controller {
	private static final Logger logger = LoggerFactory.getLogger(ch08Controller.class);
	

	
	@GetMapping("/content")
	public String content() {
		logger.info("실행");
		return "ch08/content";
	}
	
	@GetMapping("/method1")
	public String method1(HttpSession session) {
		session.setAttribute("name", "스프링");
		session.setAttribute("age", 28);
		session.setAttribute("job", "인공지능 개발자");
		return "ch08/el";
	}
	
	@GetMapping("/method2")
	public String method2(HttpSession session) {
		Ch07Board board = new Ch07Board();
		board.setNo(1);
		board.setTitle("너무 추워요");
		board.setContent("과제하면 더 추워요. 진짜 너무하세요.");
		board.setWriter("이건희");
		board.setDate(new Date());
		session.setAttribute("board1", board);
		return "ch08/el";
	}
	
	@GetMapping("/method3")
	public String method3(HttpSession session) {
		List<Ch07Board> list = new ArrayList<>();
		for(int i=1; i<=10; i++) {
			Ch07Board board = new Ch07Board();
			board.setNo(1);
			board.setTitle("너무 추워요" + i);
			board.setContent("과제하면 더 추워요. 진짜 너무하세요." + i+"번째 말씀드리는중..");
			board.setWriter("이건희"+ i);
			board.setDate(new Date());
			list.add(board);
		}
		session.setAttribute("boardList", list);
		return "ch08/el";
	}
	
	@PostMapping("/login")
	public String login(String uid, String upassword, HttpSession session) {
		if(uid.equals("admin") && upassword.equals("12345")) {
			session.setAttribute("loginStatus", uid);
		} 
		return "redirect:/ch08/content";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		//개별적으로 삭제하는 방법
		//session.removeAttribute("loginStatus");
		
		//세션의 모든 데이터를 삭제하는 방법
		session.invalidate();
		
		return "redirect:/ch08/content";
	}
	
	@PostMapping("/boardWrite")
	public String boarWrite(ch08Board board, HttpSession session) {
		String uid = (String) session.getAttribute("loginStatus");
		if(uid != null) { //로그인이 되어 있다면, 이라는 뜻!
			board.setWriter(uid);
			logger.info("title : " + board.getTitle());
			logger.info("content : " + board.getContent());
			logger.info("writer : " + board.getWriter());
			logger.info("게시물을 성공적으로 저장함");
		} else {
			logger.info("로그인이 되어있지 않습니다.");
		}
		return "redirect:/ch08/content";
	}
}
