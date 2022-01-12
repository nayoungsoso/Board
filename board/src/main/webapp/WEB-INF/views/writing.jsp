<%@ page contentType="text/html; chaset=utf-8" pageEncoding="utf-8" %>
<html>
<head>
<meta charset="utf-8">
<title>Write</title>
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<script type="text/javascript">
$(document).ready(function() {
	$("#okBtn").bind("click", function() {
		if($("#title").val() == "" || $("#title").val() == null) {
			alert("제목을 입력해주세요.");
			$("#title").focus();
			return false;
		}
		if($("#content").val() == "" || $("#content").val() == null) {
			alert("내용을 입력해주세요.");
			$("#content").focus();
			return false;
		}
		$("#writef").submit();
	})
})

</script>
<body>
<%
	response.setContentType("text.html; charset=UTF-8");
	String userId = (String) session.getAttribute("userId");

	if (userId == null) {
		response.sendRedirect("/user/loginx");
	}
%>
	<h1>게시글 작성하기</h1>
	<form action="writing_sucess" method="post" id="writef">
		<div>아이디 - ${id}</div>
		<div>닉네임 - ${writer}</div>
		<div>
			<input type="text" placeholder="제목" id="title" name="title">
		</div>
		<div>
			<textarea placeholder="내용" id="content" name="content"></textarea>
		</div>
		<input type="button" id="okBtn" value="등록하기"></input>
		<input type="hidden" value=${ id } name = "id"></input>
		<input type="hidden" value=${ writer } name = "writer"></input>
	</form>
	
</body>
</html>