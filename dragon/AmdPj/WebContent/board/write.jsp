<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="amd.domain.Admin"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>


<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>HBAF</title>

  <!-- Bootstrap core CSS -->
  <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom fonts for this template -->
  <link href="../vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
  <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>

  <!-- Custom styles for this template -->
  <link href="../css/clean-blog.min.css" rel="stylesheet">

</head>

<body>

  <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
    <div class="container">
      <a class="navbar-brand" href="../index.do">아몬드</a>
      <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        Menu
        <i class="fas fa-bars"></i>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item">
            <c:choose>
          	<c:when test="${empty loginUser}"><a class="nav-link" href="../login/login.do?m=form">로그인</a></c:when>
          	<c:otherwise><a class="nav-link" href="../login/login.do?m=out">로그아웃</a></c:otherwise>
          	</c:choose>
          </li>
          <li class="nav-item">
            <c:choose>
          	<c:when test="${empty loginUser}"> <a class="nav-link" href="../member/member.do?m=form">회원가입</a></c:when>
          	<c:otherwise> <a class="nav-link" href="../member/member.do?m=form">회원정보</a></c:otherwise>
          	</c:choose>
          </li>
        </ul>
      </div>
    </div>
  </nav>

  <!-- Page Header -->
  <header class="masthead" style="background-image: url('../img/hbaf-bg3.png')">
    <div class="container">
      <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto">
          <div class="site-heading">
            <h1></h1>
          </div>
        </div>
      </div>
    </div>
	<div class="container">
      <a class="navbar-brand" href="../product/product.do?cp=1&ps=16">전체 상품</a>
      <a class="navbar-brand" href="../product/product.do?m=listC&cp=1&ps=16&p_type=1">아몬드</a>
      <a class="navbar-brand" href="../product/product.do?m=listC&cp=1&ps=16&p_type=2">etc</a>
	  <a class="navbar-brand" href="">공지게시판</a>
	  <strong><a class="navbar-brand" href="board_q.do">Q&A게시판</a></strong>
     </div>
  </header>
  

  <!-- Main Content -->
  <article>
  
  <div class="container" role="main">
    <div class="row">
      
        <form name="form" id="form" role="form" method="post" action="board.do?m=writeOk">

				<div class="mb-3">

					<label for="title">제목</label>

					<input type="text" class="form-control" name="title" id="title"  required>

				</div>

				

				<div class="mb-3">

					<label for="reg_id">작성자</label>

					<input readOnly type="text" class="form-control" name="reg_id" id="reg_id" value="관리자" >

				</div>

				

				<div class="mb-3">

					<label for="content">내용</label>

					<textarea class="form-control" rows="5" name="content" id="content" required></textarea>

				</div>

				

				<div class="mb-3">

					<label for="tag">작성날짜</label>

					<input readOnly type="text" class="form-control" name="tag" id="tag">

				</div>

			<div >
				<c:if test="${!empty sessionScope.Admin}">
				<!-- 
				<input type="button" class="btn btn-sm btn-primary" value ="저장" onclick="check()">
				 -->
				<input type="submit" class="btn btn-sm btn-primary" value="저장" >
				
				
				</c:if>
				<a href="board.do" class="btn btn-sm btn-primary id="btnList">목록</button></a>
			
				
			</div>
			</form>
			
		</div>
		</article>
        				
		<script>
	    function check(){
	    	if(form.title.value == ""){
	    		alert("제목을 입력해주세요.");
	    		form.title.focus();
	    		return false;
	    	}else if(form.content.value == ""){
		    	alert("내용을 입력해주세요.");
		    	form.content.focus();
		    	return false;
	    	}else{
		        form.submit();
	        }
	    }
	</script>


  <!-- Bootstrap core JavaScript -->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Custom scripts for this template -->
  <script src="js/clean-blog.min.js"></script>

</body>

</html>
