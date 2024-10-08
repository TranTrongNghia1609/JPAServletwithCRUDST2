<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<form action="${pageContext.request.contextPath }/admin/category/insert" method="post" enctype="multipart/form-data">
	<label for="categoryname">Category Name:</label><br> 
	<input type="text" id="categoryname" name="categoryname"><br> 
	
	<label for="images">Images: </label><br>
	<div style="width:100px; height:100px">
	<img alt="images" id="imagess" src="" width="150px" height="150px" /> 
	</div><br>
	Nhập link: <input type="text" id="images1" name="images1"><br>
	Hoặc tải file:
	<input type="file" onchange="chooseFile(this)" id="images" name="images"><br>
	
	<label for="status">Status: </label>
	<input id="statuson" type="radio" name="status" value="1" ${cate.status==1?'checked': ''}>
	<label for="statuson">Hoạt động</label>
	<input id="statusoff" type="radio" name="status" value="0" ${cate.status==0?'checked': ''}>
	<label for="statusoff">Khóa</label>
	
	<br> <input type="submit" value="Submit">
</form>
  