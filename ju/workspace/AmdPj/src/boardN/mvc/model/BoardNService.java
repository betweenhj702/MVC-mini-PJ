package boardN.mvc.model;

import java.util.ArrayList;
import java.util.List;

import amd.domain.BoardN;

import amd.domain.Member;
import boardN.mvc.vo.BoardNVO;

public class BoardNService {
	private BoardNDAO dao;
	private static final BoardNService instance = new BoardNService();
	private BoardNService() {
		dao = new BoardNDAO();
	}
	public static BoardNService getInstance() {
		return instance;
	}
	public BoardNVO getboardNVO(int cp, int ps) {
		ArrayList<BoardN> list = dao.list(cp, ps);
		long totalCount = dao.getTotalCount();
		BoardNVO bn = new BoardNVO(cp, totalCount, ps, list);
		return bn;
	}
	
	public void insertS(BoardN boardN) {
		dao.insert(boardN);
	}
	
	public BoardN getBoardNS(long bn_seq) {
		return dao.getBoardN(bn_seq);
	}
	
}
