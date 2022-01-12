<%@ page contentType="text/html; chaset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="utf-8">
<title>spring게시판</title>
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>
	<div id="login">로그인</div>
	<div id="register">회원가입</div>
	<div>
		<table width="500" border="1">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>글쓴이</th>
				<th>작성일</th>
			</tr>
			<c:forEach items="${list}" var="data">
				<tr>
					<td onclick="location.href='/board/detail?boardNum=${data.boardNum}'">${data.boardNum}</td>
					<td onclick="location.href='/board/detail?boardNum=${data.boardNum}'">${data.title}</td>
					<td onclick="location.href='/board/detail?boardNum=${data.boardNum}'">${data.writer}</td>
					<td onclick="location.href='/board/detail?boardNum=${data.boardNum}'">${data.createDate}</td>
				</tr>
			</c:forEach>
		</table>
		
	</div>
	<div id="writing">
		글쓰기
	</div>
	<form id=writef>
	</form>
</body>

<script type="text/javascript">
$(document).ready(function() {
	$("#login").bind("click", function() {
		location.href = "/user/login";
	})
	
	$("#register").bind("click", function() {
			location.href = "/user/sign_up";
	})
	
	$("#writing").bind("click", function() {
		location.href="/board/writing";
	})
	
	$("#detail").bind("click", function() {
		location.href="/board/detail";
	})
	
})
</script>
</html>