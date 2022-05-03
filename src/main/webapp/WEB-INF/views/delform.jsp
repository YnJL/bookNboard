<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>탈퇴하기</title>
</head>
<body>
<h1>회원탈퇴</h1><hr/>
<form action="delete" method="post">
<table border=1>
	<tr>
		<th width="100">ID</th>
		<td width="200"><input type="text" name="mID" size="50"></td>
	</tr>
	<tr>
		<th colspan=2>
			<input type="submit" value="탈퇴하기">&nbsp;&nbsp;&nbsp;&nbsp;
		</th>
		
	</tr> 
</table>
</form>
</body>
</html>