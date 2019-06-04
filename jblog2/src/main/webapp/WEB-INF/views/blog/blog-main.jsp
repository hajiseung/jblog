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
			<div id="content">
				<div class="blog-content">
					<h4>${postVoOne.p_title }</h4>
					<p>${postVoOne.p_desc }</p>
				</div>
				<ul class="blog-list">
					<c:if test="${resultPostVo ne null}">
						<c:forEach items="${resultPostVo }" var="resultPostVo">
							<li><a
								href="${pageContext.servletContext.contextPath }/${resultBlogVo.blogid}/${resultPostVo.c_no}/${resultPostVo.p_no}">${resultPostVo.p_title }</a><span>${resultPostVo.p_regdate }</span></li>
						</c:forEach>
					</c:if>
				</ul>
			</div>
		</div>

		<div id="extra">
			<div class="blog-logo">
				<c:if test="${resultBlogVo.bloglogo eq null }">
					<img
						src="${pageContext.request.contextPath}/assets/images/spring-logo.jpg">
				</c:if>
				<c:if test="${resultBlogVo.bloglogo ne null }">
					<img
						src="${pageContext.request.contextPath}${resultBlogVo.bloglogo}">
				</c:if>
			</div>
		</div>

		<div id="navigation">
			<h2>카테고리</h2>
			<ul>
				<c:forEach items="${resultCategoryVo }" var="resultCategoryVo">
					<li><a
						href="${pageContext.servletContext.contextPath }/${resultBlogVo.blogid}/${resultCategoryVo.c_no}">${resultCategoryVo.c_name }</a></li>
				</c:forEach>
			</ul>
		</div>

		<!-- footer -->
		<c:import url='/WEB-INF/views/includes/footer.jsp' />
	</div>
</body>
</html>