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
<s:form action="login" method="post">
        <s:textfield name="username" label="用户名"></s:textfield><s:fielderror fieldName="username"/>   
        <s:password name="password" label="密　码"></s:password><s:fielderror fieldName="password"/> 
        <s:submit value="保存"  method="register"></s:submit>
    </s:form>

</body>
</html>