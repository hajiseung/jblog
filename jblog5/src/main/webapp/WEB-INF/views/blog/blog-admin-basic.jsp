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
				<c:import url='/WEB-INF/views/includes/adminMenu.jsp' />

				<form action="${pageContext.servletContext.contextPath}/${authUser.userid}/admin/basic"	method="post" enctype="multipart/form-data">
					<table class="admin-config">
						<tr>
							<td class="t">블로그 제목</td>
							<td><input type="text" size="40" name="blogtitle"></td>
						</tr>
						<tr>
							<td class="t">로고이미지</td>
							<c:if test="${resultBlogVo.bloglogo eq null }">
								<td><img src="${pageContext.servletContext.contextPath}/assets/images/no-image.png"	alt="사진을 넣어주세요" height="100" width="100"></td>
							</c:if>
							<c:if test="${resultBlogVo.bloglogo ne null }">
								<td><img
									src="${pageContext.servletContext.contextPath}${resultBlogVo.bloglogo}"></td>
							</c:if>
						</tr>
						<tr>
							<td class="t">&nbsp;</td>
							<td><input type="file" name="blogimage"></td>
						</tr>
						<tr>
							<td class="t">&nbsp;</td>
							<td class="s"><input type="submit" value="기본설정 변경"></td>
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