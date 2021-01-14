package board.mvc.model;

import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;

import amd.domain.BoardN;
import amd.domain.BoardQ;
import amd.domain.Member;
import board.mvc.vo.BoardNVO;
public class BoardNDAO {
	private DataSource ds;
	
	BoardNDAO(){
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			ds = (DataSource)envContext.lookup("jdbc/myoracle");
		}catch(NamingException ne) {
			System.out.println("Apache DBCP ��ü(jdbc/myoracle)�� ã�� ����");
		}
	}
	
	ArrayList<BoardN> list(){
		ArrayList<BoardN> list = new ArrayList<BoardN>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = BoardNSQL.LIST;
		try {
			con = ds.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				long bn_seq = rs.getLong(1);
				String bn_subject = rs.getString(2);
				String bn_content = rs.getString(3);
				Date bn_date = rs.getDate(4);
				int bn_count  = rs.getInt(5);
				BoardN bn = new BoardN(bn_seq, bn_subject, bn_content, bn_date, bn_count);
				list.add(bn);
			}
			System.out.println("size:"+ list.size());
			return list;
		}catch(SQLException se) {
			return null;
		}finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
	}
	
	//�߰�
	ArrayList<BoardN> list(int currentPage, int pageSize){
		ArrayList<BoardN> list = new ArrayList<BoardN>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = BoardNSQL.PAGE;
		
		int startRow = (currentPage-1)*pageSize;
		
		int endRow = currentPage*pageSize; 
		try {					
			con = ds.getConnection();						
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);						
			rs = pstmt.executeQuery();			
			while(rs.next()) {
				long bn_seq = rs.getLong("BN_SEQ");
				String bn_subject = rs.getString("BN_SUBJECT");
				String bn_content = rs.getString("BN_CONTENT");			
				Date bn_date = rs.getDate("BN_DATE");
				int bn_count = rs.getInt("BN_COUNT");
				BoardN bn = new BoardN(bn_seq, bn_subject, bn_content, bn_date, bn_count);
				list.add(bn);
			}
			return list;
		}catch(SQLException se) {
			System.out.println("SQLException : "+se);
			return null;
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
	}
	
	long getTotalCount() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = BoardNSQL.SELECT_COUNT;
		try {
			con = ds.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				long count = rs.getLong(1);
				return count;
			}else {
				return -1L;
			}
		}catch(SQLException se) {
			return -1L;
		}finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
	}
	ArrayList<BoardN> content(long seq){
		 ArrayList<BoardN> content = new ArrayList<BoardN>();
			Connection con = null;
			Statement stmt = null;
			ResultSet rs = null;
		    String sql = "select * from BOARD where BN_SEQ ="+seq+" order by BN_SEQ desc";
		    
		    try{
				con = ds.getConnection();
				stmt = con.createStatement();
				rs = stmt.executeQuery(sql);
				while(rs.next()){
					seq = rs.getLong("BN_SEQ");	
					String bn_subject = rs.getString("BN_SUBJECT");
					String bn_content = rs.getString("BN_CONTENT");
					Date bn_udate = rs.getDate("BN_DATE");
					int bn_count = rs.getInt("BN_COUNT");
					content.add(new BoardN(seq, bn_subject, bn_content, bn_udate, bn_count));
				}
				return content;
			}catch(SQLException se){
				System.out.println(se);
				return null;
			}finally{
					try{
						if(rs != null) rs.close();
						if(stmt != null) stmt.close();
						if(con != null)  con.close();
					}catch(SQLException se){}
				}  
	 }
	
	BoardN getBoard(long bn_seq) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = BoardNSQL.CONTENT;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, bn_seq);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				//long b_seq = rs.getLong(1);
				String bn_subject = rs.getString(3);
				String bn_content = rs.getString(4);
				Date bn_date = rs.getDate(5);
				int bn_count = rs.getInt(6);
				System.out.println(bn_subject);
				System.out.println(bn_content);
				System.out.println(bn_date);
				System.out.println(bn_count);
				return new BoardN(bn_seq, bn_subject, bn_content, bn_date, bn_count);
			}else {
				return null;
			}
		}catch(SQLException se) {
			System.out.println("se : "+ se);
			return null;
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
	}
	boolean update(BoardN board){
		System.out.println("asd:"+ board.getBn_content());
		System.out.println("asd:"+ board.getBn_subject());
		System.out.println("asd:"+ board.getBn_seq());
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = BoardNSQL.UPDATE;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, board.getBn_subject());
			pstmt.setString(2, board.getBn_content());
			pstmt.setLong(3, board.getBn_seq());
			System.out.println("123");
			int i = pstmt.executeUpdate();
			System.out.println("321");
			if(i>0) return true;
			else return false;
		}catch(SQLException se) {
			return false;
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
	}
	void del(long b_seq){
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = BoardNSQL.DEL;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, b_seq);
			pstmt.executeUpdate();
		}catch(SQLException se) {
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
	}

	 void upcount(long b_seq) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = BoardNSQL.UPCOUNT;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, b_seq);
			pstmt.executeUpdate();
		}catch(SQLException se) {
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
		
	}

	 boolean writeOk(BoardN board) {
			Connection con = null;
			PreparedStatement pstmt = null;
			String sql = BoardNSQL.INSERT;
			System.out.println("board sub: "+board.getBn_subject());
			System.out.println("board con: "+board.getBn_content());
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, board.getBn_subject());
				pstmt.setString(2, board.getBn_content());
				int i = pstmt.executeUpdate();
				if(i>0) return true;
				else return false;
			}catch(SQLException se) {
				System.out.println("writeOk : "+se);
				return false;
			}finally {
				try {
					if(pstmt != null) pstmt.close();
					if(con != null) con.close();
				}catch(SQLException se) {}
			}
		
	}
}
