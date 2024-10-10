<%--
  Created by IntelliJ IDEA.
  User: foren
  Date: 10/9/2024
  Time: 7:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%--
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form action="${pageContext.request.contextPath }/admin/video/update" method="post" enctype="multipart/form-data">
  <input type="text" id = "videoid" name = "videoid" value="${video.videoId }" hidden="hidden"><br>
  <label for="Title">Video Name:</label><br>
  <input type="text" id="title" name="title" value="${video.title}"><br>
  <label for="Description">Description:</label><br>
  <input type="text" id="description" name="description" value="${video.description}"><br>
  <label for="categoryid">CategoryID:</label><br>
  <input type="text" id="categoryid" name="categoryId" value="${video.category.categoryId}">
  <br>

  <label for="poster">Poster:</label><br>

  <c:if test="${video.poster.substring(0,5) != 'https'}">
    <c:url value="/image?fname=${video.poster }" var="imgUrl"></c:url>
  </c:if>
  <c:if test="${video.poster.substring(0,5) == 'https'}">
    <c:url value="${video.poster }" var="imgUrl"></c:url>
  </c:if>
  <img id="imagess" height="150" width="200" src="${imgUrl}" />
  <br>
  Hoặc tải file:
  <input type="file" onchange="chooseFile(this)" id="poster" name="poster" value="${video.poster}"><br>

  <label for="Activeon">Active : </label>
  <input id="activeon" type="radio" name="active" value="1" ${video.active==1?'checked': ''}>
  <label for="activeon">Hoạt động</label>
  <input id="activeoff" type="radio" name="active" value="0" ${video.active==0?'checked': ''}>
  <label for="activeoff">Khóa</label>

  <br>
  <label for="views">Số lượt xem:</label><br>
  <input type="text" id="views" name="views" value="${video.views}"><br>

  <br> <input type="submit" value="Submit">
</form>
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>

<form action="${pageContext.request.contextPath }/admin/video/update" method="post" enctype="multipart/form-data">

  <input type="text" id="videoId" name="videoId" value="${video.videoId }" hidden="hidden"><br>

  <label for="videoname">Video Name:</label><br>
  <input type="text" id="videoname" name="title" value="${video.title }"><br>
  <label for="categoryid">CategoryID:</label><br>
  <input type="text" id="categoryid" name="categoryid" value="${video.category.categoryId}">
  <br>
  <label for="Description">Description:</label><br>
  <input type="text" id="description" name="description" value="${video.description}"><br>
  <label for="poster">Poster:</label><br>
  <c:if test="${video.poster.substring(0,5) != 'https'}">
    <c:url value="/image?fname=${video.poster }" var="imgUrl"></c:url>
  </c:if>
  <c:if test="${video.poster.substring(0,5) == 'https'}">
    <c:url value="${video.poster }" var="imgUrl"></c:url>
  </c:if>
  <img id="imagess" height="150" width="200" src="${imgUrl}" />
  <br>
  Nhập link: <input type="text" id="poster1" name="poster1"><br>
  Hoặc tải file:
  <input type="file" onchange="chooseFile(this)" id="poster" name="poster" value="${video.poster}"><br>

  <label for="status">Status: </label>
  <input id="statuson" type="radio" name="active" value="1" ${video.active==1?'checked': ''}>
  <label for="statuson">Hoạt động</label>
  <input id="statusoff" type="radio" name="active" value="0" ${video.active==0?'checked': ''}>
  <label for="statusoff">Khóa</label>
  <br>
  <label for="views">Số lượt xem:</label><br>
  <input type="text" id="views" name="views" value="${video.views}"><br>
  <br> <input type="submit" value="Submit">
</form>

