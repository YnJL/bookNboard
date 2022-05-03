<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Content Modify</title>
</head>
<body>
<form action="content_mod" method="post">
	<table border=1>
		<tr>
			<th>글번호</th>
			<td>${dto.bID }</td>
		</tr>
		<tr>
			<th>조회수</th>
			<td>${dto.bHits }</td>
		</tr>
		<tr>
			<th>글쓴이</th>
			<td><input type="hidden" name="mID" value="${dto.mID }">${dto.mID }</td>
		</tr>
		<tr>
			<th>글제목</th>
			<td><input type="text" name="bTitl" value="${dto.bTitl }"></td>
		</tr>
		<tr>
			<th>글내용</th>
			<td><textarea name="bCont" rows="20" cols="70">${dto.bCont }
			</textarea></td>
		</tr>
		<tr>
			<th colspan="2" width="700">
				<input type="hidden" name="bID" value="${dto.bID}">
				<input type="submit" value="수정하기">&nbsp;&nbsp;&nbsp;
				<input type="button" value="목록보기" onClick="location.href='cboard'">&nbsp;&nbsp;&nbsp;
				<input type="button" value="삭제하기" onClick="location.href='bdelete?bID=${content_view.bID}'">
			</th>
	</table>
</form>
</body>
</html>