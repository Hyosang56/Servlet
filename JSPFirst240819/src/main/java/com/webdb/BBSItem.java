package com.webdb;

import java.sql.Statement;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Time;

import jakarta.servlet.ServletException;

public class BBSItem implements Serializable{
   private int seqNo;         // 순번
    private String title;      // 제목
    private String content;    // 내용
    private String writer;     // 작성자
    private Date date;         // 저장일자
    private Time time;         // 저장시각
    
    public BBSItem() {
    }

   public int getSeqNo() {
      return seqNo;
   }

   public void setSeqNo(int seqNo) {
      this.seqNo = seqNo;
   }

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public String getContent() {
      return content;
   }

   public void setContent(String content) {
      this.content = content;
   }

   public String getWriter() {
      return writer;
   }

   public void setWriter(String writer) {
      this.writer = writer;
   }

   public Date getDate() {
      return date;
   }

   public void setDate(Date date) {
      this.date = date;
   }

   public Time getTime() {
      return time;
   }

   public void setTime(Time time) {
      this.time = time;
   }
    public void readDB() throws ServletException
    {
       Connection conn = null;
        Statement stmt = null;
        try {
              Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 드라이버 로드
           conn = DriverManager.getConnection(
"jdbc:mysql://localhost:3306/webdb?useSSL=false&serverTimezone=Asia/Seoul", "root", "1234"); // JDBC 연결
            if (conn == null)
                throw new Exception("데이터베이스에 연결할 수 없습니다.");
            stmt = (Statement)conn.createStatement();
            ResultSet rs = stmt.executeQuery(
           "select * from bbs where seqNo ='"+seqNo+"';");
            
            if (rs.next()) {
                this.title = rs.getString("title");         // 제목
                this.content = rs.getString("content");     // 내용
                this.writer = rs.getString("writer");       // 작성자
                this.date = rs.getDate("wdate");            // 저장일자
                this.time = rs.getTime("wtime");            // 저장시각
            }
        }//END OF try 블럭
        catch (Exception e) {
            throw new ServletException(e);
          // throw new Exception(e);
        }
        finally {
            try { 
                stmt.close();
            } 
            catch (Exception ignored) {
            }
            try { 
                conn.close();
            } 
            catch (Exception ignored) {
            }
        }
    }
}