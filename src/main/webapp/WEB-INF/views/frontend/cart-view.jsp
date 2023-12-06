<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<!-- directive của JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>${title }</title>

<!-- variables -->
<jsp:include page="/WEB-INF/views/common/variable.jsp"></jsp:include>

<!-- css -->
<jsp:include page="/WEB-INF/views/frontend/layout/cssCart-view.jsp"></jsp:include>

</head>

<body>
	<div class="wrapper">
		<!-- header -->
		<jsp:include page="/WEB-INF/views/frontend/layout/header.jsp"></jsp:include>
		<!-- content -->
		<main class="main">

			<!-- Danh mục sản phẩm -->
			<div class="main__products">
				<div class="container">
					<c:choose>
						<c:when test="${totalCartProducts > 0 }">
							<form action="${classpath }/cart-view" method="get">
								<div class="cart-view">
									<div class="title">
										<h2>Your Cart</h2>
									</div>
									<div class="thead">
										<ul>
											<li scope="col" class="theadProduct">Product</li>
											<li scope="col" class="theadUnit-price">Unit price</li>
											<li scope="col" class="theadQuantity">Quantity</li>
											<li scope="col" class="theadPaymentPrice">Total Price</li>
											<li scope="col" class="theadAction">Actions</li>
										</ul>
									</div>
									<div class="list_product">
										<c:forEach var="item" items="${cart.cartProducts }">
											<!-- start -->
											<div class="row">
												<div class="info_product">
													<div class="img_prd">
														<img src="${classpath}/FolderUpload/${item.avatar }"
															width="30%">
														<h3>${item.productName }</h3>
													</div>
													<div class="desc">
														<p >
															<span><fmt:formatNumber value="${item.price }"
																	minFractionDigits="0" /></span><sup >đ</sup>
														</p>
													</div>
												</div>
												<div class="numberProduct">
													<button
														onclick="updateProductQuantity(${item.productId }, -1)"
														value="-" class=" btn-tru">-</button>
													<input id="productQuantity_${item.productId }" type="text"
														name="quantity" value="${item.quantity }">
													<button
														onclick="updateProductQuantity(${item.productId }, 1)"
														value="+" class=" btn-cong">+</button>
												</div>
												<div class="price">
													<fmt:formatNumber value="${item.price * item.quantity }"
														minFractionDigits="0"></fmt:formatNumber><sup>đ</sup>
												</div>
												<div class="remove">
													<button type="button" class="btn-remove">
														<a href="${classpath }/product-cart-delete/${item.productId }">Delete</a>
													</button>
												</div>
											</div>
										</c:forEach>
										<!-- end -->

										<div class="total_all">
											<span> Total money: </span>
											<fmt:formatNumber value="${totalCartPrice}"
												minFractionDigits="0"></fmt:formatNumber>
											<sup>đ</sup>
										</div>
									</div>
								</div>
							</form>
							<!-- Thong tin khach hang -->
							<div class="page-breadcrumb">
								<div class="title">
									<div class="main__products-title">
										<p>Thông tin khách hàng</p>
									</div>
								</div>
								<form action="${classpath }/cart-view" method="get">
									<div class="title">

										<div class="col-12">
											<div class="card">
												<div class="card-body">
													<div class="form-body">
														<div class="title-content">

															<div class="col-md-12">
																<div class="form-group mb-4">
																	<label for="name">Customer name (*)</label> <input
																		type="text" class="form-control" id="txtName"
																		name="txtName" placeholder="your name"
																		value="${user.name }" />
																</div>
															</div>
														</div>

														<div class="title-content">

															<div class="col-md-12">
																<div class="form-group mb-4">
																	<label for="mobile">Customer mobile (*)</label> <input
																		type="number" class="form-control" id="txtMobile"
																		name="txtMobile" placeholder="your phone number"
																		value="${user.mobile }" />
																</div>
															</div>
														</div>

														<div class="title-content">

															<div class="col-md-12">
																<div class="form-group mb-4">
																	<label for="phone">Customer email</label> <input
																		type="email" class="form-control" id="txtEmail"
																		name="txtEmail" placeholder="your email"
																		value="${user.email }" />
																</div>
															</div>
														</div>

														<div class="title-content">

															<div class="col-md-12">
																<div class="form-group mb-4">
																	<label for="phone">Customer address</label> <input
																		type="text" class="form-control" id="txtAddress"
																		name="txtAddress" placeholder="your address"
																		value="${user.address }" />
																</div>
															</div>
														</div>
														<div class="title-content">
															<div class="col-md-12">
																<div class="form-group mb-4">
																	<a href="${classpath }/index"
																		class="btn btn-primary active" role="button"
																		aria-pressed="true"> Back to shop </a>
																	<button class="btn btn-primary active"
																		onclick="_placeOrder()">Place orders</button>

																</div>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>

									</div>
								</form>
							</div>
						</c:when>
						<c:otherwise>
							<div class="notification">
								<div class="col-12">
									<c:choose>
										<c:when test="${checkout }">
											<h3 align="center"
												class="page-title text-truncate text-dark font-weight-medium mb-1">
												<span id="placeOrderSuccess">Bạn đã đặt hàng thành
													công</span>
											</h3>
										</c:when>
										<c:otherwise>
										
										<span id="placeOrderSuccess">Your cart:
													${errorMessage }</span>
													
										</c:otherwise>
									</c:choose>

								</div>
							</div>
							<div class="row">
								<div class="col-md-12" align="center">
									<div class="form-group mb-4">
										<a href="${classpath}/home" class="btn btn-primary active"
											role="button" aria-pressed="true"> Back to shop </a>
									</div>
								</div>
							</div>

						</c:otherwise>
					</c:choose>
				</div>
			</div>

		</main>

		<!-- footer -->
		<jsp:include page="/WEB-INF/views/frontend/layout/footer.jsp"></jsp:include>

		<div class="scroll__top">
			<i class='bx bx-up-arrow-alt'></i>
		</div>

		<!-- mobile menu -->

	</div>
	<!-- js -->
	<jsp:include page="/WEB-INF/views/frontend/layout/js.jsp"></jsp:include>

	<script type="text/javascript">
		updateProductQuantity = function(_productId, _quantity) {
			let data = {
				productId : _productId, //lay theo id
				quantity : _quantity
			};

			//$ === jQuery
			jQuery.ajax({
				url : "/update-product-quantity",
				type : "POST",
				contentType : "application/json",
				data : JSON.stringify(data),
				dataType : "json", //Kieu du lieu tra ve tu controller la json

				success : function(jsonResult) {
					let totalProducts = jsonResult.totalCartProducts;
					//viet lai so luong sau khi bam nut -;+
					$("#productQuantity_" + jsonResult.productId).html(
							jsonResult.newQuantity);
				},

				error : function(jqXhr, textStatus, errorMessage) {
					alert("An error occur");
				}
			});
		}
	</script>

	<script type="text/javascript">
		function _placeOrder() {
			//javascript object
			let data = {
				txtName : jQuery("#txtName").val(),
				txtEmail : jQuery("#txtEmail").val(), //Get by Id
				txtMobile : jQuery("#txtMobile").val(),
				txtAddress : jQuery("#txtAddress").val(),
			};

			//$ === jQuery
			jQuery.ajax({
				url : "/place-order",
				type : "POST",
				contentType : "application/json",
				data : JSON.stringify(data),
				dataType : "json", //Kieu du lieu tra ve tu controller la json

				success : function(jsonResult) {
					alert(jsonResult.code + ": " + jsonResult.message);
					$("#placeOrderSuccess").html(jsonResult.message);
				},

				error : function(jqXhr, textStatus, errorMessage) {
					alert("An error occur");
				}
			});
		}
	</script>

</body>

</html>