<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Content View</title>
<script>
	function confirm_del(){
		if(confirm("삭제하시겠습니까?")){
			location.href='bdelete?bID=${content_view.bID}';
		} else {
			return;
		}
	}
</script>
</head>
<body>
	<table border=1>
		<tr>
			<th width=100>글번호</th>
			<td width=300>${content_view.bID }</td>
			<th width=100>글쓴이</th>
			<td width=300>${content_view.mID }</td>
			<th width=100>조회수</th>
			<td width=300>${content_view.bHits }</td>
		</tr>
		<tr>
			<th>글제목</th>
			<td colspan="5">${content_view.bTitl }</td>
		</tr>
		<tr>
			<th valign=top>글내용</th>
			<td valign=top colspan="5" height=400>${content_view.bCont }</td>
		</tr>
		<tr>
			<th colspan="6">
			<c:if test='${sessionScope.mid eq content_view.mID}'>
				<input type="button" value="수정" onClick="location.href='c_mod?bID=${content_view.bID}'"> &nbsp;&nbsp;
			</c:if>
				<input type="button" value="목록" onClick="location.href='cboard'">&nbsp;&nbsp;
				<input type="button" value="댓글" onClick="location.href='reply_write?bID=${content_view.bID}'">&nbsp;&nbsp;
			<c:if test='${sessionScope.mid eq content_view.mID}'>
				<input type="button" value="삭제" onClick="confirm_del()">
			</c:if>
			</th>
	</table>
</body>
</html>