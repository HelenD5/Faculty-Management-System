<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List, com.faculty.model.Faculty" %>
<%
    List<Faculty> facultyList = (List<Faculty>) request.getAttribute("facultyList");
%>
<html>
<head>
    <title>View Faculty</title>
    <link rel="stylesheet" href="../css/style.css">
</head>
<body>
    <h2>Faculty List</h2>
    <table>
        <tr>
            <th>ID</th><th>Name</th><th>Department</th><th>Email</th><th>Designation</th><th>Actions</th>
        </tr>
        <%
            if (facultyList != null) {
                for (Faculty f : facultyList) {
        %>
        <tr>
            <td><%= f.getId() %></td>
            <td><%= f.getName() %></td>
            <td><%= f.getDepartment() %></td>
            <td><%= f.getEmail() %></td>
            <td><%= f.getDesignation() %></td>
            <td>
    <a href="<%= request.getContextPath() %>/view/update_faculty.jsp?id=<%= f.getId() %>">Update</a> |
    <a href="<%= request.getContextPath() %>/DeleteFacultyServlet?id=<%= f.getId() %>">Delete</a>
</td>
        </tr>
        <%
                }
            }
        %>
    </table>
    <br>
    <a href="view/index.jsp">⬅ Back to Home</a>
</body>
</html>
