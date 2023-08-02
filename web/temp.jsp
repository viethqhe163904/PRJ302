<%-- 
    Document   : temp
    Created on : Mar 10, 2023, 4:19:44 PM
    Author     : manh3
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:set value="${requestScope.pp}" var="pp"/>
                                    <c:set value="${requestScope.pb}" var="pb"/>
                                        <form id="filter_price" action="store">
                                            <div class="input-checkbox">
                                                <input type="checkbox" id="p0" name="price" ${chid[0]?"checked":""} value="0" onclick="setCheckPrice(this)">
                                                <label for="category-1">
                                                    <span></span>
                                                    All price
                                                    <small>(120)</small>
                                                </label>
                                                <c:forEach begin="0" end="${5}" var="i">
                                                    <input type="checkbox" id="p1" name="price" ${chid[i+1]?"checked":"setCheckPrice(this)"} value="${i+1}" onclick="setCheckPrice(this)">
                                                    <label for="category-1">
                                                        <span></span>
                                                        ${pp[i]}
                                                        <small>(120)</small>
                                                    </label>
                                                </c:forEach>

// <c:set value="${requestScope.chid}" var="chid"/>
                                <div class="aside">
                                    <h3 class="aside-title">Brand</h3>
                                    <div class="checkbox-filter">
                                        <form id="filter_brand" action="store">
                                            <c:set var="b" value="${requestScope.brand}"/>
                                                <div class="input-checkbox">
                                                    <input type="checkbox" id="b0" name="brand" ${chid[0]?"checked":""} value="${0}" onclick="setCheckBrand(this)">
                                                    <label for="category-1">
                                                        <span></span>
                                                        All Brand
                                                        <small>(120)</small>
                                                    </label>
                                                    <c:forEach begin="0" end="${p.size()-1}" var="i">
                                                        <input type="checkbox" id="b1" name="brand" ${p.get(i).getId()==bid?"checked":""} value="${p.get(i).getId()}" onclick="setCheckBrand(this)">
                                                        <label for="category-1">
                                                            <span></span>
                                                            ${p.get(i).getName()}
                                                            <small>(120)</small>
                                                        </label>
                                                    </c:forEach>
    </body>
</html>
