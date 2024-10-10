<%--
  Created by IntelliJ IDEA.
  User: foren
  Date: 10/8/2024
  Time: 1:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form action="${pageContext.request.contextPath }/admin/video/insert" method="post" enctype="multipart/form-data">
    <label for="Videoid">Video ID:</label><br>
    <input type="text" id = "videoid" name = "videoid"><br>
    <label for="Title">Video Name:</label><br>
    <input type="text" id="title" name="title"><br>
    <label for="Description">Description:</label><br>
    <input type="text" id="description" name="description"><br>
    <label for="categoryid">CategoryID:</label><br>
    <input type="text" id="categoryid" name="categoryid" value="${categoryid}">
    <br>
    <label for="poster">Poster: </label><br>
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
    <input type="file" onchange="chooseFile(this)" id="poster" name="poster"><br>

    <label for="Activeon">Active : </label>
    <input id="activeon" type="radio" name="active" value="1" ${video.active==1?'checked': ''}>
    <label for="activeon">Hoạt động</label>
    <input id="activeoff" type="radio" name="active" value="0" ${video.active==0?'checked': ''}>
    <label for="activeoff">Khóa</label>

    <br>
    <label for="views">Số lượt xem:</label><br>
    <input type="text" id="views" name="views"><br>

    <br> <input type="submit" value="Submit">
</form>
