<%--
  Created by IntelliJ IDEA.
  User: hongjian.chen
  Date: 2017/3/22
  Time: 13:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="public/common.jsp" %>
<html>
<head>
    <title>editUI</title>
</head>
<body>
<c:choose>
<c:when test="${user.id==null}">
<form method="get" action="add">
    </c:when>
    <c:otherwise>
    <form method="get" action="update">
        </c:otherwise>
            </c:choose>
        <table>
            <tr>
                <td colspan="2"><input type="hidden" name="id" value="${user.id}"></td>
            </tr>
            <tr>
                <td colspan="2"><h1>用户修改</h1></td>
            </tr>
            <tr>
                <td>username:</td>
                <td><input name="name" type="text" value="${user.name}"></td>
            </tr>
            <tr>
                <td>password:</td>
                <td><input name="pwd" type="password" value="${user.pwd}"></td>
            </tr>
            <tr>
                <td><input type="submit" value="commit"></td>
                &nbsp;
                <td><input type="reset" value="reset"></td>
            </tr>
            <tr>
                <td style="color: red" colspan="2"><c:if test="${mess!=null}">${mess}</c:if></td>
            </tr>
        </table>
    </form>
</body>
</html>
