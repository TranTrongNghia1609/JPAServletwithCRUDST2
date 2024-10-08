<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>

<form action="${pageContext.request.contextPath }/admin/category/update" method="post" enctype="multipart/form-data">

	<input type="text" id="categoryid" name="categoryid" value="${cate.categoryid }" hidden="hidden"><br> 

	<label for="categoryname">Category Name:</label><br> 
	<input type="text" id="categoryname" name="categoryname" value="${cate.categoryname }"><br> 
	<label for="images">Images:</label><br> 
	
		<c:if test="${cate.images.substring(0,5) != 'https'}">
			<c:url value="/image?fname=${cate.images }" var="imgUrl"></c:url>
		</c:if>			
		<c:if test="${cate.images.substring(0,5) == 'https'}">
			<c:url value="${cate.images }" var="imgUrl"></c:url>
		</c:if>	
		<img id="imagess" height="150" width="200" src="${imgUrl}" />
		
	<input type="file" onchange="chooseFile(this)" id="images" name="images" value="${cate.images }"><br>
	
	<label for="status">Status: </label>
	<input id="statuson" type="radio" name="status" value="1" ${cate.status==1?'checked': ''}>
	<label for="statuson">Hoạt động</label>
	<input id="statusoff" type="radio" name="status" value="0" ${cate.status==0?'checked': ''}>
	<label for="statusoff">Khóa</label>
	
	<br> <input type="submit" value="Submit">
</form>
  