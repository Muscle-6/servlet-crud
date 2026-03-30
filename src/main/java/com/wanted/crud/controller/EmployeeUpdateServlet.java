package com.wanted.crud.controller;

import com.wanted.crud.dao.EmployeeUpdateDAO;
import com.wanted.crud.dto.EmployeeUpdateDTO;
import com.wanted.crud.global.JDBCTemplate; // JDBCTemplate 임포트 완료!

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;

@WebServlet(urlPatterns = {"/employees/edit", "/employees/update"})
public class EmployeeUpdateServlet extends HttpServlet {

    private EmployeeUpdateDAO updateDAO = new EmployeeUpdateDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String empId = request.getParameter("empId");

        // 1. DB 연결
        Connection conn = JDBCTemplate.getConnection();

        // 2. 사원 정보 조회
        EmployeeUpdateDTO employee = updateDAO.selectEmployeeById(conn, empId);

        // 3. 자원 반납
        JDBCTemplate.close(conn);

        // 4. 화면으로 이동
        request.setAttribute("employee", employee);
        request.getRequestDispatcher("/view/employee/update.jsp").forward(request, response);    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        // 파라미터 받기
        String empId = request.getParameter("empId");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String deptCode = request.getParameter("deptCode");
        String jobCode = request.getParameter("jobCode");
        String salaryStr = request.getParameter("salary");
        String hireDateStr = request.getParameter("hireDate");
        String entYn = request.getParameter("entYn");

        // DTO에 담기
        EmployeeUpdateDTO dto = new EmployeeUpdateDTO();
        dto.setEmpId(empId);
        dto.setEmail(email);
        dto.setPhone(phone);
        dto.setDeptCode(deptCode);
        dto.setJobCode(jobCode);

        if (salaryStr != null && !salaryStr.isEmpty()) {
            dto.setSalary(Integer.parseInt(salaryStr));
        }
        if (hireDateStr != null && !hireDateStr.isEmpty()) {
            dto.setHireDate(Date.valueOf(hireDateStr));
        }
        dto.setEntYn(entYn);

        // 1. DB 연결
        Connection conn = JDBCTemplate.getConnection();

        // 2. 정보 수정
        int result = updateDAO.updateEmployee(conn, dto);

        // 3. 자원 반납
        JDBCTemplate.close(conn);

        // 4. 상세 페이지로 이동
        response.sendRedirect(request.getContextPath() + "/employees/detail?empId=" + empId);
    }
}