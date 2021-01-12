package member.mvc.model;

class MemberSQL {

	final static String JOIN = "insert into MEMBER values(?, ?, ?, ?, ?, ?, '0')";
	final static String CHECK = "select * from MEMBER where M_EMAIL = ?";
	final static String EDIT = "update MEMBER set M_NAME=?, M_PHONE=?, M_EMAIL=?, M_ADDR=?, M_ADDR2=?";
	final static String EDITPWD = "update MEMBER set M_PWD=? where M_ID=?";

}
