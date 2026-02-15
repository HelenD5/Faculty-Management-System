package com.faculty.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.IOException;
import com.faculty.dao.FacultyDAOImpl;
import com.faculty.model.Faculty;

@WebServlet("/UpdateFacultyServlet")
public class UpdateFacultyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Faculty f = new Faculty();
        f.setId(Integer.parseInt(request.getParameter("id")));
        f.setName(request.getParameter("name"));
        f.setDepartment(request.getParameter("department"));
        f.setEmail(request.getParameter("email"));
        f.setDesignation(request.getParameter("designation"));

        FacultyDAOImpl dao = new FacultyDAOImpl();
        dao.updateFaculty(f);

        response.sendRedirect("ViewFacultyServlet");
    }
}