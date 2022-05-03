<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ledger Insert</title>
</head>
<body>
<%
if(session.getAttribute("mid")==null) {
	response.sendRedirect("loginform");
}%>
<h1>입력하기</h1><hr/>
<form action="linsert" method="post">
<table border=1>
	<tr>
		<th width="100">일시</th>
		<td width="300"><input type="date" name="lDate"></td>
	</tr>
	<tr>
		<th>항목</th>
		<td>
			<select name="iID">
				<option value="">--선택하세요--</option>
				<c:forEach items="${items }" var="dto">
					<option value="${dto.iID }">${dto.item }</option>
				</c:forEach>
			</select>
		</td>
	</tr>
	<tr>
		<th>상세</th>
		<td><input type="text" name="detail" size="50"></td>
	</tr>
	<tr>
		<th>수입</th>
		<td><input type="text" name="income" size="50"></td>
	</tr>
	<tr>
		<th>지출</th>
		<td><input type="text" name="expnse" size="50"></td>
	</tr>
	<tr>
		<th>참고</th>
		<td><input type="text" name="note" size="50"></td>
	</tr>
	<tr>
		<th colspan=2>
			<input type="hidden" name="mID" value="<%=session.getAttribute("mid")%>">
			<input type="submit" value="등록하기">
		</th>
		
	</tr> 
</table>
</form>
</body>
</html>