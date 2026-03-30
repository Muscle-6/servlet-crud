package com.wanted.crud.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String userId = req.getParameter("userId");
        String password = req.getParameter("password");

        // DB 검증 없이 무조건 성공
        // userId가 비어 있으면 화면 표시용 기본값만 넣어줌
        if (userId == null || userId.isBlank()) {
            userId = "guest";
        }

        HttpSession session = req.getSession();
        session.setAttribute("loginUser", userId);

        // 필요하면 표시용으로도 저장 가능
        session.setAttribute("loginMessage", "로그인 성공");

        resp.sendRedirect(req.getContextPath() + "/");
    }
}