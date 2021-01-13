package board.mvc.control;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.mvc.model.BoardNService;
import board.mvc.vo.BoardNVO;
import boardQ.mvc.model.BoardQService;
import amd.domain.BoardN;
import amd.domain.BoardQ;
import amd.domain.Member;


@WebServlet("/board/board.do")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	public void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String m = request.getParameter("m");
		if(m != null) {
			m = m.trim();
			switch (m) {
				case "write": write(request, response); break;
				case "writeOk": System.out.println("writeOk in"); writeOk(request, response); break;
				case "content": System.out.println("in"); content(request, response);break;
				case "update": getBoard(request, response, "update"); break;
				case "updateOk": updateOk(request, response); break;
				case "delete": del(request, response); break;
				case "upcount": upcountS(request, response); break;
				
				default: list(request, response); break;
			}
		}else {
			list(request, response); 
		}
	}

	
	public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cpStr = request.getParameter("cp");
		String psStr = request.getParameter("ps");
		HttpSession session = request.getSession();
	
		
		
		int cp = 1;
		System.out.println("3");
		if(cpStr == null) {
			Object cpObj = session.getAttribute("cp");
			if(cpObj != null) {
				cp = (Integer)cpObj;
			}
		}else {
			cpStr = cpStr.trim();
			cp = Integer.parseInt(cpStr);
		}
		session.setAttribute("cp", cp);
		
		//(2) ps 
		int ps = 3;
		if(psStr == null) {
			Object psObj = session.getAttribute("ps");
			if(psObj != null) {
				ps = (Integer)psObj;
			}
		}else {
			psStr = psStr.trim();
			int psParam = Integer.parseInt(psStr);
			
			Object psObj = session.getAttribute("ps");
			if(psObj != null) {
				int psSession = (Integer)psObj;
				if(psSession != psParam) {
					cp = 1;
					session.setAttribute("cp", cp);
				}
			}else {
				if(ps != psParam) {
					cp = 1;
					session.setAttribute("cp", cp);
				}
			}
			
			ps = psParam;
		}
		session.setAttribute("ps", ps);
		
		BoardNService service = BoardNService.getInstance();
		BoardNVO boardnvo = service.getListResult(cp, ps);	
		request.setAttribute("BoardNVO", boardnvo);		
		if(boardnvo.getList().size() == 0 && cp>1) {
			response.sendRedirect("board.do?m=list&cp="+(cp-1));
		}else {
			String view = "list.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request, response);
		}
	}
	// 공지게시판 글쓰기 폼
	public void write(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = "write.jsp";
		response.sendRedirect(view);
	}	
	
	public void writeOk(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bn_subject = request.getParameter("title");
		String bn_content = request.getParameter("content");
		
		System.out.println(bn_subject);
		
		System.out.println(bn_content);
		
		BoardNService service = BoardNService.getInstance();
		boolean flag = service.writeOk(new BoardN(-1, bn_subject, bn_content, null,-1));
		request.setAttribute("result", flag);
		request.setAttribute("kind", "writeOk");
		
		String view = "msg.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	
	public void getBoard(HttpServletRequest request, HttpServletResponse response, String view)
			throws ServletException, IOException {
		long seq = getSeq(request);
		if(seq != -1L) {
			BoardNService service = BoardNService.getInstance();
			BoardN board = service.getBoardS(seq);
			request.setAttribute("board", board);
			
			RequestDispatcher rd = request.getRequestDispatcher(view+".jsp");
			rd.forward(request, response);
		}else {
			response.sendRedirect("board.do");
		}
	}
	
	public void updateOk(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long b_seq = getSeq(request);
		System.out.println("b_seq:" + b_seq);
		String b_subject = request.getParameter("title");
		String b_content = request.getParameter("content");
		
	
		
		BoardNService service = BoardNService.getInstance();
		boolean flag = service.updateS(new BoardN(b_seq, b_subject, b_content, null,-1));
		request.setAttribute("result", flag);
		request.setAttribute("kind", "updateOk");
		
		String view = "msg.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	
	private void content(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
    	BoardNService service = BoardNService.getInstance();
		String seqStr =  request.getParameter("seq");
		if(seqStr != null) seqStr = seqStr.trim();
		long seq = Long.parseLong(seqStr);
		
		
		ArrayList<BoardN> contents = service.contentS(seq);
		request.setAttribute("contents", contents);
		
		String view = "content.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(view);
        rd.forward(request, response);
        
        service.upcountS(seq);
    }
	
	public void del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long seq = getSeq(request);
		if(seq != -1L) {
			BoardNService service = BoardNService.getInstance();
			service.delS(seq);
		}
		response.sendRedirect("board.do");
	}
	
	private long getSeq(HttpServletRequest request) {
		long seq = -1L;
		String seqStr = request.getParameter("seq");
		if(seqStr != null) {
			seqStr = seqStr.trim();
			try {
				seq = Long.parseLong(seqStr);
			}catch(NumberFormatException ne) {
			}
		}
		
		return seq;
	}
	
	private void upcountS(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		long seq = getSeq(request);
		System.out.println("123");
		if(seq != -1L) {
			BoardNService service = BoardNService.getInstance();
			System.out.println("321");
			service.upcountS(seq);
		}
		response.sendRedirect("board.do");
		
	}
}
