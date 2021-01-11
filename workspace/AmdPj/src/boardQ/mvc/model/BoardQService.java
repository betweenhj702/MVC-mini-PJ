package boardQ.mvc.model;

import java.util.List;

import amd.domain.BoardQ;
import boardQ.mvc.vo.BoardQVO;

public class BoardQService {
	private BoardQDAO dao;
	private static final BoardQService instance = new BoardQService();
	private BoardQService(){
		dao = new BoardQDAO();
	}
	public static BoardQService getInstance(){
		return instance; 
	}
	
	public BoardQVO list(int page, int pageSize) {
		long totalCount = dao.countRow();
		List<BoardQ> list = dao.list(page, pageSize);
		return new BoardQVO(page, totalCount, pageSize, list);
	}
	
	public void insertS(BoardQ boardq) {
		int maxRef = dao.getMaxRef();
		boardq.setBq_refer(maxRef+1);
		dao.insert(boardq);
	}

	BoardQ showContentS(bq_seq){
		dao.updateCnt(bq_seq);
		return dao.getContent(bq_seq);
	}
}
