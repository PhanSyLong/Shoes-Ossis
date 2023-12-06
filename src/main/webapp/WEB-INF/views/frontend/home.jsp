<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- directive của JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>

<head>
<meta charset='utf-8'>
<meta http-equiv='X-UA-Compatible' content='IE=edge'>
<title>${title}</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300;0,400;0,500;0,700;1,400;1,500;1,600;1,800&display=swap"
	rel="stylesheet">

<jsp:include page="/WEB-INF/views/common/variable.jsp"></jsp:include>
<jsp:include page="/WEB-INF/views/frontend/layout/cssHome.jsp"></jsp:include>

</head>

<body id="top">
	<!-- Header -->
	<jsp:include page="/WEB-INF/views/frontend/layout/header.jsp"></jsp:include>
	<!-- Header -->

	<main>
		<section class="main-home">
			<div class="main-text">
				<h5>Shoes Collection</h5>
				<h1>
					Warm steps <br> emotions winter
				</h1>
				<p>"Beautiful design, top-quality, and perfect warmth</p>

				<a href="category" class="main-btn">Shop now <i
					class='bx bx-right-arrow-alt'></i></a>
			</div>

			<!-- <div class="down-arrow">
            <a href="#trending" class="down"><i class='bx bx-down-arrow-alt'></i></a>
        </div> -->
		</section>
		<!-- trending-product-section -->
		<section class="trending-product" id="trending">
			<div class="center-text">
				<h2>
					Our Trending <span>products</span>
				</h2>
			</div>
			<div class="products">
			<c:forEach items="${products }" var="product">
				<div class="row">
						<a href="${classpath}/product-detail/${product.id }"
							class="image"> <img
							src="${classpath }/FolderUpload/${product.avatar }"
							class="fit-img zoom-img">
						</a>
						<div class="heart-icon">
							<i class='bx bx-heart'></i>
						</div>
						<div class="ratting">
							<i class='bx bxs-star'></i> 
							<i class='bx bxs-star'></i> 
							<i class='bx bxs-star'></i> 
							<i class='bx bxs-star'></i> 
							<i class='bx bxs-star-half'></i>
						</div>

						<a href="${classpath }/product/product/${product.id }"
							class="nameproduct">
							<h4>${product.name }</h4>
						</a>

						<div class="content">
							<div class="price">
								<fmt:formatNumber value="${product.price }" minFractionDigits="0"></fmt:formatNumber>
								<sup>đ</sup>
							</div>
							<button type="button">
								<a onclick="addToCart(${product.id}, 1,'${product.name }')"><i class='bx bx-cart'></i></a>
							</button>
							
							
						</div>
				</div>
				</c:forEach>
			</div>
		</section>
		<section class="client-reviews">
			<div class="reviews">
				<h3>Client Reviews</h3>
				<img src="${classpath}/frontend/images/giaydabong.jpg" alt="">
				<p>"First of all, the products here always ensure quality. They
					specialize in providing various types of shoes from renowned brands
					such as Nike, Adidas, and Asics, ensuring that you will always have
					plenty of style and quality choices. Furthermore, the customer
					service at this store is consistently professional. The staff is
					always ready to assist you in finding and selecting products that
					match your needs. This creates a shopping experience that is easy
					and comfortable."</p>
				<h2>Phan Sỹ Long</h2>
				<p>CEO of Nikenda</p>
			</div>
		</section>

		<!-- update-news-section -->
		<section class="Update-news">
			<div class="up-center-text">
				<h2>New Updates</h2>
			</div>

			<div class="update-cart">

				<div class="cart">
					<a href=""><img src="${classpath}/frontend/images/event1.jpg"
						alt=""></a>
					<h5>20 October 2023</h5>
					<h4>Bring sale on this winter vacation</h4>
					<p>Choosing clothes suitable for the weather is something that
						all girls care about to have a perfect look. Especially in winter,
						when the weather is cold, girls have to choose fashionable clothes
						that can keep their bodies warm. One of the fashion accessories
						that girls cannot ignore when choosing winter outfits is shoes. If
						you don't know what shoes to wear in winter, please refer to Nine
						West's article below about winter shoes.</p>

					<h6>
						<a href="">Continue Reading..</a>
					</h6>
				</div>

				<div class="cart">
					<a href=""><img src="${classpath}/frontend/images/event2.jpg"
						alt=""></a>
					<h5>25 jan 2023</h5>
					<h4>Old shoe models should not be purchased</h4>
					<p>There are fashion trends that endure over time, but there
						are also things that quickly go out of fashion even though they
						were once items that everyone wanted to own. Like clothes, shoes
						also have items that quickly become outdated and are no longer as
						popular as before. And below are 4 styles of flat shoes that women
						should not buy again this summer because they have long gone out
						of fashion.</p>

					<h6>
						<a href="">Continue Reading..</a>
					</h6>
				</div>

				<div class="cart">
					<a href=""> <img src="${classpath}/frontend/images/event3.jpg"
						alt=""></a>
					<h5>2 May 2023</h5>
					<h4>New shoe models coming soon</h4>
					<p>Ending 2022 with many Jordan shoe models being released,
						Jordan fever has engulfed the sneaker world, famous singers have
						also worn Jordans to add color to their performances and make them
						more unique. 2023 will be a year with many more changes when giant
						Nike will launch Jordan shoe models with many new models, Air
						Jordan 13 and Air Jordan 1 are ready to hit the shelves in the
						near future, this is also one of the The opening act for sneaker
						enthusiasts around the world to know and will have extremely
						unique ideas in the near future. Original article link: Top more
						than 50 Nike Jordan shoe models preparing to launch 2023 HOT -
						1Sneaker
						(https://1sneaker.vn/top-hon-50-mau-giay-nike-jordan-chuan-bi-ra-mat
						-2021-hot/)</p>

					<h6>
						<a href="">Continue Reading..</a>
					</h6>
				</div>
			</div>
		</section>
	</main>
	<!-- Footer -->
	<jsp:include page="/WEB-INF/views/frontend/layout/footer.jsp"></jsp:include>
	<!-- Footer -->
	<!-- Js -->
	<jsp:include page="/WEB-INF/views/frontend/layout/js.jsp"></jsp:include>
	<!-- Add to cart -->
	<script type="text/javascript">
		addToCart = function(_productId, _quantity, _productName) {	
			let data = {
				productId: _productId, //lay theo id
				quantity: _quantity,
				
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