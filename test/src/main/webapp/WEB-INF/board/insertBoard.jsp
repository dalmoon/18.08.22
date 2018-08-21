<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새글등록</title>
</head>
<body>
<center>
<h1>글 등록</h1>
<a href="logout.do">로그아웃</a>
<hr>
<form action="insert.do" method="post">
<table border="1" cellpadding="0" cellspacing="0">
	<tr>
		<td bgcolor="orange" width="70">제목</td>
		<td align="left"><input name="title" type="text"/></td>
	</tr>
	<tr>
		<td bgcolor="orange">작성자</td>
		<td align="left">${userName}<input name="writer" type="hidden" value="${userName}"/></td>
	</tr>
	<tr>
		<td bgcolor="orange">내용</td>
		<td align="left"><textarea name="content" rows="10" cols="40"></textarea>
	</tr>
	<tr>
		<td colspan="2" align="center">
		<input type="submit" value="새글 등록" />
		</td>
	</tr>
</table>
</form>
</center>
</body>
</html>