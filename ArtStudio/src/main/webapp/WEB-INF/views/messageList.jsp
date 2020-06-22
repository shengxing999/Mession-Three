<%--
  Created by IntelliJ IDEA.
  User: wangpeng
  Date: 2020/6/20
  Time: 10:02 上午
  To change this template use File | Settings | File Templates.
--%>
<%--^^^^^添加对jstl列表的支持^^^^^--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <base href="<%=basePath%>">
    <title>留言列表</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet"
          href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous">

    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet"
          href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
          crossorigin="anonymous">

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script
            src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
</head>
<body>
<a href="${pageContext.request.contextPath}/user/addView">添加用户</a>
<table width="100" border="1" class="table table-striped">
    <tr style="text-align: center;font-size: x-small;">
        <th scope="col">ID</th>
        <th scope="col">用户名</th>
        <th scope="col">角色</th>
        <th scope="col">创建时间</th>
        <th scope="col">创建人</th>
        <th scope="col">操作</th>
    </tr>
    <c:forEach begin="0" step="1" items="${ userList }" var="p" varStatus="userlist">
        <tr style="text-align: center;font-size: x-small;">
            <th>${ p.id }</th>
            <th>${ p.username }</th>
            <th>${ p.roleId }</th>
            <th>${ p.createAt }</th>
            <th>${ p.createBy}</th>
            <th>
                <form action="${pageContext.request.contextPath}/user/update/${p.id}" method="get">
                    <input type="hidden" name="_method" value="UPDATE">
                    <input type="submit" value="修改"></form>
                <form action="${pageContext.request.contextPath}/user/delete?id=${p.id}" method="post">
                    <input type="hidden" name="_method" value="DELETE">
                    <input type="submit" value="删除" onclick='return confirm("确认要删除吗?")'></form>
            </th>
        </tr>
    </c:forEach>
</table>
<p>当前表格共${page.pages}页、${page.total}条记录</p>
<nav aria-label="Page navigation">
    <ul class="pagination">
        <li>
            <a href="<%=request.getContextPath()%>/user/show?page=${page.firstPage}" aria-label="Previous">
                <span aria-hidden="true">«</span>
            </a>
        </li>
        <c:forEach var="s" begin="1" end="${page.pages}">
            <li><a href="<%=request.getContextPath()%>/user/show?page=${s}">${s}</a></li>
        </c:forEach>
        <li>
            <a href="<%=request.getContextPath()%>/user/show?page=${page.lastPage}" aria-label="Next">
                <span aria-hidden="true">»</span>
            </a>
        </li>
    </ul>
</nav>
</body>
</html>
