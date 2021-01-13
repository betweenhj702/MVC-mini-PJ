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
 		/* �ֹ��������� ǥ���� ����
 	 	������ : VO�� ��� ��������
 			
 			1)������Ʈ�� ����� ��ٱ��� c_seq >> �̹����̸�����/����,  
 				: select p.* from PRODUCT p join CART c on p.P_CODE = (select P_CODE from CART where C_SEQ = ?)
 				  select * from CART where M_EMAIL = ? and C_VALID=?
 				
 				>> ���� �� Product product + Cart cart
 				  
 			2)���ǿ� ����� m_email >> �̸� ���� ��ȭ��ȣ �ּ�
 				: select * from Member where M_EMAIL = ?
 				
 				>> �� �� Member member , pwd�� �η�.
 		*/
 		
 		
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
 		
 		String view = "";
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
