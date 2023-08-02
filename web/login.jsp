<%-- 
    Document   : login
    Created on : Feb 26, 2023, 11:23:32 PM
    Author     : manh3
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

        <!-- Loding font -->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:300,700" rel="stylesheet">

        <!-- Custom Styles -->
        <link rel="stylesheet" type="text/css" href="css/styles1.css">

        <title>Login</title>
    </head>
    <body>

        <!-- Backgrounds -->

        <div id="login-bg" class="container-fluid">

            <div class="bg-img"></div>
            <div class="bg-color"></div>
        </div>

        <!-- End Backgrounds -->

        <div class="container" id="login">
            <div class="row justify-content-center">
                <div class="col-lg-8">
                    <div class="login">

                        <h1>Login</h1>

                        <!-- Loging form -->
                        <form action="login" method="post">
                            <c:if test="${sessionScope.msg!=null}">
                                <div class="alert alert-danger" role="alert" >
                                    ${sessionScope.msg}
                                </div>
                            </c:if>
                            <div class="form-group">
                                <input type="text" name="user" class="form-control" id="exampleInputEmail1 " aria-describedby="emailHelp" placeholder="Enter user name">

                            </div>

                            <div class="form-group">
                                <input type="password" name="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
                            </div>

                            <div class="form-check">

                                <label class="switch">
                                    <input type="checkbox">
                                    <span class="slider round"></span>
                                </label>
                                <label class="form-check-label" for="exampleCheck1">Remember me</label>

                                <label class="forgot-password"><a href="forgot">Forgot Password?<a></label>

                                            </div>
                                            <br>
                                            <button type="submit" class="btn btn-lg btn-block btn-success">Sign in</button><br>
                                            <div>
                                                <label class="forgot-password"><a href="register">Sign in new account<a></label>
                                                            </div>
                                                            </form>
                                                            <!-- End Loging form -->

                                                            </div>
                                                            </div>
                                                            </div>
                                                            </div>


                                                            </body>
                                                            </html>