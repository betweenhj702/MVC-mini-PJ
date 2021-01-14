package boardN.mvc.model;

public class BoardNSQL {
	
	final static String LIST_PAGE
	="select * from (select ROWNUM rnum, aa.* from (select * from BOARDN order by BN_SEQ desc) aa) where rnum>? and rnum<=?";
	final static String COUNT="select max(ROWNUM) from BOARDN";
	final static String INSERT="insert into BOARDN values(BOARDN_SEQ.nextval, ?,?,?,SYSDATE,0)";
	final static String CONTENT="select * from BOARDN where BN_SEQ=?";
}
