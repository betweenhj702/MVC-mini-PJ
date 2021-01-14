package order.mvc.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import amd.domain.Member;
import order.mvc.model.OrderService;
import order.mvc.vo.OrderVO;


@WebServlet("/order/order.do")
public class OrderContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private OrderService service = OrderService.getInstance();
	private String m ="";
 	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		m = request.getParameter("m");
		if(m != null) {
			m=m.trim();
			switch(m) {
			case "insertOrd" : insertOrd(request,response);break;
			case "listOrd" : listOrd(request,response);break;
			default: moveOrdPage(request, response);
			}
		}else {
			moveOrdPage(request, response);
		}
	}
 	private void moveOrdPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		/* 주문페이지에 표시할 내역 	
 	 	리스팅 : VO로 묶어서 전달하자
 			1)세션에 저장된 장바구니 email >> 이미지이름가격/수량,  
 				>> 여러 개  Cart cart
 			2)세션에 저장된 m_email >> 이름 메일 전화번호 주소
 				: select * from Member where M_EMAIL = ?
 				>> 한 개 Member member , pwd는 널로.
 		*/
 		HttpSession session = request.getSession();
 		Member member = (Member)session.getAttribute("loginUser");
 		String m_email = member.getM_email();
 		
 		OrderVO orderVO = service.showOrderPage(m_email);
 		request.setAttribute("orderVO", orderVO);
 		
 		String view = "order.jsp";
 		RequestDispatcher rd = request.getRequestDispatcher(view);
 		rd.forward(request, response);
 	}
 	
 	private void insertOrd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		/* 결제버튼을 누를 떄
 		1. 인서트 주문테이블
 			insert into ORD values(ORD_SEQ.nextval, ?, SYSDATE, ?, ?, ?, ?)
 		
 		2. 업데이트 카트
 			update CART set C_VALID ='n' where C_SEQ = ?
 		*/
 		
 		
 		String view = "order.do?m=listOrd";
 		RequestDispatcher rd = request.getRequestDispatcher(view);
 		rd.forward(request, response);
 	}
 	
 	private void listOrd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		/* 구매내역을 누를 때
 		 리스트  select 
 		*/
 		String view = "list.jsp";
 		RequestDispatcher rd = request.getRequestDispatcher(view);
 		rd.forward(request, response);
 	}
 	
}
