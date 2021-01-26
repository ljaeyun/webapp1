<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>		
	
<meta charset="UTF-8">
<title>Insert title here</title>

   <%-- import 속성 --%>
   <%@ page import="java.util.*" %>
   <%@ page import="java.text.SimpleDateFormat" %>

<link rel="stylesheet" href="<%=application.getContextPath()%>/resources/css/main.css">
</head>
<body>
	<div class="wrap">
		<%-- 헤더 --%>
		<jsp:include page="/WEB-INF/views/include/header.jsp"/>
	
		
		<%-- 내용 --%>
		<div class="mainCenter">
				<%-- 공통 메뉴 --%>
				<jsp:include page="/WEB-INF/views/include/menu.jsp"/>
				
				<div class = "content">
				
				<div class = "sector">
						<div class="alert alert-primary" role="alert">
							로그인
						</div>
  							<form name="loginform" onsubmit="login()" style="width:200px">
  							
  							  <div class="form-group">
								    <label for="bwriter">아이디</label>
								    <input type="text" class="form-control" id="mid" name="mid">
								    <small id="errorMid" class="form-text text-danger"></small>
							  </div>
  							
			
							  
							  <div class="form-group">
								    <label for="mpassword">비밀번호</label>
								    <input type="password" class="form-control" id="mpassword" name="mpassword">
								    <small id="errorMpassword" class="form-text text-muted"></small>
							  </div>
							  
								  <button class="btn btn-primary">로그인</button>
								  <a class="btn btn-primary" href="boardlist">취소</a>
							</form>
							<script>
								function login() {
									//<form> 태그의 기본이동 기능을 취소
									event.preventDefault();
									//에러 초기화
									$("#errorMid").html("");
									
									
									$("#errorMpassword").html("");
									
								
									//입력값 받기
									const mid = $("#mid").val();
									var validation = true;
									if(mid === "") {
										$("#errorMid").html("필수입력이니다");
										validation = false;
									}
									
									const mpassword = $("#mpassword").val();
									if(mpassword === "") {
										$("#errorMpassword").html("필수입력힙니다");
										validation = false;
									}
									
									if(!validation)
									{
										return;
									}
									$.ajax({
										url: "login",
										method:"post",
										data : {mid, mpassword},
										success : function(data) {
											//{"result" : "success | wrongMid | wrongMpassword"}
											if(data.result === "success") {
												alert("로그인 성공");
												location.href="boardlist2";
											} else if(data.result === "wrongMid"){
												$("#errorMid").html("아이디가 존재하지 않습니다");
											} else {
												$("#errorMpassword").html("비밀번호가 존재하지 않습니다");
											}
										}
									});
									
								}
							</script>
								
				</div>
			</div>
		</div>
</body>
</html>