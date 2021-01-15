<%@ page contentType="text/html; charset=utf-8" import="amd.domain.Member, amd.domain.Cart"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

 <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
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
      <a class="navbar-brand" href="../index.do">아몬드파티</a>
      <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        Menu
        <i class="fas fa-bars"></i>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
	        <li class="nav-item">
	         	<c:choose>
	         	<c:when test="${empty loginUser}"></c:when>
	         	<c:otherwise><a class="nav-link" href="cart.do">장바구니</a></c:otherwise>
	         	</c:choose>
	        </li>
	         <li class="nav-item">
	         	<c:choose>
	         	<c:when test="${empty loginUser}"></c:when>
	         	<c:otherwise><a class="nav-link" href="../order/order.do?m=listOrd">결제내역</a></c:otherwise>
	         	</c:choose>
	        </li>
          <li class="nav-item">
          	<c:choose>
          	<c:when test="${empty loginUser}"><a class="nav-link" href="../login/login.do?m=form">로그인</a></c:when>
          	<c:otherwise><a class="nav-link" href="../login/login.do?m=out">로그아웃</a></c:otherwise>
          	</c:choose>
          </li>
          <li class="nav-item">
          	<c:choose>
          	<c:when test="${empty loginUser}"> <a class="nav-link" href="../member/member.do?m=form">회원가입</a></c:when>
          	<c:otherwise> <a class="nav-link" href="../member/member.do?m=join">회원정보</a></c:otherwise>
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
     <div class="dropdown">
       		<button class="dropbtn" >상품</button>
            <div class="dropdown-content">
             	<a class="navbar-brand" href="../product/product.do?cp=1&ps=16">전체 상품</a>
               <a class="navbar-brand" href="../product/product.do?m=listC&cp=1&ps=16&p_type=1">아몬드</a>
               <a class="navbar-brand" href="../product/product.do?m=listC&cp=1&ps=16&p_type=2">etc</a>
         	</div>
		</div>
	  <a class="navbar-brand" href="../board_n/board_n.do">공지게시판</a>
	  <a class="navbar-brand" href="../board_q/board_q.do">Q&A게시판</a>
     </div>
  </header>
<div class="container">
<form name="input" method="post" action="cart.do?m=update">
 <p class="text-center"><strong>${loginUser.m_name}</strong> 님의 장바구니</p>
<hr>



<div class="card">
<table class="table table-hover shopping-cart-wrap">
<thead class="text-muted">
<tr>
  <th scope="col">상품명</th>
  <th scope="col" width="120">수량</th>
  <th scope="col" width="120">가격</th>
  <th scope="col" width="200" class="text-right">삭제</th>
</tr>
</thead>
<tbody>
<c:forEach items="${list}" var="cart">
<tr>
	<td>
<figure class="media">
	<div class="img-wrap"><img src="../img/${cart.p_img}" width="150" class="img-thumbnail img-sm"></div>
	<figcaption class="media-body">
		<h6 class="title text-truncate">${cart.p_name}</h6>
		<dl class="param param-inline small">
		  <dt></dt>
		  <dd></dd>
		</dl>
	</figcaption>
</figure> 
	</td>
	<td> 
		${cart.c_amount} 개
	<!-- 폼안에 셀렉트가 여러개 만들어진다. 
		1. 이때 셀렉트의 이름을 달리해줘야 각 상품의 씨어만트값을 가져올수있음
		2. 각 상품을 업뎃할수있는방법은?  걍 하지마이씨-->
		
		<!--<select class="form-control">
			<option value="1" <c:if test="${cart.c_amount==1}">selected</c:if> > 1 </option>
	  		<option value="2" <c:if test="${cart.c_amount==2}">selected</c:if> > 2 </option>
	  		<option value="3" <c:if test="${cart.c_amount==3}">selected</c:if> > 3 </option>
	  		<option value="4" <c:if test="${cart.c_amount==4}">selected</c:if> > 4 </option>
	  		<option value="5" <c:if test="${cart.c_amount==5}">selected</c:if> > 5 </option>
	  		<option value="6" <c:if test="${cart.c_amount==6}">selected</c:if> > 6 </option>
	  		<option value="7" <c:if test="${cart.c_amount==7}">selected</c:if> > 7 </option>
		</select> -->
	</td>
	<td> 
		<div class="price-wrap"> 
			<var class="price">${cart.p_price}원</var>  
		</div> <!-- price-wrap .// -->
	</td>
	<td class="text-right"> 
	<a href="cart.do?m=del&c_seq=${cart.c_seq}" class="btn btn-outline-danger"> × Remove</a>
	</td>
</tr>
 </c:forEach>

</tbody>
</table>
</div> <!-- card.// -->
	<div>
		<input type="submit" value="주문하기" class="btn btn-success">
		<!--  <a href="cart.do?m=update" class="btn btn-success"> 주문하기</a> -->
	</div>
	</form>
</div> 
<!--container end.//-->

<br><br>
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
  <script src="../vendor/jquery/jquery.min.js"></script>
  <script src="../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Custom scripts for this template -->
  <script src="../js/clean-blog.min.js"></script>

</body>

</html>