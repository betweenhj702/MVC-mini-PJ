package boardQ.mvc.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import amd.domain.BoardQ;
import boardQ.mvc.model.BoardQService;


@WebServlet("/board_q/board_q.do")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;   
	
	public void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String m = request.getParameter("m");
		if(m != null) {
			m = m.trim();
			if(m.equals("write")) {
				write(request, response);
			}else if(m.equals("insert")) {
				insert(request,response);
			}else {
				list(request, response);
			}
		}else {
			list(request, response);
		}
	}
	
	private void list(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		
		String view = "list.jsp";
		response.sendRedirect(view);
	}
	private void write(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		
		String view = "write.jsp";
		response.sendRedirect(view);
	}
	private void insert(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		String email = request.getParameter("email");//로그인하면 email,name은 세션에서 자동으로 입력되게 할겅미
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		BoardQ boardq = new BoardQ(-1,email,subject,content,null,0,-1,0,0);
		BoardQService service = BoardQService.getInstance();
		service.insertS(boardq);
		
		//에러처리추가
		String view = "list.jsp";
		response.sendRedirect(view);
	}
	private int check(String seqStr){
		if(seqStr != null){
			seqStr = seqStr.trim();
			if(seqStr.length() != 0){
				try{
					int seq = Integer.parseInt(seqStr);
					return seq;
				}catch(NumberFormatException ne){	
				}
			}else{
			}
		}else{
		}
		return -1;
	}
}
