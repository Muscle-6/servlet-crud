<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.wanted.crud.dto.EmployeeListDTO, java.util.List" %>
<%
    Object loginUser = session.getAttribute("loginUser");
    if (loginUser == null) {
        response.sendRedirect(request.getContextPath() + "/");
        return;
    }

    List<EmployeeListDTO> empList = (List<EmployeeListDTO>) request.getAttribute("empList");
    String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>사원 목록</title>
</head>
<body>

<h2>사원 목록</h2>
<p>로그인 사용자: <%= loginUser %></p>

<a href="<%= contextPath %>/employees/new">사원 등록</a>
&nbsp;|&nbsp;
<a href="<%= contextPath %>/">메인으로</a>
&nbsp;|&nbsp;
<form action="<%= contextPath %>/logout" method="post" style="display:inline;">
    <button type="submit">로그아웃</button>
</form>

<hr>

<table border="1" cellpadding="8" cellspacing="0">
    <thead>
        <tr>
            <th>사번</th>
            <th>사원명</th>
            <th>이메일</th>
            <th>전화번호</th>
            <th>부서명</th>
            <th>직급명</th>
            <th>급여</th>
            <th>재직상태</th>
            <th>관리</th>
        </tr>
    </thead>
    <tbody>
        <%
            if (empList == null || empList.isEmpty()) {
        %>
        <tr>
            <td colspan="9" align="center">등록된 사원이 없습니다.</td>
        </tr>
        <%
            } else {
                for (EmployeeListDTO emp : empList) {
        %>
        <tr>
            <td><%= emp.getEmpId() %></td>
            <td><%= emp.getEmpName() %></td>
            <td><%= emp.getEmail() %></td>
            <td><%= emp.getPhone() %></td>
            <td><%= emp.getDeptTitle() %></td>
            <td><%= emp.getJobName() %></td>
            <td><%= emp.getSalary() %></td>
            <td><%= "N".equals(emp.getRetireYn()) ? "재직" : "퇴직" %></td>
            <td>
                <a href="<%= contextPath %>/employees/detail?empId=<%= emp.getEmpId() %>">상세</a>
                &nbsp;
                <a href="<%= contextPath %>/employees/edit?empId=<%= emp.getEmpId() %>">수정</a>
                &nbsp;
                <form action="<%= contextPath %>/employees/delete" method="post" style="display:inline;">
                    <input type="hidden" name="empId" value="<%= emp.getEmpId() %>">
                    <button type="submit" onclick="return confirm('정말 삭제하시겠습니까?')">삭제</button>
                </form>
            </td>
        </tr>
        <%
                }
            }
        %>
    </tbody>
</table>

</body>
</html>
