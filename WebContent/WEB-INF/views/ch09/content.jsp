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
						<h5>파일업로드</h5>
						<div>
							<!-- input늘릴때마다 파트가 늘어난다 -->
							<form method="post" enctype="multipart/form-data" action="photoupload">
								<input type="text" name="uid" placeholder="아이디"/><br>   <!-- 1번째 파트 -->
								<input type="text" name="uname" placeholder="이름"/><br>   <!-- 2번째 파트 -->
								<input type="password" name="upassword" placeholder="비밀번호" /><br>
								<input type="file" name="uphoto"/><br> <!-- multipel 다중 파일  배열로 넘긴다 -->
								<input class ="btn btn-info btn-sm" type="submit" value="회원가입"/>
							</form>
						</div>
					
				
					</div>
					
					<div class = "sector">
						<h5>파일 리스트</h5>
						<div>
							<script>
								$(function() {
									$.ajax({
										url:"photolist",
										method:"get",
										success: function(data) {
											$("#photoList").html(data);
										}
									});
								});
							</script>
							
							<div id="photoList"></div>
						</div>
					
				
					</div>
				</div>
		</div>
	</div>
</body>
</html>