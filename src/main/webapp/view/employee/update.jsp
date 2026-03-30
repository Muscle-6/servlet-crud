<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 26. 3. 30.
  Time: 오후 1:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>사원 정보 수정</title>
    <style>
        body { font-family: Arial, sans-serif; background: #f4f6f8; padding: 40px; }
        .form-container { background: white; padding: 30px; border-radius: 12px; max-width: 500px; margin: 0 auto; box-shadow: 0 4px 6px rgba(0,0,0,0.1); }
        .form-group { margin-bottom: 15px; }
        label { display: block; font-weight: bold; margin-bottom: 5px; }
        input[type="text"], input[type="email"], input[type="number"], input[type="date"] {
            width: 100%; padding: 10px; border: 1px solid #ccc; border-radius: 6px; box-sizing: border-box;
        }
        .readonly-input { background-color: #e9ecef; cursor: not-allowed; outline: none; }
        .btn { width: 100%; padding: 12px; background: #2563eb; color: white; border: none; border-radius: 6px; font-weight: bold; cursor: pointer; margin-top: 10px; }
        .btn:hover { background: #1d4ed8; }
    </style>
</head>
<body>

<div class="form-container">
    <h2>사원 정보 수정</h2>
    <form action="${pageContext.request.contextPath}/employees/update" method="post">

        <div class="form-group">
            <label>사번</label>
            <input type="text" name="empId" value="${employee.empId}" class="readonly-input" readonly>
        </div>
        <div class="form-group">
            <label>사원명</label>
            <input type="text" name="empName" value="${employee.empName}" class="readonly-input" readonly>
        </div>

        <div class="form-group">
            <label>이메일</label>
            <input type="email" name="email" value="${employee.email}">
        </div>
        <div class="form-group">
            <label>전화번호</label>
            <input type="text" name="phone" value="${employee.phone}">
        </div>
        <div class="form-group">
            <label>부서코드</label>
            <input type="text" name="deptCode" value="${employee.deptCode}">
        </div>
        <div class="form-group">
            <label>직급코드</label>
            <input type="text" name="jobCode" value="${employee.jobCode}">
        </div>
        <div class="form-group">
            <label>급여</label>
            <input type="number" name="salary" value="${employee.salary}">
        </div>
        <div class="form-group">
            <label>입사일</label>
            <input type="date" name="hireDate" value="${employee.hireDate}">
        </div>
        <div class="form-group">
            <label>퇴직여부 (Y/N)</label>
            <input type="text" name="entYn" value="${employee.entYn}" maxlength="1">
        </div>

        <button type="submit" class="btn">수정 완료</button>
    </form>
</div>

</body>
</html>