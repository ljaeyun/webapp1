<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
						<h5>요청 매핑</h5>
						<div>
							GET 방식 :<a class="btn btn-info btn-sm" href="getMethod">request1 요청</a> <!-- get 방식 -->
							
							<form method="post" action="postMethod" sytle="inline=block; margin-top : 4px;">
							POST 방식 : <button class="btn btn-danger btn-sm" >request1</button>  <!-- post 방식 -->
							</form>
						</div>
					</div>
					
					
					
					<div class = "sector">
						<h5>요청방식 별 회원 가입 처리</h5>
						<div>
							GET 방식 :<a class="btn btn-info btn-sm" href="join">회원가입</a> <!-- get 방식 -->
						</div>
					</div>
					
					<div class = "sector">
						<h5>비동기 처리</h5>
						<div>
							GET 방식 :<a class="btn btn-info btn-sm" href="javascript:fun1()">회원가입</a> <!-- get 방식 -->
							<script>
								function fun1() {
									
									//비동기 요청
									$.ajax({
										url:"joinAsync",
										method: "get",
										
										//비동기 요청에 따른 응답 코드 실행
										success: function(data) {
											//joinFrom을 실행 하겠다
											$("#joinForm").html(data);
											
										}
									});
								};
							</script>
							<div id="joinForm"></div>
						</div>
					</div>
					
				</div>
				
				
		</div>
		
	</div>
</body>
</html>