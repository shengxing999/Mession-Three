<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<%=basePath%>/lib/bootstrap.min.css"/>
    <title>首页</title>
<body>
<h2 style="text-align:center">艺术工作室后台</h2>
<h3 style="text-align: center;">
    ${username }的后台管理页面
</h3>
<hr/>
<a href="${pageContext.request.contextPath}/user/show">账户管理</a>
</body>
</html>
