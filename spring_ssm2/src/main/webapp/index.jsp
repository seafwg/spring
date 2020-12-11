<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>保存账户信息：</h2>
<form action="${pageContext.request.contextPath}/account/save" method="post">
    用户名称<input type="text" name="name"><br/>
    账户金额<input type="text" name="money"><br/>
    <input type="submit" value="保存"><br/>
</form>
</body>
</html>
