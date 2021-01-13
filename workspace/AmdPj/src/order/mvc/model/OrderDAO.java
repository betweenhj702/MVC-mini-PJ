package order.mvc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

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
	
	ArrayList<Product> showProductInCart(){
		String sql = PRODUCT_IN_CART;
		ArrayList<Product> listP = new ArrayList<Product>();
		ResultSet rs = null;
		
		return null;
	}
	
	ArrayList<Cart> showCartInfo(){
		return null;
	}
	
	Member showOrderer() {
		return null;
	}
	
	void insertOrd() {
		
	}
	
	void updateCartValid() {
		
	}
	
	
	
}
