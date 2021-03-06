package com.mycompany.webapp.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.mycompany.webapp.dto.ch09User;

@Controller
@RequestMapping("/ch09")
public class ch09Controller {
	private static final Logger logger = LoggerFactory.getLogger(ch09Controller.class);
	
	
	@GetMapping("/content")
	public String content() {
		logger.info("실행");
		return "ch09/content";
	}
	
	//parameter(jsp에서 명시한 변수) 와 동일한 이름을 가지도록 한다
	@PostMapping("/photoupload")
	public String photoUpload(ch09User user) {
		
		//문자파트 정보얻기
		String uid= user.getUid();
		String uname = user.getUname();
		String upassword = user.getUpassword();
		logger.info("uid : " + uid);
		logger.info("uname : " + uname);
		logger.info("upassword : " + upassword);
		
		//파일파트 정보얻기
		MultipartFile uphoto = user.getUphoto();
		if(!uphoto.isEmpty()) {
			
		
			String originalFileName = uphoto.getOriginalFilename();
			String contentType = uphoto.getContentType();
			long size = uphoto.getSize();
			
			logger.info("originalfilename : " + originalFileName);
			logger.info("contentType : " + contentType);
			logger.info("size : " + size);
			
			//파일 경로
			String saveDirPath = "C:\\Users\\COM\\Desktop\\NEW\\";
			
			String fileName = new Date().getTime() + "-" + originalFileName;
			String filepath = saveDirPath + fileName;
			
			
			File file = new File(filepath);
			try {
				uphoto.transferTo(file);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return "redirect:/ch09/content";
	}

	
	@GetMapping("/photolist")
	public String photolist(Model model) {
		String saveDirPath = "C:\\Users\\COM\\Desktop\\NEW\\";
		File dir = new File(saveDirPath);
		String[] fileNames = dir.list();   // 모든 파일의 이름을 배열로 return
		model.addAttribute("fileNames",fileNames);
		return "ch09/photolist";
	}
	
	//void 일 경우 응답이 올때 까지 대기 한다
	@GetMapping("/photodownload")
	public void photoDownload(String photo, HttpServletResponse response)
	{
		String saveDirPath = "C:\\Users\\COM\\Desktop\\NEW\\";
		String filePath = saveDirPath + photo;
		
		//응답 해더에 응답 본문 데이터의 종류를 추가
		response.setContentType("image/png");
		
		//응답 본문 데이터를 파일로 다운로드 할 수 있도록 응답 헤더에 추가 
		
		try
		{
			// HTTP 규약에 따라 헤더에는 한글을 넣지 못함
			photo= new String(photo.getBytes("UTF-8"), "ISO-8859-1");
		} 
		catch (Exception e1) 
		{
		
			e1.printStackTrace();
		}  
		response.setHeader("Content-Dispostiton", "attachment; filename==\"" +photo+ "\"");
		
		try {
			OutputStream os = response.getOutputStream();
			InputStream is = new FileInputStream(filePath);
			
			/*byte[] data = new byte[1024];
			while(true) {
				int readByteNum = is.read(data);
				if(readByteNum == -1) break;
				os.write(data, 0, readByteNum);
			}
			*/
			
			FileCopyUtils.copy(is, os);
			
			os.flush();
			os.close();
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/*
		 * response.setContentType("text/html; charset=UTF=8"); try { PrintWriter pw =
		 * response.getWriter(); pw.println("<html>"); pw.println("	<body>");
		 * pw.println("		photoDownload의 응답"); pw.println("	</body>");
		 * pw.println("</html>"); pw.flush(); pw.close(); } catch (IOException e) { //
		 * TODO Auto-generated catch block e.printStackTrace(); }
		 */
	}
	
}

