<%--
  Created by IntelliJ IDEA.
  User: hongjian.chen
  Date: 2017/3/17
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="public/common.jsp"></jsp:include>
<html>
<head>
    <title>登入成功</title>
</head>
<body>
<%
    String mess = (String) request.getAttribute("mess");
    if (null == mess) {
        System.out.println("mess为空" + mess);
    } else {
        System.out.println("mess=" + mess);
    }
%>
<h1><%=mess %>
</h1>
<p style="color: green">${mess}</p>
This is a jsp page!
</body>
</html>
