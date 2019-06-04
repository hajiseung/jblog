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
</head>
<body>
	<div class="center-content">
		<!-- headerMain -->
		<c:import url='/WEB-INF/views/includes/headerMain.jsp' />

		<!-- <form class="search-form">
			<fieldset>
				<input type="text" name="keyword" />
				<input type="submit" value="검색" />
			</fieldset>
			<fieldset>
				<input type="radio" name="which" value="blog-title"> <label>블로그 제목</label>
				<input type="radio" name="which" value="tag"> <label>태그</label>
				<input type="radio" name="which" value="blog-user"> <label>블로거</label>
			</fieldset>
		</form> -->
		<p class="welcome-message">
			<span>없는 사용자 입니다.</span> <br>
			<br> <a
				href="${pageContext.servletContext.contextPath}/user/loginform">로그인
				하기</a>
		</p>
	</div>
</body>
</html>