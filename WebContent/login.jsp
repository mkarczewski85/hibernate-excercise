<%@ page import="car_rent.account.User" %>
<%@ page import="java.util.Optional" %>
<%@ page import="car_rent.account.UserRepository" %>
<%@ page language="java" contentType="text/html; harset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Page Content -->
<%
    Cookie[] cookies = request.getCookies();
    for (Cookie c : cookies) {
        if (c.getName().equals("remember")) {
            Optional<User> userByMail = UserRepository.findUserByMail(c.getValue());
            if (userByMail.isPresent()) {
                request.getSession().setAttribute("userId", userByMail.get().getId());
                response.sendRedirect("index.jsp");
                return;
            }

        }
    }

    String error = request.getParameter("error");
    if (error != null && error.equals("true")) {
        pageContext.setAttribute("error", error);
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

<div class="container">

    <div class="card card-container">
        <img id="profile-img" class="profile-img-card" src="//ssl.gstatic.com/accounts/ui/avatar_2x.png"/>
        <p id="profile-name" class="profile-name-card"></p>
        <form class="form-signin" action="login" method="post">
            <span id="reauth-email" class="reauth-email"></span>
            <input type="email" id="inputEmail" name="email" class="form-control" placeholder="Adres e-mail" required
                   autofocus>
            <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Hasło" required>
            <c:if test="${not empty error}">
                <div>
                    <p class="alert alert-warning">Nieprawidłowy login lub hasło</p>
                </div>
            </c:if>
            <div id="remember" class="checkbox">
                <label>
                    <input type="checkbox" value="remember-me" name="remember"> Zapamiętaj mnie
                </label>
            </div>
            <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Zaloguj się</button>
            <button class="btn btn-lg btn-primary btn-block btn-signin" href="register.jsp">Zarejestruj się</button>
        </form><!-- /form -->
        <a href="#" class="forgot-password">
            Zapomniałeś hasła?
        </a>
    </div>


</div>

<!-- /.container -->
<jsp:include page="footer.jsp"/>