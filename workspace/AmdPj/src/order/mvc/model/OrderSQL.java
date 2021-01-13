package order.mvc.model;

class OrderSQL {
	final static String PRODUCT_IN_CART = "select p.* from PRODUCT p"
			+ " join CART c on p.P_CODE = (select P_CODE from CART where C_SEQ = ?)";
	final static String INFO_CART = "select * from CART where M_EMAIL=? and C_VALID=?";
	final static String INFO_MEMBER = "select * from Member where M_EMAIL = ?";
	final static String INSERT_ORD = "insert into ORD "
			+ "values(ORD_SEQ.nextval, ?, SYSDATE, ?, ?, ?, ?)";
	final static String UPDATE_CART = "update CART set C_VALID ='n' where C_SEQ = ?";
}