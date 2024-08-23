package com.webdb;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import jakarta.servlet.ServletException;

public class TblRegister implements Serializable{
	ArrayList<TblRegister>  member = null ;
	   
	   private String id;
	   private String passwd;
	   private String name;
	   private String num1;
	   private String num2;
	   private String email;
	   private String phone;
	   private String zipcode;
	   private String address;
	   private String job;
	   
	   private static int counter ;
	   //정적 초기화 블록
	   static {
	      counter = 0;
	   }
	   
	   static public void setCounter(int pcount)
	   {
	      counter = pcount;
	   }
	   static public int getCounter()
	   {
	      return counter ;
	   }
	   
	   public void setId(String id) {
	      this.id = id;
	   }
	   public void setPwd(String pwd) {
	      this.passwd = pwd;
	   }
	   public void setName(String name) {
	      this.name = name;
	   }
	   public void setNum1(String num1) {
	      this.num1 = num1;
	   }
	   public void setNum2(String num2) {
	      this.num2 = num2;
	   }
	   public void setEmail(String email) {
	      this.email = email;
	   }
	   public void setPhone(String phone) {
	      this.phone = phone;
	   }
	   public void setZipcode(String zipcode) {
	      this.zipcode = zipcode;
	   }
	   public void setAddress(String address) {
	      this.address = address;
	   }
	   public void setJob(String job) {
	      this.job = job;
	   }
	   public String getId() {
	      return id;
	   }
	   public String getPwd() {
	      return passwd;
	   }
	   public String getName() {
	      return name;
	   }
	   public String getNum1() {
	      return num1;
	   }
	   public String getNum2() {
	      return num2;
	   }
	   public String getEmail() {
	      return email;
	   }
	   public String getPhone() {
	      return phone;
	   }
	   public String getZipcode() {
	      return zipcode;
	   }
	   public String getAddress() {
	      return address;
	   }
	   public String getJob() {
	      return job;
	   }
	   
	   public ArrayList<TblRegister> readDB() throws ServletException 
	   {      
	      // 데이터베이스로부터 게시글을 읽는 메서드
	      Connection conn = null;
	        Statement stmt = null;
	        member = new ArrayList<>();
	                
	        try {
	           Class.forName("com.mysql.cj.jdbc.Driver");
	         conn = DriverManager.getConnection(
	   "jdbc:mysql://localhost:3306/webdb?useSSL=false&serverTimezone=Asia/Seoul", "root","1234");
	         if(conn == null)
	            throw new Exception("<h1>DB에 연결불가<BR>");
	            
	            stmt = conn.createStatement();
	            ResultSet  rs = 
	   stmt.executeQuery(
	         "select * from tblRegister;");
	            while(rs.next())
	            {
	            	TblRegister  ob =
	                     new TblRegister();
	               ob.setId(rs.getString("id"));
	               ob.setPwd(rs.getString("passwd"));
	               ob.setName(rs.getString("name"));
	               ob.setNum1(rs.getString("num1"));
	               ob.setNum2(rs.getString("num2"));
	               ob.setEmail(rs.getString("email"));
	               ob.setPhone(rs.getString("phone"));
	               ob.setZipcode(rs.getString("zipcode"));
	               ob.setAddress(rs.getString("address"));
	               ob.setJob(rs.getString("job"));
	               
	               member.add(ob);
	               counter++;
	            }//end of while(rs.next())
	        }//end of try
	        catch(Exception  e) {
	           throw new ServletException(e);
	        }
	        finally {
	           try { stmt.close(); }
	           catch(Exception  e) { }
	           try { conn.close();}
	           catch(Exception  e) {  }
	        }
	        return  member ;
	   }//end of readDB()
}
