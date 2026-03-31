package com.wanted.crud.service;

import com.wanted.crud.dao.EmployeeListDAO;
import com.wanted.crud.dto.EmployeeListDTO;

import java.util.List;

public class EmployeeListService {

    private EmployeeListDAO employeeListDAO = new EmployeeListDAO();

    public List<EmployeeListDTO> getEmployeeList() {
        return employeeListDAO.selectAllEmployee();
    }

}
