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
<s:form method="post" action="login">
请修改用户信息：
   <s:hidden name="id" value="%{id}"></s:hidden>
用户名：<s:textfield name="username"></s:textfield>
密码：<s:textfield name="password" > </s:textfield>
<s:submit value="保存" method="doEditSubmit"></s:submit>
</s:form>

</body>
</html>