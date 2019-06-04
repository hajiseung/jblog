<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="header">
	<h1>${resultBlogVo.blogtitle }</h1>
	<ul>
		<c:if test="${authUser.userid ne resultBlogVo.blogid }">
			<li><a
				href="${pageContext.servletContext.contextPath }/user/logout">로그아웃</a></li>
			<li><a
				href="${pageContext.servletContext.contextPath }/${authUser.userid }/admin/basic">내
					블로그 관리</a></li>
			<li><a
				href="${pageContext.servletContext.contextPath }/${resultBlogVo.blogid }">블로그
					메인</a></li>
		</c:if>
		<c:if test="${authUser.userid eq resultBlogVo.blogid }">
			<li><a
				href="${pageContext.servletContext.contextPath }/user/loginform">로그인</a></li>
			<li><a
				href="${pageContext.servletContext.contextPath }/${authUser.userid }/admin/basic">블로그
					관리</a></li>
			<li><a
				href="${pageContext.servletContext.contextPath }/${authUser.userid }">블로그
					메인</a></li>
		</c:if>

	</ul>
</div>