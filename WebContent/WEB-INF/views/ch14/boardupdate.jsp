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
							게시물 보기
						</div>
  							<form name="boardupdateform" action="boardupdate" method="post">
  							
  							  <input type="hidden" name="bno" value="${board.bno}"/>
							  <div class="form-group">
								    <label for="btitle">제목</label>
								    <input type="text" value = "${board.btitle}" class="form-control" id="btitle" name="btitle">
							  </div>
							  
							  <!-- <div class="form-group">
								    <label for="bwriter">첨부 파일</label>
								    <input type="text" class="form-control" id="bwrite" name="bwrite">
							  </div> -->
							  
							  <div class="form-group">
								    <label for="bcontent">내용</label>
								    <textarea class="form-control" id="bcontent" name="bcontent" rows="5" cols="50">${board.bcontent}</textarea>
							  </div>
							  
							  <a class="btn btn-primary" href="boardlist2">목록</a>
							  <button>수정</button>
							  
		
							</form>
								
				</div>
			</div>
		</div>
		</div>
</body>
</html>