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
						<h5>GET 방식 데이터 전달</h5>
						<div>
							<!-- 문자열로 서버에 전달 -->
							<a class="btn btn-info btn-sm" href="method1?param1=문자열&param2=5&param3=3.14&param4=true&param5=2021-01-14"">데이터 전달</a>
							    
						</div>
					</div>
					
					<div class = "sector">
						<h5>POST 방식 데이터 전달</h5>
						<div>
							<form method="post" action="method2">
								<input type="text" name="param1" value="문자열"/></br>
								<input type="number" name="param2" value="5"/></br>
								<input type="number" name="param3" value="3.14"/></br>
								<input type="checkbox" name="param4" checked/></br>
								<input type="date" name="param5" value="2011-12-25"/></br>
								<button class="btn btn-info btn-sm">데이터 전달</button>
							</form>
	    
						</div>
					</div>
					
					
					<div class = "sector">
						<h5>디폴트 값</h5>
						<div>
							<form method="post" action="method3">
								<input type="text" name="param1" value="snowman"/></br>
								<button class="btn btn-info btn-sm">데이터 전달</button>
							</form>
						
						</div>
					</div>
					
					</div>
					
				</div>

		</div>
</body>
</html>