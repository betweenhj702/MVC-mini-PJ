package amd.model;

class MemberSQL {

	final static String JOIN = "insert into MEMBER values(?, ?, ?, ?, ?, ?, '0')";
	final static String CHECK = "select * from MEMBER where M_EMAIL = ?";

}
