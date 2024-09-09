package com.icia.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.icia.vo.MemberVo;

public class MemberDAO {
	private MemberDAO() {      
	   }
	   private  static MemberDAO  instance =
	         new MemberDAO();
	   
	   public static MemberDAO  getInstance()
	   {
	      return  instance;
	   }
	   
	   public Connection  getConnection() 
	            throws Exception
	   {
	      Connection  conn = null;
	      
	      Context initContext = new InitialContext();
	      Context envContext  = 
	            (Context)initContext.lookup("java:/comp/env");
	      DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
	      conn = ds.getConnection();
	      
	      return  conn ;
	   }
	   public int confirmID(String userid) {
		      int result = -1;
		      String sql = "select userid from member where userid=?";
		      Connection conn = null;
		      PreparedStatement pstmt = null;
		      ResultSet rs = null;
		      try {
		         conn = getConnection();
		         pstmt = conn.prepareStatement(sql);
		         pstmt.setString(1, userid);
		         rs = pstmt.executeQuery();
		         if (rs.next()) {
		            result = 1;
		         } else {
		            result = -1;
		         }
		      } catch (Exception e) {
		         e.printStackTrace();
		      } finally {
		         try {
		            if (rs != null)
		               rs.close();
		            if (pstmt != null)
		               pstmt.close();
		            if (conn != null)
		               conn.close();
		         } catch (Exception e) {
		            e.printStackTrace();
		         }
		      }
		      return result;
		   }//end of confirmID()
	   public int insertMember(MemberVo mVo) {
		      int result = -1;
		      String sql = "insert into member values(?, ?, ?, ?, ?, ?)";
		      Connection conn = null;
		      PreparedStatement pstmt = null;
		      try {
		         conn = getConnection();
		         pstmt = conn.prepareStatement(sql);
		         pstmt.setString(1, mVo.getName());
		         pstmt.setString(2, mVo.getUserid());
		         pstmt.setString(3, mVo.getPwd());
		         pstmt.setString(4, mVo.getEmail());
		         pstmt.setString(5, mVo.getPhone());
		         pstmt.setInt(6, mVo.getAdmin());
		         result = pstmt.executeUpdate();
		      } catch (Exception e) {
		         e.printStackTrace();
		      } finally {
		         try {
		            if (pstmt != null)
		               pstmt.close();
		            if (conn != null)
		               conn.close();
		         } catch (Exception e) {
		            e.printStackTrace();
		         }
		      }
		      return result;
		   }//end of insertMember()
}
