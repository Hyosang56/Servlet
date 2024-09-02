package web.oracleex;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;

import jakarta.servlet.ServletException;

public class BBSItem {
	private int seqNo;         // 순번
    private String title;      // 제목
    private String content;    // 내용
    private String writer;     // 작성자
    private Date date;         // 저장일자
    private Time time;         // 저장시각
    public BBSItem() {
    }
    public void setSeqNo(int seqNo) {
        this.seqNo = seqNo;
    }
    public String getTitle() {
         //return toUnicode(title);
       return title;
    }
    public String getContent() {
         //return toUnicode(content);
       return content;
    }
    public String getWriter() {
         //return toUnicode(writer);
       return writer;
    }
    public Date getDate() {
         return date;
    }
    public Time getTime() {
         return time;
    }
    
    public void readDB() throws ServletException 
    {      // 데이터베이스로부터 게시글을 읽는 메서드
        Connection conn = null;
        Statement stmt = null;
        try 
        {
//           Class.forName("com.mysql.jdbc.Driver");
//           conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webdb",
//                  "root", "worldcup");
           Class.forName("oracle.jdbc.driver.OracleDriver");
           conn = DriverManager.getConnection(
                 "jdbc:oracle:thin:@localhost:1521:xe",
                     "madang", "madang");
           
           //Class.forName("org.apache.commons.dbcp.PoolingDriver");
           //conn = DriverManager.getConnection(
           //      "jdbc:apache:commons:dbcp:/webdb_pool");
           
           if (conn == null)
                throw new Exception("데이터베이스에 연결할 수 없습니다.");
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(
               "select * from bbs where seqNo = '" + seqNo + "'");
            if (rs.next()) {
                title = rs.getString("title");         // 제목
                content = rs.getString("content");     // 내용
                writer = rs.getString("writer");       // 작성자
                date = rs.getDate("wdate");            // 저장일자
                time = rs.getTime("wtime");            // 저장시각
            }
        }
        catch (Exception e) {
            throw new ServletException(e);
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
    }//end of public void readDB() 

}
