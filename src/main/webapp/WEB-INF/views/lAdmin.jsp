<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체출력</title>
</head>
<body>
<h1>전체내역출력</h1>
<hr/>
<table border="1">
	<tr>
		<th width=50>연번</th>
		<th width=100>사용자</th>
		<th width=200>일시</th>
		<th width=100>항목</th>
		<th width=500>상세</th>
		<th width=120>수입</th>
		<th width=120>지출</th>
		<th width=150>비고</th>
		<th width=100></th>
	</tr>
	<c:forEach items="${list }" var="dto">
	<tr>
		<td align=center>${dto.lID }</td>
		<td align=center>${dto.mID }</td>
		<td align=center>${dto.lDate }</td>
		<td align=center>${dto.iID }</td>
		<td>${dto.detail}</td>
		<td align=right>${dto.income}</td>
		<td align=right>${dto.expnse}</td>
		<td>${dto.note}</td>
		<td align="center"><button onclick="location.href='ldelete?lID=${dto.lID}'">삭제</button></td>
	</tr>
	</c:forEach>
</table>
</body>
</html>