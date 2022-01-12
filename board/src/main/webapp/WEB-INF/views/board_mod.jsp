<%@ page contentType="text/html; chaset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="utf-8">
<title>main</title>
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
</head><script type="text/javascript">

	$(document).ready(function() {
		$("#ok").bind("click", function() {
			if($("#contents").val() == "" || $("#contents").val() == null) {
				alert("내용을 입력해주세요.");
				$("#contents").focus();
				return false;
			}
			
			if(confirm("수정 하시겠습니까?")) {
				$("#modf").submit();
			}
		})
	})
</script>
<body>
	<form action="board_do_mod" method="post" id="modf">
		<div>${ result.getTitle() }</div>
		<div>${ result.getId() }</div>
		<div>${ result.getWriter() }</div>
		<div><input type="text" value=${ result.getContent() } name="contents" id="contents"></div>
		<input type="button" value="완료" id="ok">
	</form>
</body>
</html>