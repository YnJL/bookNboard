<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가입양식</title>
</head>
<body>
<h1>회원가입</h1><hr/>
<form action="register" method="post">
<table border=1>
	<tr>
		<th width="100">ID</th>
		<td width="200"><input type="text" name="mID" size="50"></td>
	</tr>
	<tr>
		<th>PW</th>
		<td><input type="password" name="mPW" size="50"></td>
	</tr>
	<tr>
		<th>이름</th>
		<td><input type="text" name="mName" size="50"></td>
	</tr>
	<tr>
		<th>전화번호</th>
		<td><input type="text" name="mPhon" size="50"></td>
	</tr>
	<tr>
		<th colspan=2>
			<input type="submit" value="가입하기">
		</th>
		
	</tr> 
</table>
</form>
</body>
</html>