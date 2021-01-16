<%@page contentType="text/html;charset=utf-8" import="login.mvc.model.LoginSet, amd.domain.Member"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script language="javascript">
	if(${rCode} == <%=LoginSet.NO_EMAIL%>){
		alert("이메일을 다시 확인해주세요.");
		location.href="login.jsp";
	}else if(${rCode} == <%=LoginSet.NO_PWD%>){
		alert("올바르지 않은 비밀번호입니다.");
		location.href="login.do";
	}else{
		alert("${loginUser.m_name}님 환영합니다!");
		location.href="../index.jsp";
	}
</script>