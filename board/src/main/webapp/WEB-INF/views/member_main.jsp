<%@ page contentType="text/html; chaset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="utf-8">
<title>main</title>
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>
	<div id="member_mod">회원정보수정</div>
	<div id="member_out">회원탈퇴</div>
	<div id="logout">로그아웃</div>
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
	$("#detail").bind("click", function() {
		location.href = "/user/logout";
	})
	
	$("#logout").bind("click", function() {
		location.href = "/user/logout";
	})
	
	$("#member_out").bind("click", function() {
		if(confirm("계정탈퇴 하시겠습니까? 탈퇴된 계정은 복구하실 수 없습니다.")) {
			location.href = "/user/member_out";
		}
	})
	
	$("#member_mod").bind("click", function() {
		location.href="/user/member_mod";
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