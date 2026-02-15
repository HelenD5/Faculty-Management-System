<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="com.faculty.dao.FacultyDAOImpl, com.faculty.model.Faculty" %>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    FacultyDAOImpl dao = new FacultyDAOImpl();
    Faculty f = dao.getFacultyById(id);
%>
<html>
<head>
    <title>Update Faculty</title>
    <link rel="stylesheet" href="../css/style.css">
</head>
<body>
    <h2>Update Faculty</h2>
    <form action="../UpdateFacultyServlet" method="post">
        <input type="hidden" name="id" value="<%= f.getId() %>">

        <label>Name:</label><br>
        <input type="text" name="name" value="<%= f.getName() %>" required><br><br>

        <label>Department:</label><br>
        <input type="text" name="department" value="<%= f.getDepartment() %>" required><br><br>

        <label>Email:</label><br>
        <input type="email" name="email" value="<%= f.getEmail() %>" required><br><br>

        <label>Designation:</label><br>
        <input type="text" name="designation" value="<%= f.getDesignation() %>" required><br><br>

        <input type="submit" value="Update Faculty">
    </form>
    <br>
    <a href="view/index.jsp">⬅ Back to Home</a>
</body>
</html>