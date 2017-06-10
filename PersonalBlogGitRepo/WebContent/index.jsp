<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<jsp:include page="head.jsp" />
</head>
<body>

<!--移动端菜单-->
<jsp:include page="header.jsp" />
<% Integer timeOfVisit = (Integer)request.getAttribute("timesOfVisit"); %>
您是第<%=timeOfVisit %>个访问者!谢谢您的访问</br>
<!--除菜单外所有-->
<div class="content-wrap">
	<div class="banner">
		<button class="menu-button" id="open-button">Open Menu</button>
		<img class="bannerImg" src="images/banner.jpg" alt="banner">
		<div class="header container">
			<!--personInfo-->
			<div class="row">
				<div class="col-md-12">
					<div class="personInfo">
						<div class="logo">
							<a href="index.html"><img src="images/logo.jpg" alt="logo"></a>
						</div>
						<div class="logoTheme">
							<h1>专注于Java开发</h1>
							<h3>写出改变世界的代码</h3>
						</div>
					</div>				
				</div>
			</div>
		</div> 
	</div>


	<!--文章列表-->
	


	<div class="container pageNav">
		<div class="row">	
			<div class="col-md-12">
				<nav>
				  <ul class="pagination">
				    <li>
				      <a href="#" aria-label="Previous">
				        <span aria-hidden="true">&laquo;</span>
				      </a>
				    </li>
				    <li><a href="#">1</a></li>
				    <li><a href="#">2</a></li>
				    <li><a href="#">3</a></li>
				    <li><a href="#">4</a></li>
				    <li><a href="#">5</a></li>
				    <li>
				      <a href="#" aria-label="Next">
				        <span aria-hidden="true">&raquo;</span>
				      </a>
				    </li>
				  </ul>
				</nav>
			</div>
		</div>
	</div>


	<!--footer-->
	<footer>
		<div class="main-footer">
		    <div class="container">
		        <div class="row"><!-- 
		        	<div class="col-md-3">
		                <div class="widget">
		                    <h4 class="title">分类目录</h4>
		                    <div class="box category clearfix">
								<li><a href="category.html">HTML</a></li>
								<li><a href="category.html">CSS</a></li>
								<li><a href="category.html">PHP</a></li>	
								<li><a href="category.html">JAVA</a></li>	
								<li><a href="category.html">BOOTSTRAP</a></li>							
							</div>
		                </div>
		            </div> -->

					<div class="col-md-3">
		                <div class="widget">
		                    <h4 class="title">文章标签</h4>
		                    <div class="box tags clearfix">
								<li><a href="tag.html">前端</a></li>
								<li><a href="tag.html">Nginx</a></li>
								<li><a href="tag.html">wordpress</a></li>
							</div>
						</div>
					</div>

					<!--  <div class="col-md-3">
		                <div class="widget">
		                    <h4 class="title">友情链接</h4>
		                    <div class="box friend-links clearfix">
								<li><a href="">淘宝UED</a></li>
								<li><a href="">淘宝UED</a></li>
								<li><a href="">淘宝UED</a></li>
							</div>
						</div>
					</div> -->


		        </div>
		    </div>
		</div>

		<div class="copyright">
		    <div class="container">
		        <div class="row">
		            <div class="col-md-12">
		                <span>Copyright &copy; <a href="http://fangself.com.cn">Fyping</a>&nbsp;&nbsp;</span> 
		                <span>京ICP备11008151号</span>
		            </div>
		        </div>
		    </div>
		</div>	
	</footer>	
</div>
</body>
    <script src="js/jquery-2.1.1.js"></script>
    <script src="js/bootstrap.min.js"></script>	
	<script src="js/snap.svg-min.js"></script>
	<script src="js/classie.js"></script>
	<script src="js/main3.js"></script>
	<script src="js/custom.js"></script>
</html>


