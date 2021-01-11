package boardQ.mvc.model;

import java.sql.*;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import amd.domain.BoardQ;
import static boardQ.mvc.model.BoardQSQL.*;

class BoardQDAO {
	
	private DataSource ds;
	Connection con;
	PreparedStatement pstmt;
	Statement stmt;
	
	BoardQDAO(){	
		try {
			Context initContext = new InitialContext();
		    Context envContext  = (Context)initContext.lookup("java:/comp/env");
		    ds = (DataSource)envContext.lookup("jdbc/myoracle");
		}catch(NamingException ne) {
		}
	}
	ArrayList<BoardQ> list(int page, int pageSize){
		String sql = LIST;
		ResultSet rs = null;
		int initRow = (page-1)*pageSize;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, initRow);
			pstmt.setInt(2, initRow + pageSize);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int bq_seq = rs.getInt("BQ_SEQ");
				String m_email = rs.getString("M_EMAIL");
				String bq_subject = rs.getString("BQ_SUBJECT");
				String bq_content = rs.getString("BQ_CONTENT");
				Date bq_rdate = rs.getDate("RDATE");
				int bq_count = rs.getInt("BQ_COUNT");
				int bq_refer = rs.getInt("BQ_REFER");
				int bq_lev = rs.getInt("BQ_LEV");
				int bq_place = rs.getInt("BQ_PLACE");
				BoardQ boardq = new BoardQ(bq_seq, m_email, bq_subject, bq_content, bq_rdate, bq_count,
						bq_refer, bq_lev, bq_place);
				
			}
		}catch(SQLException se) {
			System.out.println(se);
		}finally {
			try{
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se){
			}
		}
		return null;
	}
	void insert(BoardQ boardQ) {
		String sql = INSERT; //insert into BOARDQ values(BOARD_SEQ.nextval,?,?,?,SYSDATE,?,?,?,?)
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, boardQ.getM_email());
			pstmt.setString(2, boardQ.getBq_subject());
			pstmt.setString(3, boardQ.getBq_content());
			pstmt.setInt(4, boardQ.getBq_count());
			pstmt.setInt(5, boardQ.getBq_refer());
			pstmt.setInt(6, boardQ.getBq_lev());
			pstmt.setInt(7, boardQ.getBq_place());
			pstmt.executeUpdate();
		}catch(SQLException se) {
			System.out.println(se);
		}finally {
			try{
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se){
			}
		}
	}
	
	int getMaxRef() {
		String sql = MAX_REF;
		ResultSet rs = null;
		int maxRef = 0;
		try {
			con = ds.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) maxRef = rs.getInt(1);
			return maxRef;
		}catch(SQLException se) {
			System.out.println(se);
			return -1;
		}finally {
			try{
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(con != null) con.close();
			}catch(SQLException se){
			}
		}
	}
}
