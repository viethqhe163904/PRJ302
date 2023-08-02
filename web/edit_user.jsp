<%-- 
    Document   : edit_user
    Created on : Mar 14, 2023, 8:50:35 PM
    Author     : manh3
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <!--  This file has been downloaded from bootdey.com @bootdey on twitter -->
        <!--  All snippets are MIT license http://bootdey.com/license -->
        <title>Laptop</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"></script>
        <style type="text/css">
            body {
                margin-top: 20px;
                background-color: #f2f6fc;
                color: #69707a;
            }
            .img-account-profile {
                height: 10rem;
            }
            .rounded-circle {
                border-radius: 50% !important;
            }
            .card {
                box-shadow: 0 0.15rem 1.75rem 0 rgb(33 40 50 / 15%);
            }
            .card .card-header {
                font-weight: 500;
            }
            .card-header:first-child {
                border-radius: 0.35rem 0.35rem 0 0;
            }
            .card-header {
                padding: 1rem 1.35rem;
                margin-bottom: 0;
                background-color: rgba(33, 40, 50, 0.03);
                border-bottom: 1px solid rgba(33, 40, 50, 0.125);
            }
            .form-control,
            .dataTable-input {
                display: block;
                width: 100%;
                padding: 0.875rem 1.125rem;
                font-size: 0.875rem;
                font-weight: 400;
                line-height: 1;
                color: #69707a;
                background-color: #fff;
                background-clip: padding-box;
                border: 1px solid #c5ccd6;
                -webkit-appearance: none;
                -moz-appearance: none;
                appearance: none;
                border-radius: 0.35rem;
                transition: border-color 0.15s ease-in-out, box-shadow 0.15s ease-in-out;
            }
            .nav-borders .nav-link.active {
                color: #0061f2;
                border-bottom-color: #0061f2;
            }
            .nav-borders .nav-link {
                color: #69707a;
                border-bottom-width: 0.125rem;
                border-bottom-style: solid;
                border-bottom-color: transparent;
                padding-top: 0.5rem;
                padding-bottom: 0.5rem;
                padding-left: 0;
                padding-right: 0;
                margin-left: 1rem;
                margin-right: 1rem;
            }
        </style>

    </head>

    <body>
        <div class="container-xl px-4 mt-4">
            <!-- Account page navigation-->
            <!--            <nav class="nav nav-borders">
                            <a class="nav-link active ms-0"
                               href="https://www.bootdey.com/snippets/view/bs5-edit-profile-account-details"
                               target="__blank">Profile</a>
                            <a class="nav-link" href="https://www.bootdey.com/snippets/view/bs5-profile-billing-page"
                               target="__blank">Billing</a>
                            <a class="nav-link" href="https://www.bootdey.com/snippets/view/bs5-profile-security-page"
                               target="__blank">Security</a>
                            <a class="nav-link" href="https://www.bootdey.com/snippets/view/bs5-edit-notifications-page"
                               target="__blank">Notifications</a>
                        </nav>-->
            <hr class="mt-0 mb-4">
            <div class="row">
                <c:set value="${sessionScope.user}" var="u"/>
                <div class="col-xl-8">
                    <!-- Account details card-->
                    <div class="card mb-4">
                        <div class="card-header">Account Details</div>
                        <div class="card-body">

                            <form action="edit" method="post">

                                <div class="mb-3">
                                    <label class="small mb-1" for="inputUsername">Username</label>
                                    <input class="form-control" id="inputUsername" type="text" readonly=""
                                           placeholder="Enter your username" value="${u.username}">
                                </div>

                                <div class="mb-3">
                                    <label class="small mb-1" for="inputEmailAddress">Email address</label>
                                    <input class="form-control" id="inputEmailAddress" type="email" name="email"
                                           placeholder="Enter your email address" value="${u.email}">
                                </div>
                                <!-- Form Row-->
                                <div class="row gx-3 mb-3">
                                    <!-- Form Group (phone number)-->
                                    <div class="col-md-6">
                                        <label class="small mb-1" for="inputPhone">Phone number</label>
                                        <input class="form-control" id="inputPhone" type="text" name="phone"
                                               placeholder="Enter your phone number" value="${u.phone_number}">
                                    </div>
                                    <!-- Form Group (birthday)-->
                                    <div class="col-md-6">
                                        <label class="small mb-1" for="inputBirthday">Address</label>
                                        <input class="form-control" id="inputBirthday" type="text" name="address"
                                               placeholder="Enter your address" value="${u.address}">
                                    </div>
                                </div>
                                <!-- Save changes button-->
                                <button class="btn btn-primary" type="submit">Save changes</button>
                                <a class="btn btn-success" href="home">Back To Home</a>
                            </form>
                            <h5 Style="color: red">${sessionScope.msg1}</h5>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>

</html>
