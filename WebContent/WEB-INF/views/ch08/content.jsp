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
						<h5>Bee Dong기 처리</h5>
						<div>
							GET 방식 :<a class="btn btn-info btn-sm" href="javascript:fun1()">해원가입</a> <!-- get 방식 -->
							<script>
								function fun1() {
									
									$.ajax({
										url:"joinReal",
										method:"get",
										success: function(data) {
											$("#joinForm").html(data);
										}
									});
								};
							</script>
							<div id="joinForm"></div>
						
						</div>
					</div>
					
					
					<div class="sector">
					
						<form method="post" action="boardWrite">
							<input type="text" name="title" placeholder="제목"/><br>
							<textarea rows="100" cols="5" name="content" placeholder="내용"></textarea><br>
							<button class="btn btn-info btn-sm">등록</button>
						</form>
					</div>
					
				</div>
				
				
		</div>
		
	</div>
</body>
</html>