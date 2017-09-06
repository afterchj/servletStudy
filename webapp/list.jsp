<%--
  Created by IntelliJ IDEA.
  User: hongjian.chen
  Date: 2017/3/22
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="public/common.jsp"%>
<html>
<head>
    <title>list page</title>
    <style type="text/css">
        a{text-decoration: none;margin: auto 10px;}
        .tb{border-collapse: collapse; width:360px;}
    </style>
</head>
<body>
<table border="1" class="tb">
    <tr><td colspan="3"><h1>用户列表</h1></td></tr>
    <tr><td>用户名</td><td>密码</td><td>操作</td></tr>
    <c:forEach items="${users}" var="u">
        <tr>
            <td>${u.name}</td><td>${u.pwd}</td><td><a href="editUI?id=${u.id}">修改</a><a href="delete">删除</a></td>
        </tr>
    </c:forEach>
    <tr><td colspan="3"><a href="editUI?id=11">新增</a></td></tr>
</table>
</body>
</html>
