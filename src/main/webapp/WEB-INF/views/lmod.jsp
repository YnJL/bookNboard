<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ledger Modify</title>
<script>
	function confirm_del(){
		if(confirm("삭제하시겠습니까?")){
			location.href='ldelete?lID=${ldto.lID}';
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
}
%>
<h1>수정하기</h1><hr/>
<form action="lupdate" method="post">
	<table border=1>
		<tr>
		<th width="100">일시</th>
		<td width="300"><input type="date" name="lDate" value="${ldto.lDate }"></td>
	</tr>
	<tr>
		<th>항목</th>
		<td>
			<select name="iID">
				<option value="">--선택하세요--</option>
				<c:forEach items="${items }" var="idto">
					<option value="${idto.iID }" ${idto.iID eq ldto.iID ? 'selected="selected"' : '' }>
						${idto.item }
					</option>
				</c:forEach>
			</select>
		</td>
	</tr>
	<tr>
		<th>상세</th>
		<td><input type="text" name="detail" size="50" value="${ldto.detail }"></td>
	</tr>
	<tr>
		<th>수입</th>
		<td><input type="text" name="income" size="50" value="${ldto.income }"></td>
	</tr>
	<tr>
		<th>지출</th>
		<td><input type="text" name="expnse" size="50" value="${ldto.expnse }"></td>
	</tr>
	<tr>
		<th>참고</th>
		<td><input type="text" name="note" size="50" value="${ldto.note }"></td>
	</tr>
	<tr>
		<th colspan=2>
			<input type="hidden" name="mID" value="${ldto.mID }">
			<input type="hidden" name="lID" value="${ldto.lID }">
			<input type="submit" value="수정하기">&nbsp;&nbsp;&nbsp;
			<input type="button" value="목록보기" onClick="location.href='ledger'">&nbsp;&nbsp;&nbsp;
			<input type="button" value="삭제하기" onClick="confirm_del()">
			</th>
	</table>
</form>
</body>
</html>