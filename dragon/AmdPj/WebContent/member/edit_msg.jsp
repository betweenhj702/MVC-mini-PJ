<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script language="javascript">
	if(${upCode}){
		alert("수정 완료!");
		location.href="../index.do";
	}else{
		alert("비밀번호가 올바르지 않습니다.");
		location.href="member.do?m=edit";
	}
</script>