<%@ page import="car_rent.rent.Customer" %>
<%@ page import="car_rent.rent.CustomerRepository" %>
<%@ page import="java.util.Optional" %>
<%@ page import="car_rent.account.UserRepository" %>
<%@ page import="car_rent.account.User" %>
<%@ page language="java" contentType="text/html; harset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    Integer userId = (Integer) request.getSession().getAttribute("userId");
    if (userId == null) {

    }

    if (userId != null) {
        Optional<Customer> customer = CustomerRepository.findById(userId);
        if (customer.isPresent()) {
            pageContext.setAttribute("customer", customer.get());
        }
    }
%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Wypożyczalnia samochodów</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/shop-item.css" rel="stylesheet">

</head>

<body>
<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <a class="navbar-brand" href="#">Wypożyczalnia</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive"
                aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">

                <li class="nav-item">
                    <c:if test="${empty customer}">
                        <a class="nav-link btn-danger btn" href="/login.jsp">Zaloguj</a>
                    </c:if>

                    <c:if test="${not empty customer}">
                        <a class="nav-link btn-danger btn" href="/logout">Wyloguj</a>
                    </c:if>
                </li>

                <li>
                    <c:if test="${not empty customer}">
                        <a class="nav-link btn-danger btn" href="/adminPanelOptionList.jsp">Dodawanie opcji</a>
                    </c:if>
                </li>

                <li class="nav-item">${customer.name} ${customer.lastName}</li>

                <li class="nav-item active">
                    <a class="nav-link" href="#">Strona Główna
                        <span class="sr-only">(current)</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/myRent.jsp">Historia</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Usługi</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Kontakt</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

