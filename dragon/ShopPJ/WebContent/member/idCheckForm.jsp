
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>idCheck</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
</head>
<body>
	<div style="text-align: center; padding-top:60px">
		
		<form method="post" action="idCheckProc.jsp"
			onsubmit="return blankCheck(this)">
			아이디  <input type="text" id="id" name="email" maxlength="30" autofocus>
			<p>
			</p>
			<button type="submit" class="btn btn-outline-dark btn-sm">중복 확인</button>
		</form>
	</div>
	<script> 
		function blankCheck(f){ 
			var id=f.id.value; id=id.trim(); 
			if(id.length<4){ 
				alert("아이디는 4자 이상 입력해주십시오."); 
				return false; 
			}//if end 
			return true; 
		}//blankCheck() end 
		</script>
</body>
</html>