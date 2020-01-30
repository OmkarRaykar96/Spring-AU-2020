<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Manager Home</title>
    </head>
    <body>
        <div align="center">
            <h1>Employees</h1>
            <h3><a href="/MVCSpring/EmployeeForm">Click to Add New Employee</a></h3>
            <table border="1">
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Telephone</th>
                <th colspan="2">Action</th>
                 
                <c:forEach var="employee" items="${listEmployee}" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td>${employee.f_name}</td>
                    <td>${employee.l_name}</td>
                    <td>${employee.email}</td>
                    <td>${employee.telephone}</td>
                    <td> <a href="/MVCSpring/editEmployee?id=${employee.id}">Edit</a> </td>      
                    <td> <a href="/MVCSpring/deleteEmployee?id=${employee.id}">Delete</a> </td>
                </tr>
                </c:forEach>             
            </table>
        </div>
    </body>
</html>