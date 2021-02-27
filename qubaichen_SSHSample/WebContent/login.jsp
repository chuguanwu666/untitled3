<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
		String message = (String)request.getAttribute("message");
		if(message != null){
	 %>
		<h2><%=message%></h2>    
	<%} %>
    <s:form method="post" action="login">

        <s:textfield name="username" label="用户名"/>
        <s:password name="password" label="密　码"/>
        <s:submit value="登陆" method="getLogin"/>
         <input type="button" value="注册" 
         onclick="window.location.href='register'">
    </s:form>

</body>
</html>