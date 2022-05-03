<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LogIn Form</title>
</head>
<body>
	<form action="login" method="post">
		<table>
			<%
			if (session.getAttribute("check")==null) {
				
			}
			else if (session.getAttribute("check").equals("failure") || session.getAttribute("check").equals("except")) {
					String check = (String) session.getAttribute("check");
			%>
			<tr>
				<th colspan=2>로그인에 실패하였습니다<br>
				<%=check %></th>
			</tr>
			<%
			} else if(session.getAttribute("mid")!=null) {
			String id = (String) session.getAttribute("mid");
			%>
			<tr>
				<th colspan=2><%=id%> 로그인중</th>
			</tr>
			<%
					
			} else{
				
			}
			%>
			<tr>
				<th width=100>ID</th>
				<td width=200><input type="text" name="id"></td>
			</tr>
			<tr>
				<th>PW</th>
				<td><input type="password" name="pw"></td>
			</tr>
			<tr>
				<th colspan=2><input type="submit" value="로그인">
					&nbsp;&nbsp;&nbsp;&nbsp; <input type="button" value="회원가입"
					onClick="location.href='regform'"></th>
			</tr>
		</table>
	</form>
</body>
</html>