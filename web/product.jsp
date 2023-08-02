<%-- 
    Document   : product
    Created on : Mar 4, 2023, 12:54:14 PM
    Author     : manh3
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

        <title>Detail</title>

        <!-- Google font -->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700" rel="stylesheet">

        <!-- Bootstrap -->
        <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css"/>

        <!-- Slick -->
        <link type="text/css" rel="stylesheet" href="css/slick.css"/>
        <link type="text/css" rel="stylesheet" href="css/slick-theme.css"/>

        <!-- nouislider -->
        <link type="text/css" rel="stylesheet" href="css/nouislider.min.css"/>

        <!-- Font Awesome Icon -->
        <link rel="stylesheet" href="css/font-awesome.min.css">

        <!-- Custom stlylesheet -->
        <link type="text/css" rel="stylesheet" href="css/style.css"/>

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->

    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <c:set value="${requestScope.detail_product}" var="d"/>
        <!-- BREADCRUMB -->
        <div id="breadcrumb" class="section">
            <!-- container -->
            <div class="container">
                <!-- row -->
                <div class="row">
                    <div class="col-md-12">
                        <ul class="breadcrumb-tree">
                            <li><a href="#">Home</a></li>
                            <li><a href="#">${d.category.name}</a></li>
                            
                            <li class="active">${d.title}</li>
                        </ul>
                    </div>
                </div>
                <!-- /row -->
            </div>
            <!-- /container -->
        </div>
        <!-- /BREADCRUMB -->

        <!-- SECTION -->
        <div class="section">
            <!-- container -->
            <div class="container">
                <!-- row -->
                <div class="row">
                    <!-- Product main img -->
                    <div class="col-md-5 col-md-push-2">
                        <div id="product-main-img">



                            <div class="product-preview">
                                <img src="${d.image}" alt="">
                            </div>
                        </div>
                    </div>
                    <!-- /Product main img -->

                    <!-- Product thumb imgs -->
                    <div class="col-md-2  col-md-pull-5">
                        <div id="product-imgs">
                            <div class="product-preview">
                                <img src="${d.image}" alt="">
                            </div>
                        </div>
                    </div>
                    <!-- /Product thumb imgs -->

                    <!-- Product details -->

                    <div class="col-md-5">
                        <div class="product-details">
                            <h2 class="product-name">${d.title}</h2>
                            <div>
                                <div class="product-rating">
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star-o"></i>
                                </div>
                                <a class="review-link" href="#">10 Review(s) | Add your review</a>
                            </div>
                            <div>
                                <c:if test="${d.discount != 0}">
                                    <h4 class="product-price">${d.price-(d.price * (d.discount/100))} $ <del class="product-old-price">${d.price}</del></h4>
                                    </c:if>
                                    <c:if test="${d.discount == 0}">
                                    <h4 class="product-price">${d.price} $ </h4>
                                </c:if>
                                    <span class="product-available"> <c:if test="${d.status==0}">OUT STOCK</c:if><c:if test="${d.status==1}">IN STOCK</c:if></span>
                            </div>
                            <p>${d.description}</p>

                            <div class="add-to-cart">
                             <a href="buy?id=${d.id}&check=3">    <button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i> add to cart</button></a>
                            </div>

                            <ul class="product-btns">
                                <li><a href="#"><i class="fa fa-heart-o"></i> add to wishlist</a></li>
                                <li><a href="#"><i class="fa fa-exchange"></i> add to compare</a></li>
                            </ul>

                            <ul class="product-links">
                                <li>Brand:</li>
                                <li><a href="brand?brand_id=${d.brand.id}">${d.brand.name}</a></li>
                            </ul>

                            <ul class="product-links">
                                <li>Share:</li>
                                <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                                <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                                <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
                                <li><a href="#"><i class="fa fa-envelope"></i></a></li>
                            </ul>

                        </div>
                    </div>
                    <!-- /Product details -->

                    <!-- Product tab -->
                    <div class="col-md-12">
                        <div id="product-tab">
                            <!-- product tab nav -->
                            <ul class="tab-nav">
                                <li class="active"><a data-toggle="tab" href="#tab1">Description</a></li>
                                <li><a data-toggle="tab" href="#tab3">Reviews (${requestScope.total}) </a></li>
                            </ul>
                            <!-- /product tab nav -->

                            <!-- product tab content -->
                            <div class="tab-content">
                                <!-- tab1  -->
                                <div id="tab1" class="tab-pane fade in active">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <p>${d.description}</p>
                                        </div>
                                    </div>
                                </div>
                                <!-- /tab1  -->

                                <!-- tab2  -->
                                <div id="tab2" class="tab-pane fade in">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                                        </div>
                                    </div>
                                </div>
                                <!-- /tab2  -->

                                <!-- tab3  -->
                                <div id="tab3" class="tab-pane fade in">
                                    <div class="row">
                                       <!-- Reviews -->
                                        <div class="col-md-6">
                                            <div id="reviews">
                                                <!--<form>-->
                                                <ul class="reviews">
                                                    <c:forEach items="${requestScope.listf}" var="f">
                                                        <li>
                                                            <div class="review-heading">
                                                                <h5 class="name">${f.user.username}</h5>
                                                                <p class="date">${f.date}</p>
                                                                <div class="review-rating">
                                                                    <c:forEach begin="1" end="${f.rating}">
                                                                        <i class="fa fa-star"></i>
                                                                    </c:forEach>
                                                                    <c:forEach begin="${f.rating}" end="4">
                                                                        <i class="fa fa-star-o empty"></i>
                                                                    </c:forEach>
                                                                </div>
                                                            </div>
                                                            <div class="review-body">
                                                                <p>${f.note}</p>
                                                            </div>
                                                            
                                                        </li>
                                                    </c:forEach>
                                                </ul>
                                                <!--</form>-->
                                               
                                            </div>
                                        </div>
                                        <!-- /Reviews -->
                                        <!-- Review Form -->
                                        <div class="col-md-6">
                                            <div id="review-form">
                                                <form id="f2" class="review-form" action="product" method="post">
                                                    <input type="hidden" name="id" value="${d.id}">
                                                    <textarea class="input" placeholder="Your Review" name="review" id="editor"></textarea>
                                                    <div class="input-rating">
                                                        <span>Your Rating: </span>
                                                        <div class="stars">
                                                            <input id="star5" name="rating" required="" value="5" type="radio"><label
                                                                for="star5"></label>
                                                            <input id="star4" name="rating" required="" value="4" type="radio"><label
                                                                for="star4"></label>
                                                            <input id="star3" name="rating" required="" value="3" type="radio"><label
                                                                for="star3"></label>
                                                            <input id="star2" name="rating" required="" value="2" type="radio"><label
                                                                for="star2"></label>
                                                            <input id="star1" name="rating" required="" value="1" type="radio"><label
                                                                for="star1"></label>
                                                        </div>
                                                    </div>
                                                    <!--</form>-->
                                                    <button class="primary-btn">Submit</button>
                                                </form>
                                            </div>
                                        </div>
                                        <!-- /Review Form -->
                                    </div>
                                </div>
                                <!-- /tab3  -->
                            </div>
                            <!-- /product tab content  -->
                        </div>
                    </div>
                    <!-- /product tab -->
                </div>
                <!-- /row -->
            </div>
            <!-- /container -->
        </div>
        <!-- /SECTION -->

        <!-- Section -->
        <div class="section">
            <!-- container -->
            <div class="container">
                <!-- row -->
                <div class="row">

                    <div class="col-md-12">
                        <div class="section-title text-center">
                            <h3 class="title">Related Products</h3>
                        </div>
                    </div>

                    <!-- product -->
                    <c:forEach items="${requestScope.list_related}" var="r">
                        
                              <div class="col-md-3 col-xs-6">
                                  <div class="product">
                                      <div class="product-img">
                                          <img src="${r.image}" width="200" height="150" alt="">
                                          <c:if test="${r.discount !=0}">
                                              <div class="product-label">
                                                  <span class="sale">-${r.discount}%</span>
                                              </div>
                                          </c:if>

                                      </div>
                                      <div class="product-body">
                                          <p class="product-category">${r.brand.name}</p>
                                          <h3 class="product-name"><a href="product?pid=${r.id}">${r.title}</a></h3>
                                              <c:if test="${r.discount != 0}">
                                              <h4 class="product-price">${r.price-(r.price * (r.discount/100))} $ <del class="product-old-price">${r.price}</del></h4>
                                              </c:if>
                                              <c:if test="${r.discount == 0}">
                                              <h4 class="product-price">${r.price} $ </h4>
                                          </c:if>
                                          <div class="product-rating">
                                          </div>
                                          <div class="product-btns">
                                              <button class="add-to-wishlist"><i class="fa fa-heart-o"></i><span class="tooltipp">add to wishlist</span></button>
                                              <button class="add-to-compare"><i class="fa fa-exchange"></i><span class="tooltipp">add to compare</span></button>
                                              <button class="quick-view"><i class="fa fa-eye"></i><span class="tooltipp">quick view</span></button>
                                          </div>
                                      </div>
                                      <div class="add-to-cart">
                                          <a href="buy?id=${r.id}&check=3">  <button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i> add to cart</button></a>
                                      </div>
                                  </div>
                              </div>
                    </c:forEach>
                    <!-- /product -->
                </div>
                <!-- /row -->
            </div>
            <!-- /container -->
        </div>
        <!-- /Section -->
 <script type="text/javascript">
            CKEDITOR.replace('editor');
            </script>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
