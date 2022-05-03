<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reply</title>
</head>
<body>
<%
if(session.getAttribute("mid")==null) {
	response.sendRedirect("loginform");
}%>
<form action="reply" method="post">
	<table border=1>
		<tr>
			<th>작성자</th>
				<td><input type=hidden name="mID" value="<%=session.getAttribute("mid")%>">
					<%=session.getAttribute("mid")%></td></tr>
		<tr>
			<th width=75>글제목</th>
			<td><input type=text name="bTitl" size="70"></td>
		<tr>
		<tr>
			<th>글내용</th>
			<td><textarea name="bCont" rows="10" cols="70"></textarea></td>
		<tr>
		<tr>
			<th colspan="2">
				<input type="hidden" name="bGroup" value="${dto.bGroup}">
				<input type="hidden" name="bSteps" value="${dto.bSteps}">
				<input type="hidden" name="bIndnt" value="${dto.bIndnt}">
				<input type="submit" value="등록하기"> &nbsp;&nbsp;&nbsp;&nbsp;
				<input type=button value="목록보기" onClick="location.href='cboard'">
			</th>
	</table>
</form>
</body>
</html>