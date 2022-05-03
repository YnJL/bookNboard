<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>항목분류</title>
</head>
<body>
<h1>항목분류</h1>
<hr/>
<table border="1">
	<tr>
		<th width=100>항목ID</th>
		<th width=200>항목</th>
		<th width=200>항목분류</th>
		<th width=100></th>
	</tr>
	<c:forEach items="${items }" var="dto">
	<tr>
		<td align="center">${dto.iID }</td>
		<td align="center">${dto.item }</td>
		<td align="center">${dto.iSec }</td>
		<td align="center"><button onclick="location.href='delete?iID=${dto.iID}'">삭제</button></td>
	</tr>
	</c:forEach>
</table>
</body>
</html>