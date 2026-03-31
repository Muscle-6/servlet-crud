<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 26. 3. 30.
  Time: 오후 1:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>사원 등록</h2>
<form action="${pageContext.request.contextPath}/employees/new" method="post">
    <div>
        <label>사번 : </label>
        <input type="text" name="empId" required>
    </div>
    <div>
        <label>사원명 (필수): </label>
        <input type="text" name="empName" required>
    </div>
    <div>
        <label>이메일 (필수) : </label>
        <input type="text" name="email" required>
    </div>
    <div>
        <label>전화번호 : </label>
        <input type="text" name="phone" required>
    </div>
    <div>
        <label>부서코드 : </label>
        <input type="text" name="deptCode" required>
    </div>
    <div>
        <label>직급코드 : </label>
        <input type="text" name="jobCode" required>
    </div>
    <div>
        <label>급여: </label>
        <input type="number" name="salary" required>
    </div>
    <div>
        <label>입사일: </label>
        <input type="date" name="hireDate" required>
    </div>
    <input type="hidden" name="entYn" value="N">

    <button type="submit">등록하기</button>
    <button type="reset">초기화</button>
</form>
</body>
</html>
