<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
	src="${pageContext.servletContext.contextPath }/assets/js/jquery/jquery-1.9.0.js"></script>
</head>
<body>
	<script>
$(function(){
		$('#blog-id').change(function(){
			$('#btn-checkemail').show();
			$('#img-checkemail').hide();
		});
		$('#btn-checkemail').click(function(){
			var id = $('#blog-id').val();
			if(id==''){return;}
			
			/* ajax 통신 */
			$.ajax({
				url:"${pageContext.servletContext.contextPath }/user/checkid?userid="+id,
				type:"GET",/* get이냐 post이냐 */
				dataType:"JSON",
				data:"",
				success:function(response){
					if(response.result != "success"){
						console.error(response);
						console.error(response.message);
						return;
					}
					if(response.data == true){
						alert('존재하는 Email입니다.');
						$('#blog-id').focus();
						$('#blog-id').val('');
						
						return;
					}else{
						$('#btn-checkemail').hide();
						$('#img-checkemail').show();
					}
				},
				error:function(xhr,error){
					console.error('Error!!!:'+error);
				}
			});
			console.log(id);
			
		})
	});
</script>
	<div class="center-content">
		<!-- headerMain -->
		<c:import url='/WEB-INF/views/includes/headerMain.jsp' />

		<%-- <form class="join-form" id="join-form" method="post" action="${pageContext.servletContext.contextPath}/user/join"> --%>
		<form:form cssClass="join-form" modelAttribute="userVo" id="join-form"
			name="joinForm" method="post"
			action='${pageContext.servletContext.contextPath }/user/join'>

			<label class="block-label" for="name">이름</label>
			<input id="name" name="username" type="text" value="">
			<spring:hasBindErrors name="userVo">
				<c:if test="${errors.hasFieldErrors('username') }">
					<p
						style="font-weight: bold; color: red; padding: 0 0 0 0; text-align: left;">
						<spring:message
							code="${errors.getFieldError( 'username' ).codes[0] }"
							text="${errors.getFieldError( 'username' ).defaultMessage }" />
					</p>
				</c:if>
			</spring:hasBindErrors>

			<label class="block-label" for="blog-id">아이디</label>
			<input id="blog-id" name="userid" type="text">
			<spring:hasBindErrors name="userVo">
				<c:if test="${errors.hasFieldErrors('userid') }">
					<p
						style="font-weight: bold; color: red; padding: 0 0 0 0; text-align: left;">
						<spring:message
							code="${errors.getFieldError( 'userid' ).codes[0] }"
							text="${errors.getFieldError( 'userid' ).defaultMessage }" />
					</p>
				</c:if>
			</spring:hasBindErrors>
			<input id="btn-checkemail" type="button" value="id 중복체크">
			<img id="img-checkemail" style="display: none;"
				src="${pageContext.servletContext.contextPath}/assets/images/check.png">

			<label class="block-label" for="password">패스워드</label>
			<input id="password" name="userpassword" type="password" />
			<spring:hasBindErrors name="userVo">
				<c:if test="${errors.hasFieldErrors('userpassword') }">
					<p
						style="font-weight: bold; color: red; padding: 0 0 0 0; text-align: left;">
						<spring:message
							code="${errors.getFieldError( 'userpassword' ).codes[0] }"
							text="${errors.getFieldError( 'userpassword' ).defaultMessage }" />
					</p>
				</c:if>
			</spring:hasBindErrors>

			<fieldset>
				<legend>약관동의</legend>
				<input id="agree-prov" type="checkbox" name="agreeProv" value="y">
				<label class="l-float">서비스 약관에 동의합니다.</label>
			</fieldset>

			<input type="submit" value="가입하기">

		</form:form>
		<!-- </form> -->
	</div>
</body>
</html>
