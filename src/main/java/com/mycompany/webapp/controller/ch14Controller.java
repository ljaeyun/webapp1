package com.mycompany.webapp.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.mycompany.webapp.dto.Ch14Pager;
import com.mycompany.webapp.dto.ch14Board;
import com.mycompany.webapp.dto.ch14Employee;
import com.mycompany.webapp.dto.ch14Member;
import com.mycompany.webapp.service.ch14BoardService;
import com.mycompany.webapp.service.ch14EmployeeService;
import com.mycompany.webapp.service.ch14MemberService;

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
	//의존성 주입
	
	@GetMapping("/boardlist")
	public String boardlist(Model model) {
		List<ch14Board> list = boardService.getBoardList();
		model.addAttribute("list", list);
		return "ch14/boardlist";
	}
	
	@GetMapping("/boardlist2")
	public String boardlist2(@RequestParam(defaultValue="1")int pageNo, Model model) {
		int totalRows = boardService.getTotalRows();
		Ch14Pager pager = new Ch14Pager(10,5,totalRows, pageNo);
		List<ch14Board> list = boardService.getBoardList(pager);
		model.addAttribute("list", list);
		model.addAttribute("pager", pager);
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
	
	@GetMapping("/boardwrite")
	public String boardwriteForm() {
		return "ch14/boardwrite";
	}
	
	@PostMapping("/boardwrite")
	public String boardwrite(ch14Board board, HttpSession session) throws Exception
	{
		String mid = (String)session.getAttribute("sessionMid");
		board.setBwriter(mid);
		
		MultipartFile mf = board.getBattach();
		if(!mf.isEmpty())
		{
			board.setBattachoriginalfilename(mf.getOriginalFilename());
			String saveName = new Date().getTime() + "-" + mf.getOriginalFilename();
			board.setBattachsavefilename(saveName);
			board.setBattachcontenttype(mf.getContentType());
			//파일 저장
			File saveFile = new File("D:/Myworkspace/UPLOAD/boards/" + saveName);
			mf.transferTo(saveFile);
		}

		boardService.saveBoard(board);
		return "redirect:/ch14/boardlist2";
	}
	
	@GetMapping("/join")
	public String joinForm() {
		return "ch14/join";
	}
	
	@Resource
	private ch14MemberService memberService;
	
	@PostMapping("/join")
	public String join(ch14Member member) throws Exception {
		//파일 정보 얻기
		MultipartFile mf = member.getMphoto();
		if(!mf.isEmpty())
		{
			member.setMphotooname(mf.getOriginalFilename());
			String saveName = new Date().getTime() + "-" + mf.getOriginalFilename();
			member.setMphotosname(saveName);
			member.setMphototype(mf.getContentType());
			//파일 저장
			File saveFile = new File("D:/Myworkspace/UPLOAD/" + saveName);
			mf.transferTo(saveFile);
		}
		//DB에 저장
		
		memberService.join(member);
		return "redirect:/ch14/boardlist2";
	}
	
	
	@GetMapping("/login")
	public String loginForm() {
		return "ch14/login";
	}
	
	@PostMapping("/login")
	public void login(ch14Member member, HttpServletResponse response, HttpSession session) throws Exception {
		//success, wrongMid, wrongPassword
		String result = memberService.login(member);
		if(result.equals("success")) {
			session.setAttribute("sessionMid", member.getMid());
		}
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter pw = response.getWriter();
		
		//{"result" : success}
		JSONObject root = new JSONObject();
		root.put("result", result);
		//root.put("result", "success");
		pw.println(root.toString());
		
		pw.flush();
		pw.close();
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/ch14/boardlist2";
	}
	
	@GetMapping("/mphoto")
	public void mphoto(String mid, HttpSession session, HttpServletResponse response) throws Exception {
		
		if(mid == null) {
			mid = (String)session.getAttribute("sessionMid");
		}
		ch14Member member = memberService.getMember(mid);
		
		String filePath = null;
		
		if(member.getMphotosname() != null) {
			String mphotosname = member.getMphotosname();
			 filePath = "D:/Myworkspace/UPLOAD/" + mphotosname;
			
			
			response.setContentType(member.getMphototype());
		
			String mphotooname = member.getMphotooname();
			mphotooname = new String(mphotooname.getBytes("UTF-8"), "ISO-8859-1");
			response.setHeader("Content-Disposition", "attachment; filename=\"" + mphotooname +"\"");
		} else {
			 filePath = "D:/Myworkspace/UPLOAD/members/defaultphoto.png";

			response.setContentType("image/png");
		}
		
		
		OutputStream os = response.getOutputStream();
		InputStream is = new FileInputStream(filePath);
		
		FileCopyUtils.copy(is, os);
		os.flush();
		os.close();
		is.close();
	}
	
	@GetMapping("/boardread")
	public String boardread(int bno, Model model) {
		boardService.addHitcount(bno);
		ch14Board board = boardService.getBoard(bno);
		model.addAttribute("board", board);
		return "ch14/boardread";
	}
	
	@GetMapping("/boardupdate")
	public String boardupdateFrom(int bno, Model model) {
		ch14Board board = boardService.getBoard(bno);
		model.addAttribute("board", board);
		return "ch14/boardupdate";
	}
	
	@PostMapping("/boardupdate")
	public String boardupdate(ch14Board board) {
		boardService.updateBoard(board);
		return "redirect:/ch14/boardlist2";
	}
	
	@GetMapping("/boarddelete")
	public String boarddelete(int bno)
	{
		boardService.deleteBoard(bno);
		return "redirect:/ch14/boardlist2";
	}
	
	@GetMapping("/battach")
	public void batttach(int bno, HttpServletResponse response) throws Exception {
		
		ch14Board board = boardService.getBoard(bno);
		
		
		String battachsavename = board.getBattachsavefilename();
		String filePath = "D:/Myworkspace/UPLOAD/boards/" + battachsavename;
		
		
		response.setContentType(board.getBattachcontenttype());
	
		String originalname = board.getBattachoriginalfilename();
		originalname = new String(originalname.getBytes("UTF-8"), "ISO-8859-1");
		response.setHeader("Content-Disposition", "attachment; filename=\"" + originalname +"\"");
		
		
		OutputStream os = response.getOutputStream();
		InputStream is = new FileInputStream(filePath);
		
		FileCopyUtils.copy(is, os);
		os.flush();
		os.close();
		is.close();
	}
}
