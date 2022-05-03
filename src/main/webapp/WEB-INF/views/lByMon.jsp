<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가계부</title>
<script>
	function confirm_del(){
		if(confirm("삭제하시겠습니까?")){
			location.href='ldelete?lID=${dto.lID}';
		} else {
			return;
		}
	}
</script>
</head>
<body>
<%
if(session.getAttribute("mid")==null) {
	response.sendRedirect("loginform");
}%>
<h1>입출내역</h1>
<hr/>
	<form action="sByMn" method="post">
		<table>
			<tr>
				<th width=600><input type=month name="sMonth"></th>
				<th width=600><input type="submit" value="조회하기"></th>
			</tr>
		</table>
	</form>
	<table border="1">
<tr><th colspan = 8> ${sessionScope.mid}의 ${year }년 ${month }월 가계부</th></tr>
	<tr>
		<th width=50>연번</th>
		
		<th width=200>일시</th>
		<th width=100>항목</th>
		<th width=400>상세</th>
		<th width=100>수입</th>
		<th width=100>지출</th>
		<th width=150>비고</th>
		<th width=100>편집</th>
	</tr>
	<c:forEach items="${list }" var="dto">
	<tr>
		<td align=center>${dto.lID }
		</td>
		
		<td align=center><fmt:formatDate pattern="yyyy-MM-dd" value="${dto.lDate }"/></td>
		<td align=center>${dto.iID }</td>
		<td>${dto.detail}</td>
		<td align=right>${dto.income}</td>
		<td align=right>${dto.expnse}</td>
		<td>${dto.note}</td>
		<th><input type="button" value="수정" onClick="location.href='lmodify?lID=${dto.lID}'">
			<input type="button" value="삭제" onClick="confirm_del()"></th>
	</tr>
	</c:forEach>
	<tr>
		<th colspan=8>
			<table>
			<tr><td width=400>수입총계 : ${sum_inc }</td>
				<td width=400>지출총계 : ${sum_exp }</td>
				<td width=400>입출총계 : ${sum_bal }</td></tr>
			</table>
		</th>
	</tr>
	<tr>
		<th colspan=8><button onclick="location.href='ladd'">추가하기</button></th>
	</tr>
		</table>
</body>
</html>