<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>Add Faculty</title>
    <link rel="stylesheet" href="../css/style.css">
</head>
<body>
    <h2>Add Faculty</h2>
    <form action="../AddFacultyServlet" method="post">
        <label>Name:</label><br>
        <input type="text" name="name" required><br><br>

        <label>Department:</label><br>
        <input type="text" name="department" required><br><br>

        <label>Email:</label><br>
        <input type="email" name="email" required><br><br>

        <label>Designation:</label><br>
        <input type="text" name="designation" required><br><br>

        <input type="submit" value="Add Faculty">
    </form>
    <br>
    <a href="view/index.jsp">⬅ Back to Home</a>
</body>
</html>