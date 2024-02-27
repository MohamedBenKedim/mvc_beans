<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean class="mvc_app.mvc_app1.user" id="user" scope="application" >
</jsp:useBean>
<jsp:setProperty property="*" name="user"/><br>
<%
        user.insertUser();
%>
Record:<br>
Name : <jsp:getProperty property="username" name="user"/><br>
Age : <jsp:getProperty property="age" name="user"/><br>
University : <jsp:getProperty property="university" name="user" /><br>
Student interests : <jsp:getProperty property="interests" name="user" /><br>
