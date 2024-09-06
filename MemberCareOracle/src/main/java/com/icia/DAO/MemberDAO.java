package com.icia.DAO;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

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
}
