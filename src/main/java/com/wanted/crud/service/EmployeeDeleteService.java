package com.wanted.crud.service;

import com.wanted.crud.dao.EmployeeDeleteDAO;
import java.sql.SQLException;

public class EmployeeDeleteService {

    private EmployeeDeleteDAO dao = new EmployeeDeleteDAO();

    public boolean deleteEmployee(int empId) throws SQLException {
        return dao.delete(empId);
    }
}