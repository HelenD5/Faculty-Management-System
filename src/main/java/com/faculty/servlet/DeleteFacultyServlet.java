package com.faculty.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.IOException;
import com.faculty.dao.FacultyDAOImpl;

@WebServlet("/DeleteFacultyServlet")
public class DeleteFacultyServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        FacultyDAOImpl dao = new FacultyDAOImpl();
        dao.deleteFaculty(id);
        response.sendRedirect(request.getContextPath() + "/ViewFacultyServlet");
    }
}