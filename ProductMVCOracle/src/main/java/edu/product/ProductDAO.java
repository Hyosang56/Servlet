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
	
	List<Product> products = new ArrayList<>();
	
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
	   
	   public void insert(Product p) {
	      open();
	      //String sql = "INSERT INTO student(username, univ, birth, email) values(?,?,?,?);";//error 발생
	      String sql = "INSERT INTO product( name, maker, price, makedate) " +
	               "values(?,?,?,?)";//error 발생
	      
	      try {
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, p.getName());
	         pstmt.setString(2, p.getMaker());
	         pstmt.setInt(3, p.getPrice());
	         pstmt.setDate(4, p.getMakedate());
	         
	         
	         pstmt.executeUpdate();
	      } catch(Exception e) {
	         e.printStackTrace();
	      } finally {
	         close();
	      }
	   }
	   
	   public List<Product> getAll() {
	      open();
	      
	      
	      try {
	         //pstmt = conn.prepareStatement("select * from student;");//error 발생
	         pstmt = conn.prepareStatement("select * from product");
	         ResultSet rs = pstmt.executeQuery();
	   
	         while(rs.next()) {
	        	 Product p = new Product();
	            p.setId(rs.getInt("id"));
	            p.setName(rs.getString("name"));
	            p.setMaker(rs.getString("maker"));
	            p.setPrice(rs.getInt("price"));
	            p.setMakedate(rs.getDate("makedate"));
	            
	            products.add(p);
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         close();
	      }
	      return products;
	   }
	   
}
