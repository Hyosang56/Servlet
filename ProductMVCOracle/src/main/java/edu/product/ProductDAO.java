package edu.product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ProductDAO {
	Connection conn = null;
	PreparedStatement pstmt;
	
	final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public void open(){
	      try {
	         Class.forName(JDBC_DRIVER);
	         conn = DriverManager.getConnection(JDBC_URL,"madang","madang");
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	   }
	   
	   public void close() {
	      try {
	         pstmt.close();
	         conn.close();
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	   }
	   
	   public void insert(Product s) {
	      open();
	      //String sql = "INSERT INTO student(username, univ, birth, email) values(?,?,?,?);";//error 발생
	      String sql = "INSERT INTO student(id, name, maker, price) " +
	               "values(?,?,?,?)";//error 발생
	      
	      try {
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, s.getId());
	         pstmt.setString(2, s.getName());
	         pstmt.setString(3, s.getMaker());
	         pstmt.setInt(4, s.getPrice());
	         
	         pstmt.executeUpdate();
	      } catch(Exception e) {
	         e.printStackTrace();
	      } finally {
	         close();
	      }
	   }
	   
	   public List<Product> getAll() {
	      open();
	      List<Product> products = new ArrayList<>();
	      
	      try {
	         //pstmt = conn.prepareStatement("select * from student;");//error 발생
	         pstmt = conn.prepareStatement("select * from student");
	         ResultSet rs = pstmt.executeQuery();
	   
	         while(rs.next()) {
	        	 Product s = new Product();
	            s.setId(rs.getString("id"));
	            s.setName(rs.getString("name"));
	            s.setMaker(rs.getString("maker"));
	            s.setPrice(rs.getInt("price"));
	            
	            products.add(s);
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         close();
	      }
	      return products;
	   }
}
