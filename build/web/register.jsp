<%-- 
    Document   : register
    Created on : Mar 2, 2023, 1:21:42 AM
    Author     : manh3
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- Designined by CodingLab - youtube.com/codinglabyt -->
<html lang="en" dir="ltr">
    <head>
        <meta charset="UTF-8">
        <title style="color: red"> SIGN UP</title>
        <link rel="stylesheet" href="css/style2.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>

        <div class="container" >
            <div class="title" style="color: #ff0000">SIGN UP</div>
            <div class="content">
                <form action="register" method="post">
                    <c:if test="${msg!=null}">
                        <div class="alert alert-danger" role="alert" >
                            ${requestScope.msg}
                        </div>
                    </c:if>
                    <div class="user-details">
                        <div class="input-box">
                            <span class="details">Username</span>
                            <input type="text" name="username" placeholder="Enter your username" required>
                        </div>
                        <div class="input-box">
                            <span class="details">Email</span>
                            <input type="text" name="mail" placeholder="Enter your email" required>
                        </div>
                        <div class="input-box">
                            <span class="details">Password</span>
                            <input type="password" name="password" placeholder="Enter your number" required>
                        </div>
                        <div class="input-box">
                            <span class="details">Phone Number</span>
                            <input type="text" name="phone" placeholder="Enter your password" required>
                        </div>
                        <div class="input-box">
                            <span class="details">Confirm Password</span>
                            <input type="password" name="confirmpassword" placeholder="Confirm your password" required>
                        </div>
                        <div class="input-box">
                            <span class="details">Adress</span>
                            <input type="text" name="adress" placeholder="Enter your adress" required>
                        </div>
                    </div>

                    <div class="button" style="color: #ff0000">
                        <input type="submit" value="SIGN UP" >
                    </div>
                </form>
            </div>
        </div>

    </body>
</html>

