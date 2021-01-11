package boardQ.mvc.model;

class BoardQSQL {
	static final String INSERT = 
			"insert into BOARDQ values(BOARDQ_SEQ.nextval,?,?,?,SYSDATE,?,?,?,?)";
	static final String MAX_REF ="select Max(BQ_REFER) from BOARDQ";
	static final String LIST = "select * from "
			+ "(select ROWNUM rnum, aa.* from "
			+ "(select * from BOARDQ order by BQ_REFER desc, BQ_PLACE asc) aa) "
			+ "where rnum>? and rnum<=?";
	
}
