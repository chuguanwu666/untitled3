<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h1><font color="red">Operation List</font></h1>
    <s:a href="register.action">add User</s:a><br/>
    <s:a href="listUser.action">List Users</s:a>
    <s:form action="findUser">
        <s:textfield name="id" label="id"></s:textfield>
        <s:submit></s:submit>
    </s:form>

</body>
</html>