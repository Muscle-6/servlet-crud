package com.wanted.crud.controller;

import com.wanted.crud.dto.EmployeeRegisterRequestDTO;
import com.wanted.crud.service.EmployeeRegisterService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/employees/new")
public class EmployeeRegistServlet extends HttpServlet {

    private final EmployeeRegisterService registerService = new EmployeeRegisterService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/view/employee/regist.jsp").forward(req, resp);
        resp.getWriter().println("<h1>사원 목록 페이지는 아직 공사 중이다 오호이야! 등록은 성공했을 거야!</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        Long empId = Long.parseLong(req.getParameter("empId"));
        String empName = req.getParameter("empName");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String deptCode = req.getParameter("deptCode");
        String jobCode = req.getParameter("jobCode");
        String salaryStr = req.getParameter("salary");
        String hireDate = req.getParameter("hireDate");
        String entYn = req.getParameter("entYn");

        Long salary = 0L;

        if (salaryStr != null && !salaryStr.isEmpty()) {
            salary = Long.parseLong(salaryStr);
        }

        EmployeeRegisterRequestDTO requestDTO = new EmployeeRegisterRequestDTO(
                empId, empName, email, phone, deptCode, jobCode, salary, hireDate, entYn
        );
        System.out.println("등록 요청 데이터: " + requestDTO);
        registerService.register(requestDTO);
        resp.sendRedirect(req.getContextPath() + "/employees");
    }


}
