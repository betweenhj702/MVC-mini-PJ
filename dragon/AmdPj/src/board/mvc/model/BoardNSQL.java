package board.mvc.model;

public class BoardNSQL {
	final static String LIST = "select * from BOARDN order by b_SEQ desc";
	final static String INSERT = "insert into BOARDN values(BOARDN_SEQ.nextval, ?, ?, SYSDATE, 0)";
	final static String DEL = "delete from BOARDN where b_SEQ=?";
	final static String UPDATE = "Update BOARDN set bn_subject=?, bn_content=?, bn_date=SYSDATE where bn_seq=?";
	//public static String LIST_PAGE = null;
	final static String COUNT = "select BN_count from BOARDN";
	final static String SELECT_COUNT = "select count(*) from BOARDN";
	final static String CONTENT = "select * from BOARDN where BN_SEQ=?";
	final static String UPCOUNT = "update BOARDN set bn_COUNT=bn_COUNT+1 where BN_SEQ=?";
	final static String PAGE = "select * from (select ROWNUM rnum, aa.* from (select * from BOARDN order by BN_SEQ desc) aa) where rnum>? and rnum<=?";
}
