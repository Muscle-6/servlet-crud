package com.wanted.crud.controller;

import com.wanted.crud.service.EmployeeDeleteService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/employees/delete")
public class EmployeeDeleteServlet extends HttpServlet {

    private EmployeeDeleteService service = new EmployeeDeleteService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int empId = Integer.parseInt(request.getParameter("empId"));

        try {
            service.deleteEmployee(empId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect(request.getContextPath() + "/employees");
    }
}