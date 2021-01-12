<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8" import="amd.login.model.LoginDAO;"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 처리 JSP</title>
<style>
@import url(//fonts.googleapis.com/earlyaccess/hanna.css);
@import url(//fonts.googleapis.com/earlyaccess/jejumyeongjo.css);
</style>
</head>
<body>
    <%
        // 인코딩 처리
        request.setCharacterEncoding("UTF-8"); 
        
        // 로그인 화면에 입력된 아이디와 비밀번호를 가져온다
        String email= request.getParameter("email");
        String pwd = request.getParameter("pwd");
        
        // DB에서 아이디, 비밀번호 확인
        LoginDAO dao = LoginDAO.getInstance();
        int check = dao.loginCheck(email, pwd);
        
        // URL 및 로그인관련 전달 메시지
        String msg = "";
        
        if(check == 1)    // 로그인 성공
        { 
            // 세션에 현재 아이디 세팅
            session.setAttribute("sessionID", email);
            msg = "../../Login.jsp";
        }
        else if(check == 0) // 비밀번호가 틀릴경우
        {
            msg = "../Login.jsp?msg=0";
        }
        else    // 아이디가 틀릴경우
        {
            msg = "../Login.jsp?msg=-1";
        }
         
        // sendRedirect(String URL) : 해당 URL로 이동
        // URL뒤에 get방식 처럼 데이터를 전달가능
        response.sendRedirect(msg);
    %>
</body>
</html>