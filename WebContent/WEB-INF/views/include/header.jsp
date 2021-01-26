<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="mainHeader">
	<h3>Spring Framework</h3>
	
	<div class="LoginBox">
		<%-- <img src="<%=application.getContextPath()%>/resources/img/fox1.jpg" width="50px" class="rounded-circle"/>
		<img src="<%=application.getContextPath()%>/resources/img/baby.png" width="50px" class="rounded-circle"/> --%>
		
		
		<c:if test="${sessionMid == null}">
			<a class="btn btn-info btn-sm" href="<%=application.getContextPath()%>/ch14/join">회원가입</a>
			<a class="btn btn-info btn-sm" href="<%=application.getContextPath()%>/ch14/login">로그인</a>
		</c:if>
		<c:if test="${sessionMid != null}">
			<img class="rounded-circle" src="<%=application.getContextPath()%>/ch14/mphoto" width="50px"/>
			<a class="btn btn-warning btn-sm" href="<%=application.getContextPath()%>/ch14/logout">로그아웃</a>
		</c:if>
	</div>
	
</div>