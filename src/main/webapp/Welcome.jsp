<%--
  Created by IntelliJ IDEA.
  User: w2
  Date: 29.10.2020
  Time: 17:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<script>
    function searchBook() {
        var xhttp = new XMLHttpRequest();
        var name = document.getElementById("searchId").value;
        if (name == "") {
            document.getElementById("searchId").value = "Please Enter something...";
            return;
        }
        xhttp.onreadystatechange = function () {
            if(this.readyState == 4 && this.status==200) {
                var bookList = JSON.parse(this.responseText);
                if(bookList.length>0) {
                    document.getElementById("bookId").value = bookList[0].book_id;
                    document.getElementById("bookName").value = bookList[0].name;
                    document.getElementById("author").value = bookList[0].author;
                    document.getElementById("countOfCopies").value = bookList[0].countOfCopies;
                    document.getElementById("bookURL").value = bookList[0].bookUrl;
                }
                else {
                    document.getElementById("searchId").value = "Not found";
                }
            }
        };
        xhttp.open("POST", "${pageContext.request.contextPath}/servlet", true);
        xhttp.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
        xhttp.send("submit=search&name=" + name);
    }

</script>
<body>
<%
    if(session.getAttribute("username") == null) {
        response.sendRedirect("index.jsp");
    }
%>
<input type="text" id="searchId" name="search">
<input type="button" name="search" value="search" onclick="searchBook()">

</body>
</html>
