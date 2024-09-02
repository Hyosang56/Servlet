package bbs.oraclelist;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BBSListServletEx
 */
public class BBSListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BBSListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String strUpperSeqNo = request.getParameter("LAST_SEQ_NO");
        int upperSeqNo;
        if (strUpperSeqNo == null)
            upperSeqNo = Integer.MAX_VALUE;
        else
            upperSeqNo = Integer.parseInt(strUpperSeqNo);
        BBSList list = readDB(upperSeqNo);
        request.setAttribute("BBS_LIST", list);
        //RequestDispatcher dispatcher = request.getRequestDispatcher("WebTemplate.jsp?BODY_PATH=BBSListView.jsp");
        RequestDispatcher dispatcher = 
              request.getRequestDispatcher("BBSListView.jsp");
        dispatcher.forward(request, response);
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}// end of doGet()
	
	
	private BBSList readDB(int upperSeqNo) throws ServletException {     // 데이터베이스로부터 게시글 목록을 읽는 메서드
        BBSList list = new BBSList();
        Connection conn = null;
        Statement stmt = null;
        final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
        final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:xe";
        
        try {            
           Class.forName(JDBC_DRIVER);
         conn = DriverManager.getConnection(JDBC_URL,"madang","madang");
         
            if (conn == null)
                throw new Exception("데이터베이스에 연결할 수 없습니다.");
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from bbs where seqNo <"+
            upperSeqNo+" order by seqNo desc");
            
            for (int cnt = 0; cnt < 5; cnt++) {
                if (!rs.next())
                    break;
                list.setSeqNo(cnt, rs.getInt("seqNo"));
                list.setTitle(cnt, rs.getString("title"));
                list.setWriter(cnt, rs.getString("writer"));
                list.setDate(cnt, rs.getDate("wdate"));
                list.setTime(cnt, rs.getTime("wtime"));
            }
            if (!rs.next())
                list.setLastPage(true);
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
        return list;
          }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
