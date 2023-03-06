<%-- 
    Document   : store
    Created on : Mar 3, 2023, 4:34:06 PM
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

        <title>Electro - HTML Ecommerce Template</title>

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
        <!-- BREADCRUMB -->
        <div id="breadcrumb" class="section">
            <!-- container -->
            <div class="container">
                <!-- row -->
                <div class="row">
                    <div class="col-md-12">
                        <ul class="breadcrumb-tree">
                            <li><a href="#">Home</a></li>
                            <li><a href="#">All Categories</a></li>
                            <li><a href="#">Accessories</a></li>
                            <li class="active">Headphones (227,490 Results)</li>
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
                    <!-- ASIDE -->
                    <div id="aside" class="col-md-3">
                        <!-- aside Widget -->
                        <div class="aside">
                            <h3 class="aside-title">Price</h3>
                            <div class="checkbox-filter">
                                <a href="store" class="cta-btn">500 - 1000 $<i class="fa fa-arrow-circle-right"></i></a> <br>
                                <br>
                                    <a href="store" class="cta-btn">1000 - 1500 $<i class="fa fa-arrow-circle-right"></i></a> <br>
                                <br>
                                    <a href="store" class="cta-btn">1500 - 2000 $<i class="fa fa-arrow-circle-right"></i></a> <br>
                                    <br>
                                   <a href="store" class="cta-btn">2000 - 2500 $<i class="fa fa-arrow-circle-right"></i></a> <br>
                                <br>
                                   <a href="store" class="cta-btn">Upper 3000 $<i class="fa fa-arrow-circle-right"></i></a> <br>
                                <br>
                            </div>
                        </div>
                        <!-- /aside Widget -->
                        <!-- aside Widget -->
                        <div class="aside">
                            <h3 class="aside-title">Brand</h3>
                            <div class="checkbox-filter">
                                <div class="input-checkbox">
                                    <input type="checkbox" id="brand-1" name="brand">
                                    <label for="brand-1">
                                        <span></span>
                                        SAMSUNG
                                        <small>(578)</small>
                                    </label>
                                </div>
                                <div class="input-checkbox">
                                    <input type="checkbox" id="brand-2">
                                    <label for="brand-2">
                                        <span></span>
                                        LG
                                        <small>(125)</small>
                                    </label>
                                </div>
                                <div class="input-checkbox">
                                    <input type="checkbox" id="brand-3">
                                    <label for="brand-3">
                                        <span></span>
                                        SONY
                                        <small>(755)</small>
                                    </label>
                                </div>
                                <div class="input-checkbox">
                                    <input type="checkbox" id="brand-4">
                                    <label for="brand-4">
                                        <span></span>
                                        SAMSUNG
                                        <small>(578)</small>
                                    </label>
                                </div>
                                <div class="input-checkbox">
                                    <input type="checkbox" id="brand-5">
                                    <label for="brand-5">
                                        <span></span>
                                        LG
                                        <small>(125)</small>
                                    </label>
                                </div>

                            </div>
                        </div>

                        <!-- /aside Widget -->

                        <!-- aside Widget -->
                        <div class="aside">
                            <h3 class="aside-title">Top selling</h3>
                            <c:forEach items="${list_p3}" var="p3">
                                <div class="product-widget">
                                    <div class="product-img">
                                        <img src="${p3.image}"width="100" height="80"alt="">
                                    </div>
                                    <div class="product-body">
                                        <p class="product-category"></p>
                                        <h3 class="product-name"><a href="product?pid=${p3.id}">${p3.title}</a></h3>
                                        <h4 class="product-price">${p3.price-(p3.price * (p3.discount/100))} $ <del class="product-old-price">${p3.price}</del></h4>
                                    </div>
                                </div>
                            </c:forEach>

                        </div>
                        <!-- /aside Widget -->
                    </div>
                    <!-- /ASIDE -->

                    <!-- STORE -->
                    <div id="store" class="col-md-9">
                        <!-- store top filter -->
                        <div class="store-filter clearfix">
                            <div class="store-sort">
                                <label>
                                    Sort By:
                                    <select class="input-select">
                                        <option value="0">Popular</option>
                                        <option value="1">Position</option>
                                    </select>
                                </label>

                                <label>
                                    Show:
                                    <select class="input-select">
                                        <option value="0">20</option>
                                        <option value="1">50</option>
                                    </select>
                                </label>
                            </div>
                            <ul class="store-grid">
                                <li class="active"><i class="fa fa-th"></i></li>
                                <li><a href="#"><i class="fa fa-th-list"></i></a></li>
                            </ul>
                        </div>
                        <!-- /store top filter -->

                        <!-- store products -->

                        <div class="row">
                            <!-- product -->
                            <c:forEach items="${requestScope.list_p}" var="p">
                                <div class="col-md-4 col-xs-6">
                                    <div class="product">
                                        <div class="product-img">
                                            <img src="${p.image}" width="250" height="250" alt="">

                                        </div>
                                        <div class="product-body">
                                            <p class="product-category">${p.brand.name}</p>
                                            <h3 class="product-name"><a href="product?pid=${p.id}">${p.title}</a></h3>
                                                <c:if test="${p.discount != 0}">
                                                <h4 class="product-price">${p.price-(p.price * (p.discount/100))} $ <del class="product-old-price">${p.price}</del></h4>
                                                </c:if>
                                                <c:if test="${p.discount == 0}">
                                                <h4 class="product-price">${p.price} $ </h4>
                                            </c:if>
                                            <div class="product-rating">
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                            </div>
                                            <div class="product-btns">

                                                <button class="quick-view"><i class="fa fa-eye"></i><span class="tooltipp">quick view</span></button>
                                            </div>
                                        </div>
                                        <div class="add-to-cart">
                                            <button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i> add to cart</button>
                                        </div>
                                    </div>
                                </div>
                                <!-- /product -->
                            </c:forEach>
                            <c:if test="${requestScope.ids==6}">  <!-- /product  hien ra tât ca san pham-->
                                <c:forEach items="${requestScope.list_ps}" var="p1">
                                    <div class="col-md-4 col-xs-6">
                                        <div class="product">
                                            <div class="product-img">
                                                <img src="${p1.image}" width="250" height="250" alt="">

                                            </div>
                                            <div class="product-body">
                                                <p class="product-category">${p1.brand.name}</p>
                                                <h3 class="product-name"><a href="product?pid=${p1.id}">${p1.title}</a></h3>
                                                    <c:if test="${p1.discount != 0}">
                                                    <h4 class="product-price">${p1.price-(p1.price * (p1.discount/100))} $ <del class="product-old-price">${p1.price}</del></h4>
                                                    </c:if>
                                                    <c:if test="${p1.discount == 0}">
                                                    <h4 class="product-price">${p1.price} $ </h4>
                                                </c:if>
                                                <div class="product-rating">
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                    <i class="fa fa-star"></i>
                                                </div>
                                                <div class="product-btns">

                                                    <button class="quick-view"><i class="fa fa-eye"></i><span class="tooltipp">quick view</span></button>
                                                </div>
                                            </div>
                                            <div class="add-to-cart">
                                                <button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i> add to cart</button>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- /product -->
                                </c:forEach>
                            </c:if>
                            <c:forEach items="${requestScope.list_search}" var="p2"> <!-- /product hienm thi cac product theo search -->
                                <div class="col-md-4 col-xs-6">
                                    <div class="product">
                                        <div class="product-img">
                                            <img src="${p2.image}" width="250" height="250" alt="">

                                        </div>
                                        <div class="product-body">
                                            <p class="product-category"</p>
                                            <h3 class="product-name"><a href="product?pid=${p2.id}">${p2.title}</a></h3>
                                                <c:if test="${p2.discount != 0}">
                                                <h4 class="product-price">${p2.price-(p2.price * (p2.discount/100))} $ <del class="product-old-price">${p2.price}</del></h4>
                                                </c:if>
                                                <c:if test="${p2.discount == 0}">
                                                <h4 class="product-price">${p2.price} $ </h4>
                                            </c:if>
                                            <div class="product-rating">
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                            </div>
                                            <div class="product-btns">

                                                <button class="quick-view"><i class="fa fa-eye"></i><span class="tooltipp">quick view</span></button>
                                            </div>
                                        </div>
                                        <div class="add-to-cart">
                                            <button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i> add to cart</button>
                                        </div>
                                    </div>
                                </div>
                                <!-- /product -->
                            </c:forEach>
                                
                                
                               
                                              
                            <div class="clearfix visible-sm visible-xs"></div>
                            <div class="clearfix visible-lg visible-md"></div>
                            <!-- store bottom filter -->
                            <div class="store-filter clearfix">
                                <span class="store-qty">Showing 20-100 products</span>
                                <ul class="store-pagination">
                                    <li class="active">1</li>
                                    <li><a href="#">2</a></li>
                                    <li><a href="#">3</a></li>
                                    <li><a href="#">4</a></li>
                                    <li><a href="#"><i class="fa fa-angle-right"></i></a></li>
                                </ul>
                            </div>
                            <!-- /store bottom filter -->
                        </div>
                        <!-- /STORE -->
                    </div>
                    <!-- /row -->
                </div>
                <!-- /container -->
            </div>
            <!-- /SECTION -->


            <jsp:include page="footer.jsp"/>
            <!-- jQuery Plugins -->
            <script src="js/jquery.min.js"></script>
            <script src="js/bootstrap.min.js"></script>
            <script src="js/slick.min.js"></script>
            <script src="js/nouislider.min.js"></script>
            <script src="js/jquery.zoom.min.js"></script>
            <script src="js/main.js"></script>

    </body>
</html>

