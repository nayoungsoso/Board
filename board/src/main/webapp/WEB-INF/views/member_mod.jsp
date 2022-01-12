<%@ page contentType="text/html; chaset=utf-8" pageEncoding="utf-8" %>
<%@ page import="com.dnabplus.board.domain.*"%>
<html>
<head>
<meta charset="utf-8">
<title>member_mod</title>
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<script type="text/javascript">

	$(document).ready(function() {
		$("#sign").bind("click", function() {
			if($("#name").val() == "" || $("#name").val() == null) {
				alert("이름을 입력해주세요.");
				$("#name").focus();
				return false;
			}

			if($("#nickN").val() == "" || $("#nickN").val() == null) {
				alert("닉네임을 입력해주세요.");
				$("#nickN").focus();
				return false;
			}

			if($("#email").val() == "" || $("#email").val() == null) {
				alert("이메일을 입력해주세요.");
				$("#email").focus();
				return false;
			}
			
			if(confirm("수정 하시겠습니까?")) {
				$("#modf").submit();
			}
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
	<h1>회원정보 수정</h1>
	<form action="doModify" method="post" id="modf">
		<p>아이디 : ${userId}
		<p>이름 : <input type="text" id="name" value=${ result.getName() } name="name">
		<p>닉네임 : <input type="text" id="nickN" value=${ result.getNickName() } name="nickName">
		<p>이메일 : <input type="text" id="email" value=${ result.getEmail() } name="e_mail">
		<p><input type="button" value="수정" id="sign">
	</form>
</body>
</html>