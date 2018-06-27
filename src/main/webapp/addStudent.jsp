<%@ page import="com.miratech.cof.URIMappings" %><%--
  Created by IntelliJ IDEA.
  User: VitaliiS
  Date: 27.06.2018
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Add new student</title>
        <style>
            table td#btn-place {
                text-align: center;
            }
        </style>
    </head>
    <body>
        <a href="<%=URIMappings.URI_CONTEXT_ROOT%>">Home</a><br/>

        <h1>Add new student</h1>

        <form action="<%=URIMappings.URI_FULL_ENTITY%>" method="post">
            <table>
                <tr>
                    <td>First name: </td>
                    <td><input type="text" name="<%= URIMappings.PARAM_FIRST_NAME%>" id="first-name"/></td>
                </tr>
                <tr>
                    <td>Last name: </td>
                    <td><input type="text" name="<%= URIMappings.PARAM_LAST_NAME%>" id="last-name"/></td>
                </tr>
                <tr>
                    <td colspan="2" id="btn-place"><input type="submit" value="Add!" id="btn"/></td>
                </tr>
            </table>
        </form>
    </body>
</html>
