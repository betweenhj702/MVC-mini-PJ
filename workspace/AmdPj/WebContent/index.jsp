<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>HBAF</title>
  
  <!-- Bootstrap core CSS -->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom fonts for this template -->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
  <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>

  <!-- Custom styles for this template -->
  <link href="css/clean-blog.min.css" rel="stylesheet">
<style type="text/css">
.dropbtn {
    background-color: #FFC800;
    padding: 15px 28px;
    font-size: 20px;
    border: none;
    cursor: pointer;
}
.dropdown {
    position: relative;
    display: inline-block;
}
.dropdown-content {
    display: none;
    position: absolute;
    z-index: 1;
}
.dropdown-content a {
    padding: 12px 16px;
    text-decoration: none;
    display: block;
}
.dropdown-content a:hover {
    background-color: #ffff11;
}
.dropdown:hover .dropdown-content {
    display: block;
}
.dropdown:hover .dropbtn {
    background-color:000000;
}
  </style>
</head>

<body>

  <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
    <div class="container">
      <a class="navbar-brand" href="index.do">아몬드파티</a>
      <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        Menu
        <i class="fas fa-bars"></i>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item">
         	<c:choose>
         	<c:when test="${empty loginUser}"></c:when>
         	<c:otherwise><a class="nav-link" href="cart/cart.do">장바구니</a></c:otherwise>
         	</c:choose>
          </li>
          <li class="nav-item">
          	<c:choose>
          	<c:when test="${empty loginUser}"><a class="nav-link" href="login/login.do?m=form">로그인</a></c:when>
          	<c:otherwise><a class="nav-link" href="login/login.do?m=out">로그아웃</a></c:otherwise>
          	</c:choose>
          </li>
          <li class="nav-item">
          	<c:choose>
          	<c:when test="${empty loginUser}"> <a class="nav-link" href="member/member.do?m=form">회원가입</a></c:when>
          	<c:otherwise> <a class="nav-link" href="member/member.do?m=goUpdate">회원정보</a></c:otherwise>
          	</c:choose>
          </li>
          
        </ul>
      </div>
    </div>
  </nav>

  <!-- Page Header -->
  <header class="masthead" style="background-image: url('img/hbaf-bg3.png')">
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
     	<div class="dropdown">
        <button class="dropbtn" >상품</button>
            <div class="dropdown-content">
             <a class="navbar-brand" href="product/product.do?cp=1&ps=16">전체 상품</a>
               <a class="navbar-brand" href="product/product.do?m=listC&cp=1&ps=16&p_type=1">아몬드</a>
               <a class="navbar-brand" href="product/product.do?m=listC&cp=1&ps=16&p_type=2">etc</a>
         	</div>
		</div>
	  <a class="navbar-brand" href="board_n/board_n.do">공지게시판</a>
	  <a class="navbar-brand" href="board_q/board_q.do">Q&A게시판</a>
     </div>
  </header>
  

 <!-- Main Content -->
  <div class="container">
    <div class="row">
      <div class="col-lg-8 col-md-10 mx-auto">
        <h2><i>4조의 아몬드 파티에 오신 여러분들을 환영합니다~!</i></h2><br>
        <center>
        <img src="img/아몬드 bg.png" border=0 width="300" height="200" ></center>
        <h6><p>4조는 천재조장님 신동오와 똑똑한 권연주 그리고 발표천재 이민용 그리고 귀염둥이 사랑둥이 막둥이 수진이가 있습니당<br>
               그리고 세상에 단 하나밖에 없는 4조의 아몬드파티~♬ 웹사이트 입니다!</p></h6>
            <img src="img/amd-fire.png" border=0 width="200" height="200" >
            <img src="img/amd-toffee.png" border=0 width="200" height="200" >
            <img src="img/amd-honey.png" border=0 width="200" height="200" >
            <img src="img/amd-greentea.png" border=0 width="200" height="200" >
            <img src="img/amd-star.png" border=0 width="200" height="200" >
            <img src="img/amd-cookie.png" border=0 width="200" height="200" >
            <img src="img/amd-mayo.png" border=0 width="200" height="200" >
            <img src="img/maca-cherry.png" border=0 width="200" height="200" >
            <img src="img/amd-black.png" border=0 width="200" height="200" >
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
