package edu.mvcex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDAO {
	Connection  conn = null;
	   PreparedStatement pstmt = null;
	   
	   final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver" ;
	   final String JDBC_URL ="jdbc:mysql://localhost:3306/webdb?useSSL=false&serverTimezone=Asia/Seoul" ;
	   
	   public void open()
	   {
	      try {
	         Class.forName(JDBC_DRIVER);
	         conn = DriverManager.getConnection(JDBC_URL,"root", "1234");  
	               
	      }catch(Exception  e)
	         { e.printStackTrace();  }
	   }
	   
	   public void close()
	   {
	      try {
	         pstmt.close();
	         conn.close();
	      }catch(SQLException  e)
	      { e.printStackTrace();  }
	   }
	   
	   public void insert(Student  s)
	   {
	      open();
	      String sql = "INSERT INTO student(username, univ,birth,email) values(?,?, ?, ?);" ;
	      try {
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, s.getUsername() );
	         pstmt.setString(2, s.getUniv() );
	         pstmt.setDate(3, s.getBirth() );
	         pstmt.setString(4, s.getEmail() );
	         
	         pstmt.executeUpdate();
	      }catch(Exception  e)
	      { e.printStackTrace(); }
	      finally { close();  }
	   }
	   public ArrayList<Student>  getAll()
	   {
	      open();
	      ArrayList<Student>  students = 
	            new ArrayList<>();
	      
	      try {
	         pstmt = conn.prepareStatement(
	               "select * from student;"); 
	         ResultSet  rs = null;
	         rs = pstmt.executeQuery();
	         
	         while(rs.next())
	         {
	            Student  s = new Student() ;
	            s.setId(rs.getInt("id"));
	            s.setUsername(rs.getString("username"));
	            s.setUniv(rs.getString("univ"));
	            s.setBirth(rs.getDate("birth"));
	            s.setEmail(rs.getString("email"));
	            
	            students.add(s);
	         }
	         
	      }catch(Exception  e)
	      { e.printStackTrace();  }
	      finally {
	         close();
	      }
	      
	      return  students;
	      
	   }
}
