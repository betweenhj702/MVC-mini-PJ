package amd.control;

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
import amd.model.MemberService;
import amd.model.MemberSet;

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
    
	String id = request.getParameter("id");
    if(id != null) id = id.trim();
    
    MemberService service = MemberService.getInstance();
    int rCode = service.checkMember(id);
    request.setAttribute("rCode", rCode);
    if(rCode==MemberSet.PASS) {
    	HttpSession session = request.getSession();
    	//Member m = service.getMemberS(id);
    	session.setAttribute("id", id);
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
	    response.sendRedirect("member.do?m=congrats");
    }else {
    	System.out.println("회원가입 실패");
    }
}
}
