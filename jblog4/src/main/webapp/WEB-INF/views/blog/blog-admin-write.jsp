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
	href="${pageContext.request.contextPath}/assets/css/jblog.css">
</head>
<body>
	<div id="container">
		<!-- headerBlog -->
		<c:import url='/WEB-INF/views/includes/headerBlog.jsp' />

		<div id="wrapper">
			<div id="content" class="full-screen">
				<!-- <ul class="admin-menu">
					<li><a href="">기본설정</a></li>
					<li><a href="">카테고리</a></li>
					<li class="selected">글작성</li>
				</ul> -->
				<!-- adminMenu -->
				<c:import url='/WEB-INF/views/includes/adminMenu.jsp' />
				<form
					action="${pageContext.servletContext.contextPath }/${authUser.userid}/admin/write"
					method="post">
					<table class="admin-cat-write">
						<tr>
							<td class="t">제목</td>
							<td><input type="text" size="60" name="p_title"> <select
								name="c_no">
									<c:forEach items="${resultCategoryVo }" var="resultCategoryVo">
										<option value="${resultCategoryVo.c_no }">${resultCategoryVo.c_name }</option>
									</c:forEach>
							</select></td>
						</tr>
						<tr>
							<td class="t">내용</td>
							<td><textarea name="p_desc"></textarea></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td class="s"><input type="submit" value="포스트하기"></td>
						</tr>
					</table>
				</form>
			</div>
		</div>

		<!-- footer -->
		<c:import url='/WEB-INF/views/includes/footer.jsp' />
	</div>
</body>
</html>