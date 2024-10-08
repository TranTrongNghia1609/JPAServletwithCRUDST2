<%--
  Created by IntelliJ IDEA.
  User: Nghiatran
  Date: 10/8/2024
  Time: 10:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<a href="${pageContext.request.contextPath }/admin/video/add">Add video</a> |
<a href="<c:url value='/admin/category/edit?id=${cate.categoryId }'/>">Sửa</a>
| <a
        href="<c:url value='/admin/category/delete?id=${cate.categoryId }'/>">Xóa</a>
<table border="1" width="100%">
    <tr>
        <th>STT</th>
        <th>Active</th>
        <th>VideoID</th>
        <th>Description</th>
        <th>Poster</th>
        <th>Title</th>
        <th>Views</th>
        <th>CategoryID</th>
    </tr>

    <c:forEach items="${listvideo}" var="video" varStatus="STT">
    <tr>
        <td>${STT.index+1}</td>
        <td>
            <c:if test="${video.active== 1}">
                <span>Hoạt động</span>
            </c:if>


            <c:if test="${video.active!= 1}">
                <span>Khóa</span>
            </c:if>

        </td>
        <td>${video.videoId}</td>
        <td>${video.description}</td>
        <td><c:if test="${video.poster.substring(0,5) != 'https'}">
            <c:url value="/image?fname=${video.poster}" var="imgUrl"></c:url>
        </c:if>
            <c:if test="${video.poster.substring(0,5) == 'https'}">
                <c:url value="${video.poster}" var="imgUrl"></c:url>
            </c:if>
            <img height="150" width="200" src="${imgUrl}" /></td>
        </td>
        <td>${video.title}</td>
        <td>${video.views}</td>
        <td>${video.category.categoryId}</td>

    </tr>
    </c:forEach>

</table>