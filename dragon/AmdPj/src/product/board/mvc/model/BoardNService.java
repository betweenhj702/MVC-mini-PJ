package board.mvc.model;

import java.util.ArrayList;
import java.util.List;

import board.mvc.vo.BoardNVO;
import amd.domain.BoardN;

import amd.domain.Member;

public class BoardNService {
	private BoardNDAO dao;
	private static final BoardNService instance = new BoardNService();
	private BoardNService() {
		dao = new BoardNDAO();
	}
	public static BoardNService getInstance() {
		return instance;
	}
	public BoardNVO getListResult(int currentPage, int pageSize) {
		System.out.println("");
		ArrayList<BoardN> list = dao.list(currentPage, pageSize);
		long totalCount = dao.getTotalCount();
		return new BoardNVO(currentPage, totalCount, pageSize, list);
	}
	public ArrayList<BoardN> listS(){
		return dao.list();
	}
	public ArrayList<BoardN> contentS(long seq){
		return dao.content(seq);
	}
	public BoardN getBoardS(long seq) {
		return dao.getBoard(seq);
	}
	public boolean updateS(BoardN board){
		return dao.update(board);
	}
	public void delS(long seq){
		dao.del(seq);
	}
	public void upcountS(long seq) {
		dao.upcount(seq);	
	}
	public boolean writeOk(BoardN board) {
		return dao.writeOk(board);
	}
}
