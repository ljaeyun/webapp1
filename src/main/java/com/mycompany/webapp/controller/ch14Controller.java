package com.mycompany.webapp.controller;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.webapp.dto.ch14Board;
import com.mycompany.webapp.dto.ch14Employee;
import com.mycompany.webapp.service.ch14BoardService;
import com.mycompany.webapp.service.ch14EmployeeService;

@Controller("ch14Controller")
@RequestMapping("/ch14")
public class ch14Controller {
	private static final Logger logger = LoggerFactory.getLogger(ch14Controller.class);
	
	@GetMapping("/content")
	public String content() {
		return "ch14/content";
	}
	
	@Resource
	private DataSource dataSource;
	
	
	@GetMapping("/contest")
	public String contest(Model model) {
		try {
			//커넥션 풀에서 커넥션 대여
			Connection conn= dataSource.getConnection();
			model.addAttribute("result", "연결 성공");
			//성공되면 연결이 된것
			
			//대여한 커넥션 반납
			conn.close();
		} catch (SQLException e) {
			model.addAttribute("result", "연결 실패");
			e.printStackTrace();
		} finally {
			
			
		}
		return "ch14/contest";
	}
	
	@GetMapping("/jsonresponse1")
	public void jsonresponse1(HttpServletResponse response) throws Exception {
		response.setContentType("applicaton/json;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		//pw.println("{\"name\" : \"홍길동\" , \"age\" : 30}"); //http 본문에 포함되어서 전달
		//pw.println("{\"name\" : \"홍길동\" , \"age\" : 30}");
		/*pw.println("{");
		pw.println("\"name\" : \"홍길동\",");
		pw.println("\"age\" : 30, ");
		pw.println("\"car\":{\"kind\":\"그랜져\" , \"color\" : \"흰색\"},");
		pw.println("\"hobby\":[\"영화\", \"여행\"]");
		pw.println("}");
		*/
		
		JSONObject root = new JSONObject();
		root.put("name","홍길동");
		root.put("age", 34);
		JSONObject car = new JSONObject();
		car.put("kind", " 그랜저");
		car.put("color", "힁색");
		root.put("car", car);
		
		JSONArray hobby = new JSONArray();
		hobby.put("영황");
		hobby.put("영황2");
		hobby.put("영황3");
		root.put("hobby", hobby);
		
		String json = root.toString();
		pw.println(json);
		
		pw.flush();
		pw.close();
	}
	
	
	@GetMapping("/jsonresponse2")
	public void jsonresponse2(HttpServletResponse response) throws Exception {
		response.setContentType("applicaton/json;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		//pw.println("{\"name\" : \"홍길동\" , \"age\" : 30}"); //http 본문에 포함되어서 전달
		//pw.println("{\"name\" : \"홍길동\" , \"age\" : 30}");
		/*pw.println("[");
		pw.println("{\"bno\" : 1 , \"btitle\" : \"제목1\", \"bwriter\" : \"글쓴이1\"},");
		pw.println("{\"bno\" : 2 , \"btitle\" : \"제목2\", \"bwriter\" : \"글쓴이2\"},");
		pw.println("{\"bno\" : 3 , \"btitle\" : \"제목3\", \"bwriter\" : \"글쓴이3\"},");
		pw.println("]");
		*/
		JSONArray root = new JSONArray();
		for(int i = 1 ; i <= 3 ; i++) {
			JSONObject board = new JSONObject();
			board.put("bno", i);
			board.put("btitle", "제목" + i);
			board.put("bwriter",  "글쓴이"+i);
			root.put(board);
		}
		String json= root.toString();
		pw.println(json);
		
		pw.flush();
		pw.close();
	}

	
	
	@Resource
	private ch14EmployeeService  employeeService;
	
	@GetMapping("/employee")
	public void employee(int employee_id, HttpServletResponse response) throws Exception {
		ch14Employee emp = employeeService.getEmployee(employee_id);
		
		
		response.setContentType("applicaton/json; charset=UTF-8");
		PrintWriter pw = response.getWriter();
		
		JSONObject root = new JSONObject();
		
		root.put("employee_id", emp.getEmployee_id());
		root.put("first_name", emp.getFirst_name());
		root.put("last_name", emp.getLast_name());
		
		String json = root.toString();
		pw.println(json);
		
		pw.flush();
		pw.close();
	}
	
	@Resource
	private ch14BoardService boardService;
	
	@GetMapping("/boardlist")
	public String boardlist(Model model) {
		List<ch14Board> list = boardService.getBoardList();
		
		model.addAttribute("list", list);
		

		return "ch14/boardlist";
	}
	
	@GetMapping("/boardsave")
	public String boardsave() {
		/*
		for(int i =1 ; i <= 100 ; i++)
		{
			ch14Board board= new ch14Board();
			board.setBtitle("제목" + i);
			board.setBcontent("내용" + i);
			board.setBwriter("winter");
			boardService.saveBoard(board);
		}
		*/
		return "redirect:/ch14/boardlist";
	}
	
	
}
