<%@ page contentType="text/html; chaset=utf-8" pageEncoding="utf-8" %>
<html>
<head>
<meta charset="utf-8">
<title>index</title>
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>
	<div id="go">게시판 바로가기</div>
</body>

<script type="text/javascript">
$(document).ready(function() {
	$("#go").bind("click", function() {
		location.href = "/user/main";
	})
})
</script>
</html>