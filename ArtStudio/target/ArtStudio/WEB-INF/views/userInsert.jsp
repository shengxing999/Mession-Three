<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加新用户</title>
    <script type="text/javascript">
        function addSuccess_alert()
        {
            alert("添加成功！")
        }
    </script>
</head>
<body>
<h2 style="text-align:center">添加用户</h2>

<form:form action="${pageContext.request.contextPath}/user/add" cssStyle="text-align: center" method="post"
           modelAttribute="user">

    <label>账号：</label><form:input path="username"/> <form:errors cssStyle="color: #ff1b11" path="username"/><br><br>
    <label>密码：</label><form:password path="pwd"/><form:errors cssStyle="color: #ff1b11" path="pwd"/><br><br>
    <input type="submit" value="保存" onclick="addSuccess_alert()">    <input type="reset" value="取消"><br><br>
    <p style="color: #ff1b11">${message}</p>

</form:form>
</body>
</html>
