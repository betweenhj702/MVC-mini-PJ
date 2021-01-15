package order.mvc.model;



class OrderSQL {
	final static String PRODUCT_IN_CART = "select p.* from PRODUCT p"
			+ " join CART c on p.P_CODE = any(select P_CODE from CART where C_SEQ = "
			+ "any(select C_SEQ from CART c join Member m on c.M_EMAIL = ? and c.C_VALID='Y'))";
	final static String INFO_CART = "select c.C_SEQ, c.M_EMAIL, c.P_CODE, p.P_NAME, p.P_PRICE, p.P_IMG, c.C_AMOUNT, c.C_VALID from CART c, PRODUCT p where c.P_CODE = p.P_CODE and c.M_EMAIL=? and c.C_VALID='Y' order by c.P_CODE";
			//"select p.P_NAME, p.P_PRICE, p.P_IMG, c.C_SEQ, c.C_AMOUNT from PRODUCT p join CART c on p.P_CODE = any(select P_CODE from CART where C_SEQ = any(select C_SEQ from CART where M_EMAIL = ? and C_VALID='Y'))";
	final static String INFO_MEMBER = "select * from Member where M_EMAIL = ?";
	final static String INSERT_ORD = "insert into ORD "
			+ "values(ORD_SEQ.nextval, ?, SYSDATE, ?, ?, ?, ?, ?)";
	final static String UPDATE_CART = "update CART set C_VALID ='N' where M_EMAIL = ? and C_VALID = 'Y'";
	final static String SELECT_CART_NO = "select c.C_SEQ, c.M_EMAIL, c.P_CODE, p.P_NAME, p.P_PRICE, p.P_IMG, c.C_AMOUNT, c.C_VALID from CART c, PRODUCT p where c.P_CODE = p.P_CODE and c.M_EMAIL=? and c.C_VALID='N' order by c.P_CODE";
			//"select p.P_NAME, p.P_PRICE, p.P_IMG, c.C_SEQ, c.C_AMOUNT from PRODUCT p join CART c on p.P_CODE = any(select P_CODE from CART where C_SEQ = any(select C_SEQ from CART where M_EMAIL = ? and C_VALID='N'))";
}
