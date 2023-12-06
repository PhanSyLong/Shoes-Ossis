<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<!-- directive của JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<head>
<meta charset='utf-8'>
<meta http-equiv='X-UA-Compatible' content='IE=edge'>
<title>detailProduct</details>
</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300;0,400;0,500;0,700;1,400;1,500;1,600;1,800&display=swap">
<!-- Css -->
<jsp:include page="/WEB-INF/views/common/variable.jsp"></jsp:include>
<jsp:include page="/WEB-INF/views/frontend/layout/cssProduct.jsp"></jsp:include>
</head>
<body id="top">
	<div>
	<!-- Header -->
	<jsp:include page="/WEB-INF/views/frontend/layout/header.jsp"></jsp:include>
	<!-- Header -->
	</div>
		<main>
			<div class="container">
				<div class="content">
					<div class="left">
						<div class="menu_left">
							<div class="title">
								<h3>Danh mục sản phẩm</h3>
							</div>
							<ul>
								<li><a href="">Quần áo nam</a></li>
								<li><a href="">Quần áo nữ</a></li>
								<li><a href="">Giày</a></li>
								<li><a href="">Túi</a></li>
								<li><a href="">Phụ kiện</a></li>
								<li><a href="">Sale off</a></li>
							</ul>
						</div>
						<div class="menu_left filter_price">
							<div class="title">
								<h3>Tìm kiếm theo giá tiền</h3>
							</div>
							<ul>
								<li><input id="price_1" type="checkbox" name="price"
									value="1"> <label for="price_1">Từ 0 đến
										300.000đ</label></li>
								<li><input id="price_2" type="checkbox" name="price"
									value="1"> <label for="price_2">Từ 300.000đ đến
										500.000đ</label></li>
								<li><input id="price_3" type="checkbox" name="price"
									value="1"> <label for="price_3">Từ 500.000đ đến
										700.000đ</label></li>
								<li><input id="price_4" type="checkbox" name="price"
									value="1"> <label for="price_4">Từ 700.000đ đến
										1000.000đ</label></li>
							</ul>
						</div>

					</div>
					<div class="right">
						<div class="right-header">
							<p>home</p>
							<p class="p">|</p>
							<p>detail product</p>
						</div>
						<div class="detailproduct">
							<div class="right-left">
								<img src="${classpath}/FolderUpload/${product.avatar}" alt="">
							</div>
							<div class="right-right">
								<div class="right-right-title">
									<h4>${product.name }</h4>
								</div>
								<div class="detail-prices">
									<p>
									<span><fmt:formatNumber value="${product.price }"
												minFractionDigits="0" /></span>
												<sup>đ</sup>
									</p>
									<div>
										<select name="size" class="size">
											<option value="" checked>Select size</option>
											<option value="">S</option>
											<option value="">M</option>
											<option value="">L</option>
											<option value="">XL</option>
											<option value="">XXL</option>
										</select>
									</div>
									<div class="size-and-buy">
										<input type="number" name="quantity" id="quantity" class="quantity"  value="1">
										<button class="add-to-cart">
											<a onclick="addToCart(${product.id},'${product.name }')">Add to cart</a>
										</button>
									</div>
								</div>
								<div class="product-description">
									<h3>product description:</h3>
									<p>The Adidas Superstar is an iconic classic known for its
										sleek design and the distinctive shell-toe feature. It's a
										versatile sneaker that pairs well with various outfits, making
										it a popular choice for both casual and athletic wear. The
										Superstar comes in a variety of colors and materials, allowing
										you to express your style</p>
								</div>
							</div>
						</div>
						<div class="related-products">
							<h2>relate product</h2>
							<ul>
								<!-- start -->
								<li class="row"><a href=""><img
										src="${classpath}/frontend/images/giaymules.jpg" alt="">
								</a>
									<div class="heart-icon">
										<i class='bx bx-heart'></i>
									</div>
									<div class="ratting">
										<i class='bx bxs-star'></i> <i class='bx bxs-star'></i> <i
											class='bx bxs-star'></i> <i class='bx bxs-star'></i> <i
											class='bx bxs-star-half'></i>
									</div>

									<div class="nameproduct">
										<h4>Giày mules</h4>
									</div>

									<div class="price">
										<button type="button">
											<i class='bx bx-cart'></i>
										</button>
										<p>1.800.000d</p>
									</div></li>
								<!-- end -->
								<!-- start -->
								<li class="row"><a href=""><img
										src="${classpath}/frontend/images/giaybongro.jpg" alt="">
								</a>
									<div class="heart-icon">
										<i class='bx bx-heart'></i>
									</div>
									<div class="ratting">
										<i class='bx bxs-star'></i> <i class='bx bxs-star'></i> <i
											class='bx bxs-star'></i> <i class='bx bxs-star'></i> <i
											class='bx bxs-star-half'></i>
									</div>

									<div class="nameproduct">
										<h4>Giày bong ro</h4>
									</div>

									<div class="price">
										<button type="button">
											<i class='bx bx-cart'></i>
										</button>
										<p>2.850.000d</p>
									</div></li>
								<!-- end -->
								<!-- start -->
								<li class="row"><a href=""><img
										src="${classpath}/frontend/images/giaychaybo.jpg" alt="">
								</a>
									<div class="heart-icon">
										<i class='bx bx-heart'></i>
									</div>
									<div class="ratting">
										<i class='bx bxs-star'></i> <i class='bx bxs-star'></i> <i
											class='bx bxs-star'></i> <i class='bx bxs-star'></i> <i
											class='bx bxs-star-half'></i>
									</div>

									<div class="nameproduct">
										<h4>Giày chay bo</h4>
									</div>

									<div class="price">
										<button type="button">
											<i class='bx bx-cart'></i>
										</button>
										<p>1.640.000d</p>
									</div></li>
								<!-- end -->
								<!-- start -->
								<li class="row"><a href=""><img
										src="${classpath}/frontend/images/giaychaybo.jpg" alt="">
								</a>
									<div class="heart-icon">
										<i class='bx bx-heart'></i>
									</div>
									<div class="ratting">
										<i class='bx bxs-star'></i> <i class='bx bxs-star'></i> <i
											class='bx bxs-star'></i> <i class='bx bxs-star'></i> <i
											class='bx bxs-star-half'></i>
									</div>

									<div class="nameproduct">
										<h4>Giày chay bo</h4>
									</div>

									<div class="price">
										<button type="button">
											<i class='bx bx-cart'></i>
										</button>
										<p>1.640.000d</p>
									</div></li>
								<!-- end -->
								<!-- start -->
								<li class="row"><a href=""><img
										src="${classpath}/frontend/images/giaychaybo.jpg" alt="">
								</a>
									<div class="heart-icon">
										<i class='bx bx-heart'></i>
									</div>
									<div class="ratting">
										<i class='bx bxs-star'></i> <i class='bx bxs-star'></i> <i
											class='bx bxs-star'></i> <i class='bx bxs-star'></i> <i
											class='bx bxs-star-half'></i>
									</div>

									<div class="nameproduct">
										<h4>Giày chay bo</h4>
									</div>

									<div class="price">
										<button type="button">
											<i class='bx bx-cart'></i>
										</button>
										<p>1.640.000d</p>
									</div></li>
								<!-- end -->
							</ul>
						</div>
					</div>
				</div>
			</div>
		</main>

	<!-- Footer -->
	<jsp:include page="/WEB-INF/views/frontend/layout/footer.jsp" ></jsp:include>
	<!-- Footer -->
	<jsp:include page="/WEB-INF/views/frontend/layout/js.jsp"></jsp:include>
	<!-- Add to cart -->
	<script type="text/javascript">
		addToCart = function(_productId, _productName) {
			let data = {
				quantity: jQuery("#quantity").val(),
				productId: _productId, //lay theo id			
			};
				
			//$ === jQuery
			jQuery.ajax({
				url : "/add-to-cart",
				type : "POST",
				contentType: "application/json",
				data : JSON.stringify(data),
				dataType : "json", //Kieu du lieu tra ve tu controller la json
				
				success : function(jsonResult) {
					/* alert(jsonResult.code + ": " + jsonResult.message); */
					let totalProducts = jsonResult.totalCartProducts;
					$("#totalCartProductsId").html(totalProducts);
				},
				
				error : function(jqXhr, textStatus, errorMessage) {
					alert(jsonResult.code + ': Đã có lỗi xay ra...!')
				},
			});
		}
	</script>
</body>

</html>