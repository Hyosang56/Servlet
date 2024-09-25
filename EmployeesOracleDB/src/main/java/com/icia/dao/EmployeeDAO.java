package com.icia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.icia.dto.EmployeeVO;

import util.dbcon.DBManager;


public class EmployeeDAO {
	private EmployeeDAO() {
	   }

	   private static EmployeeDAO instance = 
	         new EmployeeDAO();

	   public static EmployeeDAO getInstance() {
	      return instance;
	   }

	   public List<EmployeeVO> selectAllBoards() {
	      String sql = "select * from employees order by id desc";
	      List<EmployeeVO> list = new ArrayList<EmployeeVO>();
	      Connection conn = null;
	      Statement stmt = null;
	      ResultSet rs = null;
	      try {
	         conn = DBManager.getConnection();
	         stmt = conn.createStatement();
	         rs = stmt.executeQuery(sql);
	         while (rs.next()) {
	            EmployeeVO eVo = new EmployeeVO();
	            eVo.setId(rs.getString("id"));
	            eVo.setPass(rs.getString("pass"));
	            eVo.setName(rs.getString("name"));
	            eVo.setLev(rs.getString("lev"));
	            eVo.setEnter(rs.getDate("enter"));
	            eVo.setGender(rs.getString("gender"));
	            eVo.setPhone(rs.getString("phone"));
	            list.add(eVo);
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         DBManager.close(conn, stmt, rs);
	      }
	      return list;
	   }
	   public void insertemployee(EmployeeVO eVo) {
		      String sql = "insert into employees("
		            + "id, pass, name, lev, gender,phone ) "
		            + "values(?, ?, ?, ?, ?, ?)";
		      Connection conn = null;
		      PreparedStatement pstmt = null;
		      try {
		         conn = DBManager.getConnection();
		         pstmt = conn.prepareStatement(sql);
		         pstmt.setString(1, eVo.getId());
		         pstmt.setString(2, eVo.getPass());
		         pstmt.setString(3, eVo.getName());
		         pstmt.setString(4, eVo.getLev());
		         pstmt.setString(5, eVo.getGender());
		         pstmt.setString(6, eVo.getPhone());
		         pstmt.executeUpdate();
		      } catch (SQLException e) {
		         e.printStackTrace();
		      } finally {
		         DBManager.close(conn, pstmt);
		      }      
		   }
		   
//		   public void updateReadCount(String id) {
//		      String sql = 
//		   "update employees set readcount=readcount+1 where id=?";
//		      Connection conn = null;
//		      PreparedStatement pstmt = null;
//		      try {
//		         conn = DBManager.getConnection();
//		         pstmt = conn.prepareStatement(sql);
//		         pstmt.setString(1, id);
//		         pstmt.executeUpdate();
//		      } catch (SQLException e) {
//		         e.printStackTrace();
//		      } finally {
//		         DBManager.close(conn, pstmt);
//		      }
//		   }

		   // 게시판 글 상세 내용 보기 :글번호로 찾아온다. : 실패 null,
		   public EmployeeVO selectOneemployeeById(String id) {
		      String sql = 
		            "select * from employees where id = ?";
		      EmployeeVO eVo = null;
		      Connection conn = null;
		      PreparedStatement pstmt = null;
		      ResultSet rs = null;
		      try {
		         conn = DBManager.getConnection();
		         pstmt = conn.prepareStatement(sql);
		         pstmt.setString(1, id);
		         rs = pstmt.executeQuery();
		         if (rs.next()) {
		        	 eVo = new EmployeeVO();
		        	 eVo.setId(rs.getString("id"));
			         eVo.setPass(rs.getString("pass"));
			         eVo.setName(rs.getString("name"));
			         eVo.setLev(rs.getString("lev"));
			         eVo.setEnter(rs.getDate("enter"));
			         eVo.setGender(rs.getString("gender"));
			         eVo.setPhone(rs.getString("phone"));
		         }
		      } catch (Exception e) {
		         e.printStackTrace();
		      } finally {
		         DBManager.close(conn, pstmt, rs);
		      }
		      return eVo;
		   }
		   
		   public void updateEmployee(EmployeeVO eVo) {
		      String sql = "update employees set id=?, pass=?, name=?, "
		            + "lev=?, gender=? , phone=? where id=?";
		      Connection conn = null;
		      PreparedStatement pstmt = null;
		      try {
		         conn = DBManager.getConnection();
		         pstmt = conn.prepareStatement(sql);
		         pstmt.setString(1, eVo.getId());
		         pstmt.setString(2, eVo.getPass());
		         pstmt.setString(3, eVo.getName());
		         pstmt.setString(4, eVo.getLev());
		         pstmt.setString(5, eVo.getGender());
		         pstmt.setString(6, eVo.getPhone());
		         pstmt.setString(7, eVo.getId());  // where 조건에 id 값 설정
		         pstmt.executeUpdate();
		      } catch (SQLException e) {
		         e.printStackTrace();
		      } finally {
		         DBManager.close(conn, pstmt);
		      }
		   }
		   
		   public void deleteEmployee(String id) {
		      String sql = "delete employees where id=?";
		      Connection conn = null;
		      PreparedStatement pstmt = null;
		      try {
		         conn = DBManager.getConnection();
		         pstmt = conn.prepareStatement(sql);
		         pstmt.setString(1, id);
		         pstmt.executeUpdate();
		      } catch (SQLException e) {
		         e.printStackTrace();
		      }
		   }

}
