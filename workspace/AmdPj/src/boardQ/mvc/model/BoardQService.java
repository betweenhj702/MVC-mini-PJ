package boardQ.mvc.model;

import amd.domain.BoardQ;

public class BoardQService {
	private BoardQDAO dao;
	private static final BoardQService instance = new BoardQService();
	private BoardQService(){
		dao = new BoardQDAO();
	}
	public static BoardQService getInstance(){
		return instance; 
	}
	
	public void insertS(BoardQ boardq) {
		int maxRef = dao.getMaxRef();
		boardq.setBq_refer(maxRef+1);
		dao.insert(boardq);
	}
}
