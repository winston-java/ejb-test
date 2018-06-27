<%@ page import="com.miratech.entity.Student" %>
<%@ page import="java.util.List" %>
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
        <title>Getting all students</title>
        <style>
            #counter {
                color: green;
                font-family: Tahoma;
                font-size: 13px;
            }
        </style>
    </head>
    <body>
        <a href="<%=URIMappings.ADD_STUDENT_JSP%>">Add new student!</a><br/>

        <div id="counter">Counter of the added students in the current session: <b>${counter}</b></div>
        <h1>Students:</h1>

        <%List<Student> students = (List<Student>) request.getAttribute(URIMappings.ATTRIBUTE_STUDENTS); %>

        <%
            for (Student student : students) {
        %>
        <a href="<%=URIMappings.URI_FULL_ENTITY%>?<%= URIMappings.PARAM_ID%>=<%= student.getId()%>">
            ID: <%= student.getId()%>; First name: <%= student.getFirstName()%>
        </a><br/>
        <%
            }
        %>
    </body>
</html>