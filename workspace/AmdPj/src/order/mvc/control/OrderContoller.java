package order.mvc.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OrderContoller
 */
@WebServlet("/order/order.do")
public class OrderContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
 			
 			1)리퀘스트에 저장된 장바구니 c_seq >> 이미지이름가격/수량,  
 				: select p.* from PRODUCT p join CART c on p.P_CODE = (select P_CODE from CART where C_SEQ = ?)
 				  select * from CART where M_EMAIL = ? and C_VALID=?
 				
 				>> 여러 개 Product product + Cart cart
 				  
 			2)세션에 저장된 m_email >> 이름 메일 전화번호 주소
 				: select * from Member where M_EMAIL = ?
 				
 				>> 한 개 Member member , pwd는 널로.
 		*/
 		
 		
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
 		
 		String view = "";
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
