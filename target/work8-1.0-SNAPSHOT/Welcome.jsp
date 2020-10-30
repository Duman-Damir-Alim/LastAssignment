<%--
  Created by IntelliJ IDEA.
  User: w2
  Date: 29.10.2020
  Time: 17:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    if(session.getAttribute("username") == null) {
        response.sendRedirect("index.jsp");
    }
%>
<h1>Hello + {username}</h1>
</body>
</html>
