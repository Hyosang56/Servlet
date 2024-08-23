<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page contentType= "text/html;charset=UTF-8"%>
<%@ page import = "java.sql.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원 정보</h2>
    <%
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // JDBC 드라이버 로드
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 데이터베이스 연결
            String jdbcUrl = "jdbc:mysql://localhost:3306/yourDatabaseName?useSSL=false&serverTimezone=UTC";
            String dbUser = "yourUsername";
            String dbPass = "yourPassword";
            conn = DriverManager.getConnection(jdbcUrl, dbUser, dbPass);

            // SQL 쿼리 작성 및 실행
            String sql = "SELECT * FROM tblRegister";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            // 결과 처리
            List<RegisterBean> registerList = new ArrayList<>();
            while (rs.next()) {
                RegisterBean register = new RegisterBean();
                register.setId(rs.getString("id"));
                register.setPasswd(rs.getString("passwd"));
                register.setName(rs.getString("name"));
                register.setNum1(rs.getString("num1"));
                register.setNum2(rs.getString("num2"));
                register.setEmail(rs.getString("email"));
                register.setPhone(rs.getString("phone"));
                register.setZipcode(rs.getString("zipcode"));
                register.setAddress(rs.getString("address"));
                register.setJob(rs.getString("job"));

                registerList.add(register);
            }

            // 출력
            for (RegisterBean reg : registerList) {
                %>
                <p>ID: <%= reg.getId() %></p>
                <p>이름: <%= reg.getName() %></p>
                <p>이메일: <%= reg.getEmail() %></p>
                <p>전화번호: <%= reg.getPhone() %></p>
                <p>주소: <%= reg.getAddress() %></p>
                <p>직업: <%= reg.getJob() %></p>
                <hr>
                <%
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException ignore) {}
            if (pstmt != null) try { pstmt.close(); } catch (SQLException ignore) {}
            if (conn != null) try { conn.close(); } catch (SQLException ignore) {}
        }
    %>
</body>
</html>