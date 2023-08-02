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
        <script type="text/javascript">

            function setCheck(obj) {
                var fries = document.getElementsByName('cidd');
                if ((obj.id == 'b0') && (fries[0].checked == true))
                {
                    for (var i = 1; i < fries.length; i++)
                        fries[i].checked = false;
                } else {
                    for (var i = 1; i < fries.length; i++) {
                        if (fries[i].checked == true) {
                            fries[0].checked = false;
                            break;
                        }
                    }
                }
                document.getElementById('f2').submit();
            }
            function setCheck1(obj) {
                var fries = document.getElementsByName('price');
                if ((obj.id == 'price-0') && (fries[0].checked == true))
                {
                    for (var i = 1; i < fries.length; i++)
                        fries[i].checked = false;
                } else {
                    for (var i = 1; i < fries.length; i++) {
                        if (fries[i].checked == true) {
                            fries[0].checked = false;
                            break;
                        }
                    }
                }
                document.getElementById('f1').submit();
            }
            function f3(obj) {
                 var fries = document.getElementsByName('sort');
                document.getElementById('f3').submit();
            }


        </script>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

        <title>Shop</title>

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
                            <li class="active">Laptop</li>
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
                                <c:set var="pp" value="${requestScope.pp}"/>
                                <c:set var="pb" value="${requestScope.pb}"/>
                                <form id="f1" action="store1" method="get">
                                    <div class="input-checkbox">
                                        <input type="checkbox" id="g0" name="price" ${pb[0]?"checked":""}  value="${0}" onclick="setCheck1(this)"/>
                                        <label for="g0">
                                            <span></span>
                                            All
                                        </label>
                                    </div>
                                    <c:forEach begin="0" end="${4}"  var="i">
                                        <div class="input-checkbox">
                                            <input type="checkbox" id="price-${i}" name="price" ${pb[i+1]?"checked":""} value="${(i+1)}" onclick="setCheck1(this)"/>
                                            <label for="price-${i}">
                                                <span></span>
                                                ${pp[i]}
                                            </label>
                                        </div>
                                    </c:forEach>
                                </form>
                            </div>
                        </div>

                        <!-- /aside Widget -->
                        <!-- aside Widget -->

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
                                <form  name="f3" action="store1" method="post">
                                    <label>
                                        Sort By:
                                        <select class="input-select" name="sort">
                                            <option value="0" onclick="f3(this)">Price</option>
                                            <option value="1" onclick="f3(this)" >Discount</option>
                                        </select>
                                    </label>
                                </form>
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
                            <c:forEach items="${requestScope.list_p}" var="p"><!-- /product  hien ra tât ca san pham theo category va search-->
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
                                            <a href="buy?id=${p.id}&check=2&cid=${p.category.id}">   <button type="submit"  class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i> add to cart</button></a>
                                        </div>
                                    </div>
                                </div>
                                <!-- /product -->
                            </c:forEach>
                            <div class="clearfix visible-sm visible-xs"></div>
                            <div class="clearfix visible-lg visible-md"></div>
                            <!-- store bottom filter -->
                            <div class="store-filter clearfix">
                                <span class="store-qty">Showing products</span>
                                <ul class="store-pagination">
                                    <c:forEach begin="1" end="${requestScope.end_page}" var="i">
                                        <li><a href="store?page=${i}"> ${i}</a></li>
                                        </c:forEach> 
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

