package amd.model;

import amd.domain.Member;

public class MemberService {
	private MemberDAO dao;
	private static final MemberService instance = new MemberService();
	private MemberService() {
		dao = new MemberDAO();
	}
	public static MemberService getInstance() {
		return instance;
		
	}
	public int checkMember(String email) {
		Member m = dao.getMember(email);
		
		if(m == null) {
			return MemberSet.PASS; //중복 아이디가 없음!
		}else {
			return MemberSet.YES_ID; // 중복아이디가 있음!
		}
	}
	public Member getMember(String email) {
		return dao.getMember(email);
	}
	public Boolean join(Member m) {
		Boolean flag = dao.join(m);
		return flag;
	}
}
