<%@ page contentType="text/html; chaset=utf-8" pageEncoding="utf-8" %>
<html>
<head>
<meta charset="utf-8">
<title>Login</title>
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
</head>

<body>
<%
		
		String userId = (String) session.getAttribute("userId");
		if (userId != null) {
			response.sendRedirect("/user/main");
		}
		
%>
	<h1>로그인</h1>
	<form action="login_ok" method="post" id="loginf">
		<p>아이디 : <input type="text" id="id" name="id">
		<p>비밀번호 : <input type="password" id="passwd" name="passwd">
		<p><input type="button" value="로그인" id="login">
			<input type="button" onclick="location.href='/user/sign_up'" value="회원가입" id="sign">
	</form>
	
</body>

<script type="text/javascript">
	
	$(document).ready(function() {
		$("#login").bind("click", function() {
			if($("#id").val() == "" || $("#id").val() == null) {
				alert("아이디를 입력해주세요.");
				$("#id").focus();
				return false;
			}

			if($("#passwd").val() == "" || $("#passwd").val() == null) {
				alert("비밀번호를 입력해주세요.");
				$("#passwd").focus();
				return false;
			}
			$("#loginf").submit();
		})
	})
</script>
</html>