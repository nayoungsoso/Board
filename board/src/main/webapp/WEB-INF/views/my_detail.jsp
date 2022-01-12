<%@ page contentType="text/html; chaset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="utf-8">
<title>main</title>
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>
<% 
String boardNum = request.getParameter("boardNum");
%>
	<form action="board_mod.jsp" method="post">
		<div>${ result.getTitle() }</div>
		<div>${ result.getId() }</div>
		<div>${ result.getWriter() }</div>
		<div>${ result.getContent() }</div>
		<div>${ result.getCreateDate() }</div>
		<input type="hidden"value=boardNum name="boardNum">
		<input type="button"value="수정" id="board_mod">
		<input type="button"value="삭제" id="board_x">
	</form>
</body>

<script type="text/javascript">

$(document).ready(function() {
	$("#board_mod").bind("click", function() {
		location.href = "/board/board_mod?boardNum='boardNum'";
	})
		
	$("#board_x").bind("click", function() {
		if(confirm("게시물을 삭제하시겠습니까?")) {
			location.href = "/user/board_x?boardNum='boardNum'";
		}
	})
})
</script>
</html>