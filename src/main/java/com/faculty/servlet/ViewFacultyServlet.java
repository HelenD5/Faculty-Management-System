package com.faculty.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.IOException;
import java.util.List;
import com.faculty.dao.FacultyDAOImpl;
import com.faculty.model.Faculty;

@WebServlet("/ViewFacultyServlet")
public class ViewFacultyServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FacultyDAOImpl dao = new FacultyDAOImpl();
        List<Faculty> list = dao.getAllFaculty();
        request.setAttribute("facultyList", list);
        RequestDispatcher rd = request.getRequestDispatcher("view/view_faculty.jsp");
        rd.forward(request, response);
    }
}