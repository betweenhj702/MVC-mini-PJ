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
			return MemberSet.PASS; //�ߺ� ���̵� ����!
		}else {
			return MemberSet.YES_ID; // �ߺ����̵� ����!
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
