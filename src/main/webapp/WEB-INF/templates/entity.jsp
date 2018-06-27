<%@ page import="com.miratech.entity.Student" %>
<%@ page import="com.miratech.cof.URIMappings" %><%--
  Created by IntelliJ IDEA.
  User: VitaliiS
  Date: 27.06.2018
  Time: 13:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Student's information</title>
    </head>
    <body>
        <a href="<%=URIMappings.URI_CONTEXT_ROOT%>">Home</a><br/>
        <h1>Student's information:</h1>
        <% Student student = (Student) request.getAttribute(URIMappings.ATTRIBUTE_STUDENT);%>
        ID: <%= student.getId()%>; First name: <%= student.getFirstName()%>; Last name: <%= student.getLastName()%>
    </body>
</html>