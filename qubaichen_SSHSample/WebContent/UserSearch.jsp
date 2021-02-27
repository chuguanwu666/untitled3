<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
        function del(){
            if(confirm("Are you sure to delete the record?")){
                return true;
            }
            return false;
        }
    </script>
</head>
<body>
<h1><font color="red">Users List</font></h1>
	<input id="addButtom" name="buttonAdd" type="button" class="btn" value="Add" onclick="window.location.href='register.action'"/>
    <s:a href="index.action">返回</s:a>

    <table border="1" width="80%" align="center">
        <tr>
            <th>序号</th>
            <th>姓名</th>
            <th>密码</th>
            <th>删除</th>
            <th>更新</th>
        </tr>

        <s:iterator value="#request.list" id="us">
            <tr>
                <td>
                    <s:property value="#us.id"/>
                </td>
                <td>
                    <s:property value="#us.username"/>
                </td>
                <td>
                    <s:property value="#us.password"/>
                </td>
                <td align="center">
                    <s:a href="deleteUser.action?id=%{#us.id}" onclick="return del()">Delete</s:a>
                </td>
                <td align="center">
                    <s:a href="updateUser.action?id=%{#us.id}">Update</s:a>       
                </td>
            </tr>
        </s:iterator>
    </table>

</body>
</html>