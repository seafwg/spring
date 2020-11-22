<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Title</title>
	<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
</head>
<body>
	<form id="form">
		姓名：<input type="text" name="username"><br>
		年龄：<input type="text" name="age"><br>
		<input id="btn" type="button" value="提交">
	</form>
	<script>
		$(function() {
			$("#btn").click(function() {
				alert()
				$.ajax({
					type: "POST",
					url: "${pageContext.request.contextPath}/quick11",
					contentType: "application/json;charset=utf-8",
					success: function(data) {

					}
				})
			})

		})
	</script>
</body>
</html>
