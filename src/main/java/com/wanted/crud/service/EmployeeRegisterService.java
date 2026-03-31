package com.wanted.crud.service;

import com.wanted.crud.dao.EmployeeRegistDAO;
import com.wanted.crud.dto.EmployeeRegisterRequestDTO;
import com.wanted.crud.global.JDBCTemplate;

import java.sql.Connection;

public class EmployeeRegisterService {

    private final EmployeeRegistDAO registDAO = new EmployeeRegistDAO();

    public void register(EmployeeRegisterRequestDTO requestDTO) {
        Connection conn = JDBCTemplate.getConnection();

        int result = registDAO.register(conn, requestDTO);

        if(result > 0) {
            JDBCTemplate.commit(conn);
            System.out.println("등록 성공 오호이야!");
        } else {
            JDBCTemplate.rollback(conn);
            System.out.println("등록 실패");
        }
        JDBCTemplate.close(conn);
    }
}
