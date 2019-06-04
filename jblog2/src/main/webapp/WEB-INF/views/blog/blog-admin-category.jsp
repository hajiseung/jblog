<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
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
				<table class="admin-cat">
					<tr>
						<th>번호</th>
						<th>카테고리명</th>
						<th>포스트 수</th>
						<th>설명</th>
						<th>삭제</th>
					</tr>
					<c:set var='count' value='${fn:length(resultCategoryVo) }' />
					<c:forEach items="${resultCategoryVo }" var="resultCategoryVo"
						varStatus="status" begin="0" end="${count }">
						<tr>
							<td id="categoryNum${resultCategoryVo.c_no }" hidden="hidden">${resultCategoryVo.c_no }</td>
							<td>${status.count}</td>
							<td>${resultCategoryVo.c_name }</td>
							<td>${resultCategoryVo.p_count }</td>
							<td>${resultCategoryVo.c_desc }</td>
							<td><img id="${resultCategoryVo.c_no }"
								class="deleteCategory"
								src="${pageContext.request.contextPath}/assets/images/delete.jpg"></td>
						</tr>
					</c:forEach>
				</table>

				<h4 class="n-c">새로운 카테고리 추가</h4>
				<form
					action="${pageContext.request.contextPath}/${authUser.userid}/admin/category"
					method="post">
					<table id="admin-cat-add">
						<tr>
							<td class="t">카테고리명</td>
							<td hidden="hidden"><input name="blogid"
								value="${authUser.userid}"></td>
							<td><input type="text" name="c_name"></td>
						</tr>
						<tr>
							<td class="t">설명</td>
							<td><input type="text" name="c_desc"></td>
						</tr>
						<tr>
							<td class="s">&nbsp;</td>
							<td><input type="submit" value="카테고리 추가"></td>
						</tr>
					</table>
				</form>
			</div>
		</div>

		<!-- footer -->
		<c:import url='/WEB-INF/views/includes/footer.jsp' />
	</div>
</body>
<script>

$(document).ready(function(){
	$('.deleteCategory').click(function(){
		
		var no = $(this).attr('id');
		var click = confirm("카테고리 내부의 포스트도 전부 삭제됩니다");
		var sessionV = '${authUser.userid}';
		if(click==true){
			$.ajax({
				url:'${pageContext.request.contextPath}/'+sessionV+'/delete/category',
				type:'POST',
				dataType:"JSON",
				data:{
					"c_no":no,
					"userid":sessionV
					}
				,
				success:function(data){
					console.log(data);
					if(data.result=="success"){
						window.location.href='${pageContext.request.contextPath}/'+sessionV+'/admin/category';
					}
				},
				error:function(xhr,error){
					console.error('Error!!!:'+error);
				}
			})
		}
	});
	
	
});
</script>
</html>