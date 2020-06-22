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
    <title>修改密码</title>
<body>
<h2 style="text-align:center">修改密码</h2>
<hr/>
<form action="<%=basePath%>/login/log" method="post" style="text-align:center">
    <label>原密码  </label>
    <input type="text" class="form-control" name="username"/>
    <br/>
    <br/>
    <label>新密码  </label>
    <input type="password" class="form-control" name="pwd"/>
    <br/>
    <br/>
    <label>确认密码 </label>
    <input type="password" class="form-control" name="pwd1"/>
    <br/>
    <br/>
    <input type="submit" value="登录" class="btn btn-default"/>
    <input type="reset" value="取消" class="btn btn-default"/>
    <p>${message}</p>
</form>
</body>
</html>
