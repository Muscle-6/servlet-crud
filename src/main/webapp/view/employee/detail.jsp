<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.wanted.crud.dto.EmployeeDTO" %>

<%
    String contextPath = request.getContextPath();
    EmployeeDTO employee = (EmployeeDTO) request.getAttribute("employee");
    String message = (String) request.getAttribute("message");
%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>사원 상세 조회</title>
    <style>
        * { box-sizing: border-box; }

        body {
            margin: 0;
            font-family: "Pretendard", "Noto Sans KR", sans-serif;
            background: #f8fafc;
            color: #1e293b;
        }

        .wrap {
            max-width: 960px;
            margin: 50px auto;
            padding: 0 20px;
        }

        .card {
            background: #fff;
            border-radius: 20px;
            box-shadow: 0 12px 35px rgba(15, 23, 42, 0.08);
            overflow: hidden;
            border: 1px solid #e2e8f0;
        }

        .header {
            background: linear-gradient(135deg, #4f46e5, #7c3aed);
            color: #fff;
            padding: 28px;
        }

        .header h1 {
            margin: 0 0 8px;
            font-size: 28px;
        }

        .header p {
            margin: 0;
            opacity: 0.9;
        }

        .content {
            padding: 28px;
        }

        .search-box {
            margin-bottom: 28px;
            padding: 20px;
            background: #f8fafc;
            border: 1px solid #e2e8f0;
            border-radius: 16px;
        }

        .search-box h2 {
            margin: 0 0 14px;
            font-size: 20px;
        }

        .search-form {
            display: flex;
            gap: 10px;
            flex-wrap: wrap;
        }

        .search-form input {
            flex: 1;
            min-width: 220px;
            height: 44px;
            padding: 0 12px;
            border: 1px solid #cbd5e1;
            border-radius: 10px;
            font-size: 15px;
        }

        .search-form button {
            height: 44px;
            padding: 0 18px;
            border: none;
            border-radius: 10px;
            background: #4f46e5;
            color: white;
            font-weight: 700;
            cursor: pointer;
        }

        .search-form button:hover {
            background: #4338ca;
        }

        .message {
            margin-top: 12px;
            color: #dc2626;
            font-size: 14px;
            font-weight: 600;
        }

        .detail-title {
            margin: 0 0 18px;
            font-size: 22px;
            font-weight: 800;
        }

        .grid {
            display: grid;
            grid-template-columns: repeat(2, minmax(0, 1fr));
            gap: 16px;
        }

        .item {
            background: #f8fafc;
            border: 1px solid #e2e8f0;
            border-radius: 14px;
            padding: 16px;
        }

        .label {
            font-size: 13px;
            color: #64748b;
            margin-bottom: 8px;
            font-weight: 600;
        }

        .value {
            font-size: 17px;
            font-weight: 700;
            color: #0f172a;
            word-break: break-word;
        }

        .button-row {
            display: flex;
            gap: 12px;
            flex-wrap: wrap;
            margin-top: 24px;
        }

        .btn {
            display: inline-flex;
            align-items: center;
            justify-content: center;
            min-width: 120px;
            height: 44px;
            padding: 0 18px;
            border: none;
            border-radius: 12px;
            text-decoration: none;
            font-size: 14px;
            font-weight: 700;
            cursor: pointer;
        }

        .btn-list {
            background: #e2e8f0;
            color: #1e293b;
        }

        .btn-list:hover {
            background: #cbd5e1;
        }

        .btn-edit {
            background: #2563eb;
            color: #fff;
        }

        .btn-edit:hover {
            background: #1d4ed8;
        }

        .btn-delete {
            background: #ef4444;
            color: #fff;
        }

        .btn-delete:hover {
            background: #dc2626;
        }

        .btn-home {
            background: #4f46e5;
            color: #fff;
        }

        .btn-home:hover {
            background: #4338ca;
        }

        .inline-form {
            margin: 0;
        }

        @media (max-width: 768px) {
            .grid {
                grid-template-columns: 1fr;
            }

            .button-row {
                flex-direction: column;
            }

            .btn, .inline-form {
                width: 100%;
            }
        }
    </style>
</head>
<body>
<div class="wrap">
    <div class="card">
        <div class="header">
            <h1>사원 상세 조회</h1>
            <p>사번을 입력하면 해당 사원의 상세 정보를 확인할 수 있습니다.</p>
        </div>

        <div class="content">
            <div class="search-box">
                <h2>사번 입력</h2>
                <form class="search-form" action="<%= contextPath %>/employees/detail" method="get">
                    <input type="hidden" name="search" value="true">
                    <input type="text" name="empId" placeholder="예: 200" required>
                    <button type="submit">조회</button>
                </form>

                <% if (message != null) { %>
                <div class="message"><%= message %></div>
                <% } %>
            </div>

            <% if (employee != null) { %>
            <h2 class="detail-title"><%= employee.getEmpName() %> 사원 상세 정보</h2>

            <div class="grid">
                <div class="item">
                    <div class="label">사번</div>
                    <div class="value"><%= employee.getEmpId() %></div>
                </div>

                <div class="item">
                    <div class="label">이름</div>
                    <div class="value"><%= employee.getEmpName() %></div>
                </div>

                <div class="item">
                    <div class="label">이메일</div>
                    <div class="value"><%= employee.getEmail() %></div>
                </div>

                <div class="item">
                    <div class="label">전화번호</div>
                    <div class="value"><%= employee.getPhone() %></div>
                </div>

                <div class="item">
                    <div class="label">부서 코드</div>
                    <div class="value"><%= employee.getDeptCode() %></div>
                </div>

                <div class="item">
                    <div class="label">부서명</div>
                    <div class="value"><%= employee.getDeptTitle() %></div>
                </div>

                <div class="item">
                    <div class="label">직급 코드</div>
                    <div class="value"><%= employee.getJobCode() %></div>
                </div>

                <div class="item">
                    <div class="label">직급명</div>
                    <div class="value"><%= employee.getJobName() %></div>
                </div>

                <div class="item">
                    <div class="label">급여</div>
                    <div class="value"><%= employee.getSalary() %></div>
                </div>

                <div class="item">
                    <div class="label">입사일</div>
                    <div class="value"><%= employee.getHireDate() %></div>
                </div>

                <div class="item">
                    <div class="label">퇴직 여부</div>
                    <div class="value"><%= employee.getEntYn() %></div>
                </div>
            </div>

            <div class="button-row">
                <a class="btn btn-list" href="<%= contextPath %>/employees">목록으로</a>

                <a class="btn btn-edit"
                   href="<%= contextPath %>/employees/edit?empId=<%= employee.getEmpId() %>">
                    수정하기
                </a>

                <form class="inline-form"
                      action="<%= contextPath %>/employees/delete"
                      method="post"
                      onsubmit="return confirm('정말 삭제하시겠습니까?');">
                    <input type="hidden" name="empId" value="<%= employee.getEmpId() %>">
                    <button type="submit" class="btn btn-delete">삭제하기</button>
                </form>

                <a class="btn btn-home" href="<%= contextPath %>/">메인으로</a>
            </div>
            <% } %>
        </div>
    </div>
</div>
</body>
</html>