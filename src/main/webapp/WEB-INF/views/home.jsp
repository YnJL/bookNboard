<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>웹 가계부에 어서오십시오!</h1>

<%
if(session.getAttribute("mid")!=null){
	String id = (String)session.getAttribute("mid");%>
<%=id %>님이 접속중입니다<%} %>


<hr/>
<table>
<tr>
<th width=150 align="center"><input type="button" value="커뮤니티" onClick="location.href='boardpage?pageN=1'"></th>
<%
if(session.getAttribute("mid")!=null){%>
<th width=150 align="center"><input type="button" value="내가계부" onClick="location.href='ledger'"></th>
<th width=150 align="center"><input type="button" value="로그아웃" onClick="location.href='logout'"></th><%
} else {%>
<th width=150 align="center"><input type="button" value="로그인" onClick="location.href='loginform'"></th>
<th width=150 align="center"><input type="button" value="회원가입" onClick="location.href='regform'"></th><%
}%>
<th width=150 align="center"><input type="button" value="전체보기" onClick="location.href='lAdmin'"></th>
<th width=150 align="center"><input type="button" value="회원명단" onClick="location.href='mlist'"></th>
</tr>
</table>
</body>
</html>
