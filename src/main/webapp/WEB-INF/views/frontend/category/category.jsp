<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>ListProducts</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel='stylesheet' type='text/css' media='screen' href='main.css'>
    <script src='main.js'></script>

    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link
        href="https://fonts.googleapis.com/css2?family=Open+Sans:ital,wght@0,300;0,400;0,500;0,700;1,400;1,500;1,600;1,800&display=swap">
   <!-- Css -->
	<jsp:include page="/WEB-INF/views/common/variable.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/views/frontend/layout/cssCategory.jsp"></jsp:include>

</head>

<body id="top">
   <!-- Header -->
	<jsp:include page="/WEB-INF/views/frontend/layout/header.jsp"></jsp:include>
	<!-- Header -->

        <main>
            <div class="container">
                <div class="content">
                    <div class="left">
                        <div class="menu_left">
                            <div class="title">
                                <h3>Danh mục sản phẩm</h3>
                            </div>
                            <ul>
                                <li>
                                    <a href="">Quần áo nam</a>
                                </li>
                                <li>
                                    <a href="">Quần áo nữ</a>
                                </li>
                                <li>
                                    <a href="">Giày</a>
                                </li>
                                <li>
                                    <a href="">Túi</a>
                                </li>
                                <li>
                                    <a href="">Phụ kiện</a>
                                </li>
                                <li>
                                    <a href="">Sale off</a>
                                </li>
                            </ul>
                        </div>
                        <div class="menu_left filter_price">
                            <div class="title">
                                <h3>Tìm kiếm theo giá tiền</h3>
                            </div>
                            <ul>
                                <li>
                                    <input id="price_1" type="checkbox" name="price" value="1">
                                    <label for="price_1">Từ 0 đến 300.000đ</label>
                                </li>
                                <li>
                                    <input id="price_2" type="checkbox" name="price" value="1">
                                    <label for="price_2">Từ 300.000đ đến 500.000đ</label>
                                </li>
                                <li>
                                    <input id="price_3" type="checkbox" name="price" value="1">
                                    <label for="price_3">Từ 500.000đ đến 700.000đ</label>
                                </li>
                                <li>
                                    <input id="price_4" type="checkbox" name="price" value="1">
                                    <label for="price_4">Từ 700.000đ đến 1000.000đ</label>
                                </li>
                            </ul>
                        </div>

                    </div>
                    <div class="right">
                        <div class="title_header">
                            <h3>List products</h3>
                            <div class="arrangement-price">
                                <label> Price arrangement: </label>
                                    <select name="choose" class="form_control">                                 
                                        <option value="" checked>Ascending</option>
                                        <option value="">Decrease</option>
                                        <option value="">New model</option>
                                        <option value="">Old model</option>
                                    </select>
                            </div>
                        </div>
                        <div class="products">

                            <div class="row">
                                <a href="product"><img src="${classpath}/frontend/images/giaydutiecnu.jpg" alt="">
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
                
                                <div class="nameproduct">
                                    <h4>Giày nu</h4>
                                </div>
                
                                <div class="price">
                                    <button type="button"><i class='bx bx-cart'></i></button>
                                    <p>2.560.000d</p>
                                </div>
                
                            </div>
                            <div class="row">
                                <a href="product"><img src="${classpath}/frontend/images/giaymules.jpg" alt="">
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
                
                                <div class="nameproduct">
                                    <h4>Giày mules</h4>
                                </div>
                
                                <div class="price">
                                    <button type="button"><i class='bx bx-cart'></i></button>
                                    <p>1.800.000d</p>
                                </div>
                
                            </div>
                            <div class="row">
                                <a href="product"><img src="${classpath}/frontend/images/giaychaybo.jpg" alt="">
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
                
                                <div class="nameproduct">
                                    <h4>Giày mc</h4>
                                </div>
                
                                <div class="price">
                                    <button type="button"><i class='bx bx-cart'></i></button>
                                    <p>4.120.000d</p>
                                </div>
                
                            </div>
                            <div class="row">
                                <a href="product"><img src="${classpath}/frontend/images/giaynu.jpg" alt="">
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
                
                                <div class="nameproduct">
                                    <h4>Giày md</h4>
                                </div>
                
                                <div class="price">
                                    <button type="button"><i class='bx bx-cart'></i></button>
                                    <p>2.340.000d</p>
                                </div>
                
                            </div>
                            <div class="row">
                                <a href="product"><img src="${classpath}/frontend/images/giaybongro.jpg" alt="">
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
                
                                <div class="nameproduct">
                                    <h4>Giày ..</h4>
                                </div>
                
                                <div class="price">
                                    <button type="button"><i class='bx bx-cart'></i></button>
                                    <p>4.200.000d</p>
                                </div>
                
                            </div>
                
                            <div class="row">
                                <a href="product"><img src="${classpath}/frontend/images/giaysneaker.jpg" alt=""></a>
                                <div class="product-text">
                                    <h5> hot seller</h5>
                                </div>
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
                
                                <div class="nameproduct">
                                    <h4>Giày sneaker</h4>
                                </div>
                
                                <div class="price">
                                    <button type="button"><i class='bx bx-cart'></i></button>
                                    <p>3.870.000d</p>
                                </div>
                
                            </div>
                
                            <div class="row">
                                <a href="product"><img src="${classpath}/frontend/images/giaybot.jpg" alt=""></a>
                                <div class="product-text">
                                    <h5>sale</h5>
                                </div>
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
                
                                <div class="nameproduct">
                                    <h4>Giày bốt</h4>
                                </div>
                
                                <div class="price">
                                    <button type="button"><i class='bx bx-cart'></i></button>
                                    <p>1250.000d</p>
                                </div>
                
                            </div>
                
                            <div class="row">
                                <a href="product"><img src="${classpath}/frontend/images/giaydamcuoi.jpg" alt="">
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
                
                                <div class="nameproduct">
                                    <h4>Giày đám cưới</h4>
                                </div>
                
                                <div class="price">
                                    <button type="button"><i class='bx bx-cart'></i></button>
                                    <p>1.500.000d</p>
                                </div>
                
                            </div>
                
                            <div class="row">
                                <a href="product"><img src="${classpath}/frontend/images/giaydutiecnu.jpg" alt="">
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
                                <div class="nameproduct">
                                    <h4>Giày dự tiệc nữ</h4>
                                </div>
                
                                <div class="price">
                                    <button type="button"><i class='bx bx-cart'></i></button>
                                    <p>2.000.000d</p>
                                </div>
                
                            </div>
                
                            <div class="row">
                                <a href="product"><img src="${classpath}/frontend/images/giaybongro.jpg" alt=""></a>
                                <div class="product-text">
                                    <h5>sale</h5>
                                </div>
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
                                <div class="nameproduct">
                                    <h4>Giày bóng rổ</h4>
                                </div>
                
                                <div class="price">
                                    <button type="button"><i class='bx bx-cart'></i></button>
                                    <p>2.550.000d</p>
                                </div>
                
                            </div>
                
                            <div class="row">
                                <a href="product"><img src="${classpath}/frontend/images/giaydabong.jpg" alt=""></a>
                                <div class="product-text">
                                    <h5>hot</h5>
                                </div>
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
                                <div class="nameproduct">
                                    <h4>Giày đá banh</h4>
                                </div>
                
                                <div class="price">
                                    <button type="button"><i class='bx bx-cart'></i></button>
                                    <p>2.770.000d</p>
                                </div>
                
                            </div>
                            <div class="row">
                                <a href="product"><img src="${classpath}/frontend/images/giaychaybo.jpg" alt=""></a>
                
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
                
                                <div class="nameproduct">
                                    <h4>Giày chạy bộ</h4>
                                </div>
                
                                <div class="price">
                                    <button type="button"><i class='bx bx-cart'></i></button>
                                    <p>1.050.000d</p>
                                </div>
                
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>
   
 	<!-- Footer -->>
	<jsp:include page="/WEB-INF/views/frontend/layout/footer.jsp" ></jsp:include>
	<!-- Footer -->>
   <jsp:include page="/WEB-INF/views/frontend/layout/js.jsp"></jsp:include>
</body>

</html>