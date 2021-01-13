package order.mvc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import amd.domain.Cart;
import amd.domain.Member;
import amd.domain.Product;
import static order.mvc.model.OrderSQL.*;

class OrderDAO {
	private DataSource ds;
	private Connection con;
	private PreparedStatement pstmt;
	private Statement stmt;
	
	OrderDAO(){	
		try {
			Context initContext = new InitialContext();
		    Context envContext  = (Context)initContext.lookup("java:/comp/env");
		    ds = (DataSource)envContext.lookup("jdbc/myoracle");
		}catch(NamingException ne) {
		}
	}
	
//	"select p.* from PRODUCT p"
//	+ " join CART c on p.P_CODE = (select P_CODE from CART where C_SEQ = ?)";
//	"select * from CART where M_EMAIL=? and C_VALID=?";
	
	ArrayList<Product> showProductInCart(int c_seq){
		String sql = PRODUCT_IN_CART;
		ArrayList<Product> listP = new ArrayList<Product>();
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, c_seq);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int p_code = rs.getInt("P_CODE");
				String p_type = rs.getString("P_TYPE");
				String p_name = rs.getString("P_NAME");
				int p_price = rs.getInt("P_PRICE");
				String p_img = rs.getString("P_IMG");
				String p_info = rs.getString("P_INFO");
				Product product = new Product(p_code, p_type, p_name, p_price, p_img, p_info);
				listP.add(product);
			}
			return listP;
		}catch(SQLException se) {
			System.out.println(se);
			return null;
		}finally {
			try{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se){
			}
		}
	}
	
	ArrayList<Cart> showCartInfo(String m_email, String c_valid){
		String sql = INFO_CART;
		ArrayList<Cart> listC = new ArrayList<Cart>();
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m_email);
			pstmt.setString(2, c_valid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int p_code = rs.getInt("P_CODE");
				String p_type = rs.getString("P_TYPE");
				String p_name = rs.getString("P_NAME");
				int p_price = rs.getInt("P_PRICE");
				String p_img = rs.getString("P_IMG");
				String p_info = rs.getString("P_INFO");
				Cart cart = new Product(p_code, p_type, p_name, p_price, p_img, p_info);
				listC.add(cart);
			}
			return listP;
		}catch(SQLException se) {
			System.out.println(se);
			return null;
		}finally {
			try{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se){
			}
		}
	}
	
	Member showOrderer() {
		return null;
	}
	
	void insertOrd() {
		
	}
	
	void updateCartValid() {
		
	}
	
	
	
}
