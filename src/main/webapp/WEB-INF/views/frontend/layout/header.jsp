<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<header>
		<a href="home" class="logo"><img
			src="${classpath}/frontend/images/logogiay.png" alt=""></a>

		<ul class="navmenu">
			<li><a href="${classpath}/home">home</a></li>
			<li><a href="#">about</a></li>
			<li><a href="${classpath}/category">products</a>
				<div class="submenu">
					<ul>
						<li><a href="ListProducts.html">Nike</a></li>
						<li><a href="ListProducts.html">Adidas</a></li>
						<li><a href="ListProducts.html">Men's shoes</a></li>
						<li><a href="ListProducts.html">women's shoes</a></li>
						<li><a href="ListProducts.html">kid' shoes</a></li>
						<li><a href="ListProducts.html">puma</a></li>
					</ul>
				</div></li>
			<li><a href="#">page</a></li>
			<li><a href="#">contact</a></li>
		</ul>

		<ul class="nav-icon">
			<!-- Form search -->
			<li>
				<form id="form_search" method="GET" action="">
					<button type="submit">
						<i class='bx bx-search-alt-2'></i>
					</button>
					<input type="text" name="keyword" placeholder="Từ khóa tìm kiếm" />
				</form></li>
			<!-- form đăng nhập đăng ký -->
			<li><a href="${classpath}/login"><i class='bx bx-user color-icon'></i></a>
			</li>
			<!-- Giỏ hàng -->
			<li><a href="${classpath}/cart-view" class="cart"> 
			<span id="totalCartProductsId" class="quantity">${totalCartProducts}</span> <!-- Hiển thị só lượng hàng trong giỏ -->
					<i class='bx bx-cart color-icon'></i>
			</a></li>

			<div class="bx bx-menu" id="menu-icon"></div>
		</ul>
	</header>