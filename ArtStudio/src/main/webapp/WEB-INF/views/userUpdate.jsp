<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑用户</title>
</head>
<body>
<h2 style="text-align:center">编辑用户</h2>
<form id="updateForm" action="${pageContext.request.contextPath}/user/update" method="post">
    <input type="hidden" name="_method" value="PUT">
    <input type="hidden" value="${user.id}" name="id"/>
    <table align="center" bgcolor="white" border="1" cellpadding="0">
        <tr>
            <td>用户名：</td>
            <td><input type="text" value="${user.username}" name="username"/></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="text" value="${user.pwd}" name="pwd"/></td>
        </tr>
        <tr>
            <td>角色：</td>
            <td><input type="text" value="${user.roleId}" name="roleId"/></td>
        </tr>
        <tr>
            <td>操作：</td>
            <td><input type="submit" value="保存"/></td>
        </tr>
    </table>
</form>
</body>
</html>

