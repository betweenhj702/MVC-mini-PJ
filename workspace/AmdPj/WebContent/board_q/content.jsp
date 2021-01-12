<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, amd.domain.BoardQ, boardQ.mvc.vo.BoardQVO"%>
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
            <a class="nav-link" href="index.html">로그인</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="about.html">회원가입</a>
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
      <a class="navbar-brand" href="index.html">상품</a>
	  <a class="navbar-brand" href="index.html">공지게시판</a>
	  <a class="navbar-brand" href="board_q.do">Q&A게시판</a>
     </div>
  </header>

  <div class="container">
    <div class="row">
      <div class="col-lg-8 col-md-10 mx-auto">
        <table class="table table-striped table-hover">
            <tr>
				<td width='20%' align='center'>글번호</td>
				<td width='30%'>${boardQ.bq_seq}</td>
				<td width='20%' align='center'>조회수</td>
				<td width='30%'>${boardQ.bq_count}</td>
			</tr>
			<tr>
				<td align='center', colspan='1'>작성자</td>
				<td colspan='3'>${boardQ.m_name}</td>
			</tr>
			<tr>
				<td align='center', colspan='1'>이메일</td>
				<td colspan='3'>${boardQ.m_email}</td>
			</tr>
			<tr>
				<td align='center', colspan='1'>제목</td>
				<td colspan='3'>${boardQ.bq_subject}</td>
			</tr>
			<tr>
				<td align='center', colspan='1'>내용</td>
				<td colspan='3'>${boardQ.bq_content}</td>
			</tr>
        </table>
		<div align='right'>  
		    <a href="board_q.do" class="btn btn-success">목록</a> 
			<a href="board_q.do?m=moveUPage&seq=${boardQ.bq_seq}" class="btn btn-success">수정</a>
			<a href="board_q.do?m=delete&seq=${boardQ.bq_seq}" class="btn btn-success">삭제</a>
			<a href="board_q.do?m=moveRePage&seq=${boardQ.bq_seq}&ref=${boardQ.bq_refer}&lev=${boardQ.bq_lev}&place=${boardQ.bq_lev}"	class="btn btn-success">
				답글</a>
        </div>
	  </div>
    </div>
  </div>

  <hr>

  <!-- Footer -->
  <footer>
    <div class="container">
      <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto">
          <ul class="list-inline text-center">
            <li class="list-inline-item">
              <a href="#">
                <span class="fa-stack fa-lg">
                  <i class="fas fa-circle fa-stack-2x"></i>
                  <i class="fab fa-twitter fa-stack-1x fa-inverse"></i>
                </span>
              </a>
            </li>
            <li class="list-inline-item">
              <a href="#">
                <span class="fa-stack fa-lg">
                  <i class="fas fa-circle fa-stack-2x"></i>
                  <i class="fab fa-facebook-f fa-stack-1x fa-inverse"></i>
                </span>
              </a>
            </li>
            <li class="list-inline-item">
              <a href="#">
                <span class="fa-stack fa-lg">
                  <i class="fas fa-circle fa-stack-2x"></i>
                  <i class="fab fa-github fa-stack-1x fa-inverse"></i>
                </span>
              </a>
            </li>
          </ul>
          <p class="copyright text-muted">Copyright &copy; Your Website 2020</p>
        </div>
      </div>
    </div>
  </footer>

  <!-- Bootstrap core JavaScript -->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Custom scripts for this template -->
  <script src="js/clean-blog.min.js"></script>

</body>

</html>
