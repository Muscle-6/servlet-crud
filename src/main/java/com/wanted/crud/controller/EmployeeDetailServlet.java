package com.wanted.crud.controller;

import com.wanted.crud.dto.EmployeeDTO;
import com.wanted.crud.service.EmployeeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/employees/detail")
public class EmployeeDetailServlet extends HttpServlet {

    private final EmployeeService employeeService = new EmployeeService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String search = req.getParameter("search");
        String empId = req.getParameter("empId");

        // 첫 진입: 입력 화면만 보여줌
        if (search == null) {
            req.getRequestDispatcher("/view/employee/detail.jsp").forward(req, resp);
            return;
        }

        if (empId != null) {
            empId = empId.trim();
        }

        if (empId == null || empId.isBlank()) {
            req.setAttribute("message", "조회할 사번을 입력해주세요.");
            req.getRequestDispatcher("/view/employee/detail.jsp").forward(req, resp);
            return;
        }

        EmployeeDTO employee = employeeService.selectEmployeeById(empId);

        if (employee == null) {
            req.setAttribute("message", "해당 사원을 찾을 수 없습니다.");
            req.getRequestDispatcher("/view/employee/detail.jsp").forward(req, resp);
            return;
        }

        req.setAttribute("employee", employee);
        req.getRequestDispatcher("/view/employee/detail.jsp").forward(req, resp);
    }
}