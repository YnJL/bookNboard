<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원출력</title>
</head>
<body>
<h1>회원명단</h1>
<hr/>
<table border="1">
	<tr>
		<th width=100>ID</th>
		<th width=100>PW</th>
		<th width=200>이름</th>
		<th width=200>전화번호</th>
		<th width=200>가입일자</th>
		<th width=100></th>
	</tr>
	<c:forEach items="${mlist }" var="dto">
	<tr>
		<td align="center">${dto.mID }</td>
		<td align="center">${dto.mPW }</td>
		<td align="center">${dto.mName }</td>
		<td align="center">${dto.mPhon }</td>
		<td align="center">${dto.mRdte }</td>
		<td align="center"><button onclick="location.href='delete?mID=${dto.mID}'">삭제</button></td>
	</tr>
	</c:forEach>
</table>
</body>
</html>