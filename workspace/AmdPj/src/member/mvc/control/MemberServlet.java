package member.mvc.control;

import java.io.IOException;
import java.sql.Date;
import java.text.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import amd.domain.Member;
import member.mvc.model.MemberService;
import member.mvc.model.MemberSet;

@WebServlet("/member/member.do")
	public class MemberServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;
	       
		private String m = "";
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		m = request.getParameter("m");
		if(m != null) {
			m = m.trim();
			switch(m) {
				case "form": form(request, response); break;
				case "check": check(request, response); break;
				case "join": join(request, response); break;
	
				default: response.sendRedirect("../index.jsp");
			}
		}else {
			response.sendRedirect("../index.do");
		}
	}
	private void form(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = "join.jsp";
		response.sendRedirect(view);
	}
	private void check(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		String email = request.getParameter("email");
	    if(email != null) email = email.trim();
	    
	    MemberService service = MemberService.getInstance();
	    int rCode = service.checkMember(email);
	    request.setAttribute("rCode", rCode);
	    if(rCode==MemberSet.PASS) {
	    	HttpSession session = request.getSession();
	    	//Member m = service.getMemberS(id);
	    	session.setAttribute("id", email);
	    }
	    
	    String referer = request.getHeader("Referer");
		request.getSession().setAttribute("redirectURI", referer);
	}
	
	private void join(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		String email = request.getParameter("email");
	    String pwd = request.getParameter("pwd");
	    String name = request.getParameter("name");
	    String phone = request.getParameter("phone");
	    String addr = request.getParameter("addr");
	    String addr2 = request.getParameter("addr2");
	    if(email != null) email = email.trim();
	    if(pwd != null) pwd = pwd.trim();
	    if(name != null) name = name.trim();
	    if(phone != null) phone = phone.trim();
	    if(addr != null) addr = addr.trim();
	    if(addr2 != null) addr2 = addr2.trim();
	    
	    System.out.println(email+pwd+name+phone+addr+addr2);
	    MemberService service = MemberService.getInstance();
	    Member member = new Member(email, pwd, name, phone, addr, addr2, null);
	    Boolean rCode = service.join(member);
	    
	
	    if(rCode) {
	    	member.setM_pwd("");
	    	HttpSession session = request.getSession();
		    session.setAttribute("member", member);
		    String view = "welcome.jsp";
			response.sendRedirect(view);
	    }else {
	    	System.out.println("ȸ������ ����");
	    }
	}
	private void welcome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String view = "welcome.jsp";
		response.sendRedirect(view);
	}
	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String email = null;
		Boolean uCode = false;
		Member m = (Member)session.getAttribute("loginUser");
		if(m!=null) {
			email = m.getM_email();
		}
		if(email!=null) {
			uCode = true;
			session.setAttribute("uCode", uCode);
			
		}else {
			session.setAttribute("uCode", uCode);
		}
		String view = "fail.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	
	private void goUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String view = "edit.jsp";
		response.sendRedirect(view);
	}
		

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Boolean upCode = false; // update ��������
		
		String id = request.getParameter("id");
	    String pwd = request.getParameter("pwdcheck"); // ���Ȯ�ζ�
	    String name = request.getParameter("name");
	    String birthStr = request.getParameter("birth");
	    String email = request.getParameter("email");
	    String phone = request.getParameter("phone");
	    String addr = request.getParameter("addr");
	    String addr2 = request.getParameter("addr2");
	    if(id != null) id = id.trim();
	    if(pwd != null) pwd = pwd.trim();
	    if(name != null) name = name.trim();
	    if(birthStr != null) birthStr = birthStr.trim();
	    if(email != null) email = email.trim();
	    if(phone != null) phone = phone.trim();
	    if(addr != null) addr = addr.trim();
	    if(addr2 != null) addr2 = addr2.trim();
	    
	    Date birth = null;
	    try {
		    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		    java.util.Date utilBirthStr = dateFormat.parse(birthStr);
		    birth = new java.sql.Date(utilBirthStr.getTime());
	    }catch(ParseException pe) {}
	    System.out.println(id+ "&"+pwd);
	    MemberService service = MemberService.getInstance();
	    if(service.checkPwd(id, pwd) == MemberSet.YES_ID) {
		    Member member = new Member(email, pwd, name, phone, addr, addr2, null);
		    upCode = service.edit(member);
	
	    	HttpSession session = request.getSession();
	    	session.setAttribute("loginUser", member);
	    	session.setAttribute("upCode", upCode);
		    response.sendRedirect("edit_msg.jsp");
	    }else {
	    	HttpSession session = request.getSession();
	    	session.setAttribute("upCode", upCode);
		    response.sendRedirect("edit_msg.jsp");
	    }

	}
}
