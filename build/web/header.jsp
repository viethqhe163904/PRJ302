<%-- 
   Document   : header.jsp
   Created on : Feb 26, 2023, 9:29:20 PM
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

        <title>Electro</title>

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
        <!-- HEADER -->
        <header>
            <!-- TOP HEADER -->
            <div id="top-header">
                <div class="container">
                    <ul class="header-links pull-left">
                        <li><a href="#"><i class="fa fa-phone"></i> +84-868-046-261</a></li>
                        <li><a href="#"><i class="fa fa-envelope-o"></i> viethqhe163904@email.com</a></li>
                        <li><a href="#"><i class="fa fa-map-marker"></i> Sao Hoa</a></li>
                    </ul>
                    <ul class="header-links pull-right">
                        <li style="font-size: 14px;"><a href="#"><i class="fa fa-facebook-official"></i></a></li>
                        <li style="font-size: 14px;"><a href="#"><i class="fa fa-instagram"></i></a></li>
                        <li style="font-size: 14px;"><a href="#"><i class="fa fa-youtube-play"></i></a></li>
                        <li style="font-size: 14px;"><a href="#"><i class="fa fa-pinterest"></i></a></li>
                    </ul>
                </div>
            </div>
            <!-- /TOP HEADER -->


            <!-- MAIN HEADER -->
            <div id="header">
                <!-- container -->
                <div class="container">
                    <!-- row -->
                    <div class="row">
                        <!-- LOGO -->
                        <div class="col-md-3">
                            <div class="header-logo">
                                <a href="home" class="logo">
                                    <img src="./img/logo.png" alt="">
                                </a>
                            </div>
                        </div>
                        <!-- /LOGO -->

                        <!-- SEARCH BAR -->
                        <div class="col-md-6">
                            <div class="header-search">
                                <form action="store1" method="get">
                                    <select name="bid" class="input-select">
                                        <c:forEach items="${requestScope.list_bSearch}" var="b">
                                            <option <c:if test="${bid==b.id}">selected</c:if> value="${b.id}"  >${b.name}</option>
                                        </c:forEach>
                                    </select>

                                    <input name="search" class="input" placeholder="Search here">
                                    <button class="search-btn">Search</button>
                                </form>
                            </div>
                        </div>
                        <!-- /SEARCH BAR -->
                        <!-- ACCOUNT -->
                        <div class="col-md-3 clearfix">
                            <div class="header-ctn">
                                <!-- My Account -->
                                <div class="dropdown">
                                    <a class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true">
                                        <i class="fa fa-user-o"></i>
                                        <c:if test="${sessionScope.user !=null}">
                                            <span>${sessionScope.user.getUsername()}</span>
                                        </c:if>
                                        <c:if test="${sessionScope.user ==null}">
                                            <span>My Account</span>
                                        </c:if>
                                    </a>
                                    <!-- <a href="#" class="text-uppercase">Login</a> / <a href="#" class="text-uppercase">Join</a> -->
                                    <div style="width: 195px" class="cart-dropdown">
                                        <ul class="custom-menu">
                                            <c:if test="${sessionScope.user !=null}">
                                                <li><a href="edit_user.jsp">
                                                        <div class="icon"><i class="fa fa-user"></i> </div> Change profile
                                                    </a></li>
                                                </c:if>
                                                <c:if test="${sessionScope.user ==null}">
                                                <li><a href="login">
                                                        <div class="icon"><i class="fa fa-user"></i> </div> Hello Customer
                                                    </a></li>
                                                </c:if>
                                                <c:if test="${sessionScope.user !=null}">
                                                <li><a href="login">
                                                        <div class="icon"><i class="fa fa-user"></i> </div> Hello ${sessionScope.user.getUsername()}
                                                    </a></li>
                                                </c:if>
                                                <c:if test="${sessionScope.user.getRole_id()==1}">
                                                <li><a href="crud">
                                                        <div class="icon"><i class="fa fa-tachometer"></i> </div> Manage Product
                                                    </a></li>
                                                <li><a href="crud_category">
                                                        <div class="icon"><i class="fa fa-tachometer"></i> </div> Manage Category
                                                    </a></li>
                                                     <li><a href="crud_brand">
                                                        <div class="icon"><i class="fa fa-tachometer"></i> </div> Manage Brand
                                                    </a></li>
                                                </c:if> 
                                                <c:if test="${sessionScope.user ==null}">
                                                <li><a href="login">
                                                        <div class="icon"><i class="fa fa-unlock-alt"></i> </div> Login
                                                    </a></li>
                                                </c:if>

                                            <li><a href="register">
                                                    <div class="icon"><i class="fa fa-user-plus"></i> </div> Create An
                                                    Account
                                                </a></li>
                                                <c:if test="${sessionScope.user !=null}">
                                                <li><a href="logout">
                                                        <div class="icon"><i class="fa fa-sign-out"></i> </div> Log out
                                                    </a></li>
                                                </c:if>
                                        </ul>
                                    </div>
                                </div>
                                <!-- My Account -->


                                <!-- Cart -->

                                <c:if test="${sessionScope.user != null}">
                                    <div class="dropdown">
                                        <a class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true">
                                            <i class="fa fa-shopping-cart"></i>
                                            <span>Your Cart</span>
                                            <div class="qty">${sessionScope.cart.getSize()}</div>
                                        </a>
                                        <div class="cart-dropdown">
                                            <div class="cart-list">
                                                <c:set var="o" value="${sessionScope.cart}"/>
                                                <c:forEach items="${o.getItems()}" var="i">
                                                    <div class="product-widget">
                                                        <div class="product-img">
                                                            <img src="${i.product.image}" alt="">
                                                        </div>
                                                        <div class="product-body">
                                                            <h3 class="product-name"><a href="#">${i.product.title}</a></h3>
                                                            <h4 class="product-price"><span class="qty">${i.quantity}x</span>${i.quantity * i.price}0$</h4>
                                                        </div>
                                                        <button class="delete"><a href="deletecart?rid=${i.product.id}" > <i class="fa fa-close"> </i></a> </button>
                                                    </div>
                                                </c:forEach>
                                            </div>
                                            <div class="cart-summary">
                                                <h5>SUBTOTAL: ${sessionScope.cart.getTotalMoney()}0$</h5>
                                            </div>
                                            <div class="cart-btns">
                                                <a href="cart">View Cart</a>
                                                <a href="checkout">Checkout  <i class="fa fa-arrow-circle-right"></i></a>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- /Cart -->
                                </c:if>
                                <!-- Menu Toogle -->
                                <div class="menu-toggle">
                                    <a href="#">
                                        <i class="fa fa-bars"></i>
                                        <span>Menu</span>
                                    </a>
                                </div>
                                <!-- /Menu Toogle -->
                            </div>
                        </div>
                        <!-- /ACCOUNT -->
                    </div>
                    <!-- row -->
                </div>
                <!-- container -->
            </div>
            <!-- /MAIN HEADER -->
            <!-- NAVIGATION -->

            <!-- /NAVIGATION -->
        </header>
        <!-- /HEADER -->
        <nav id="navigation">
            <!-- container -->
            <div class="container">
                <!-- responsive-nav -->
                <div id="responsive-nav">
                    <!-- NAV -->
                    <ul class="main-nav nav navbar-nav">
                        <li class="active"><a href="home">Home</a></li>
                        <li><a href="store">Shop</a></li>
                        <li><a href="cart">Card</a></li>
                        <li><a href="checkout">Check out</a></li>
                            <c:if test="${sessionScope.user.getRole_id() ==1}">
                            <li><a href="statistics">statistics</a></li>
                            </c:if>
                    </ul>
                    <!-- /NAV -->
                </div>
                <!-- /responsive-nav -->
            </div>
            <!-- /container -->
        </nav>

        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/slick.min.js"></script>
        <script src="js/nouislider.min.js"></script>
        <script src="js/jquery.zoom.min.js"></script>
        <script src="js/main.js"></script>
        <script src="./js/main3.js"></script>
        <script src="./ckeditor/ckeditor.js"></script>
    </body>
</html>
