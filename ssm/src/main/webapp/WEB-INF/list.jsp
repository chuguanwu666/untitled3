<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr><th>id</th>
        <th>姓名</th>
        <th>金额</th>
    </tr>
    <c:forEach items="${list}" var="a">
        <tr><td>${a.id}</td>
            <td>${a.name}</td>
            <td>${a.money}</td>
        </tr>

    </c:forEach>
</table>

</body>
</html>
