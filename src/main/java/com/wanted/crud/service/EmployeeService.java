package com.wanted.crud.service;

import com.wanted.crud.dao.EmployeeDAO;
import com.wanted.crud.dto.EmployeeDTO;

import java.sql.Connection;

import static com.wanted.crud.global.JDBCTemplate.close;
import static com.wanted.crud.global.JDBCTemplate.getConnection;

public class EmployeeService {

    private final EmployeeDAO employeeDAO = new EmployeeDAO();

    public EmployeeDTO selectEmployeeById(String empId) {
        Connection con = getConnection();

        try {
            return employeeDAO.selectEmployeeById(con, empId);
        } finally {
            close(con);
        }
    }
}