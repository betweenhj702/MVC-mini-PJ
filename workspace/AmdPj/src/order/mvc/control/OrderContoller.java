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
 		/* �ֹ��������� ǥ���� ���� 	
 	 	������ : VO�� ��� ��������
 			1)���ǿ� ����� ��ٱ��� email >> �̹����̸�����/����,  
 				>> ���� ��  Cart cart
 			2)���ǿ� ����� m_email >> �̸� ���� ��ȭ��ȣ �ּ�
 				: select * from Member where M_EMAIL = ?
 				>> �� �� Member member , pwd�� �η�.
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
 		/* ������ư�� ���� ��
 		1. �μ�Ʈ �ֹ����̺�
 			insert into ORD values(ORD_SEQ.nextval, ?, SYSDATE, ?, ?, ?, ?)
 		
 		2. ������Ʈ īƮ
 			update CART set C_VALID ='n' where C_SEQ = ?
 		*/
 		
 		
 		String view = "order.do?m=listOrd";
 		RequestDispatcher rd = request.getRequestDispatcher(view);
 		rd.forward(request, response);
 	}
 	
 	private void listOrd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		/* ���ų����� ���� ��
 		 ����Ʈ  select 
 		*/
 		String view = "list.jsp";
 		RequestDispatcher rd = request.getRequestDispatcher(view);
 		rd.forward(request, response);
 	}
 	
}
