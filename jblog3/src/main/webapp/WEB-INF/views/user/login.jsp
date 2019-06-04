<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<Link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/assets/css/jblog.css">
<script type="text/javascript"
	src="${pageContext.servletContext.contextPath}/assets/js/jquery/jquery-1.9.0.js"></script>
</head>
<body>
	<div class="center-content">
		<!-- headerMain -->
		<c:import url='/WEB-INF/views/includes/headerMain.jsp' />

		<form class="login-form"
			action="${pageContext.servletContext.contextPath}/user/auth"
			method="post">
			<label>아이디</label> <input type="text" name="userid"> <label>패스워드</label>
			<input type="password" name="userpassword"> <input
				type="submit" value="로그인">
		</form>
	</div>
</body>
</html>
