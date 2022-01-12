<%@ page contentType="text/html; chaset=utf-8" pageEncoding="utf-8" %>
<html>
<head>
<meta charset="utf-8">
<title>Sign Up</title>
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<script type="text/javascript">

	$(document).ready(function() {
		$("#sign").bind("click", function() {
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

			if($("#passwd_ok").val() != $("#passwd").val()) {
				alert("비밀번호 확인이 일치하지 않습니다.");
				$("#passwd").focus();
				return false;
			}

			if($("#name").val() == "" || $("#name").val() == null) {
				alert("이름을 입력해주세요.");
				$("#name").focus();
				return false;
			}

			if($("#nick").val() == "" || $("#nick").val() == null) {
				alert("닉네임을 입력해주세요.");
				$("#nick").focus();
				return false;
			}

			if($("#e_mail").val() == "" || $("#e_mail").val() == null) {
				alert("이메일을 입력해주세요.");
				$("#e_mail").focus();
				return false;
			}
			$("#signf").submit();
		})
	})
</script>
<body>
	<h1>Sign Up</h1>
	<form action="register" method="post" id="signf">
		<p>아이디 : <input type="text" id="id" name="id">
		<p>비밀번호 : <input type="password" id="passwd" name="passwd">
		<p>비밀번호 확인 : <input type="password" id="passwd_ok">
		<p>이름 : <input type="text" id="name" name="name">
		<p>닉네임 : <input type="text" id="nick" name="nickName">
		<p>이메일 : <input type="text" id="e_mail" name="e_mail">
		<p><input type="button" value="회원가입" id="sign">
	</form>
	
</body>
</html>