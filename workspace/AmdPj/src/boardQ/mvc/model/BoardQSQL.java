package boardQ.mvc.model;

class BoardQSQL {
	static final String INSERT = 
			"insert into BOARDQ values(BOARDQ_SEQ.nextval,?,?,?,SYSDATE,?,?,?,?)";
	static final String MAX_REF ="select Max(BQ_REFER) from BOARDQ";
	static final String LIST = "select * from "
			+ "(select ROWNUM rnum, aa.* from "
			+ "(select * from BOARDQ order by BQ_REFER desc, BQ_PLACE asc) aa) "
			+ "where rnum>? and rnum<=?";
	static final String COUNT = "select count(BQ_SEQ) from BOARDQ";
	static final String BQ_NAME = "select m.M_NAME from MEMBER m join BOARDQ b on m.M_EMAIL= b.M_EMAIL"
			+ " where b.BQ_SEQ = ?";
	
	static final String UPDATECNT = "update BOARDQ set BQ_COUNT += 1 where BQ_SEQ = ?";
	static final String CONTENT = "select * from BOARDQ where BQ_SEQ = ?";
}
