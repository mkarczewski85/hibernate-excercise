<%@ page import="java.util.HashMap" %>
<%@ page language="java" contentType="text/html; harset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Page Content -->
<%
    HashMap<String, String> error = (HashMap<String, String>) request.getAttribute("error");
    if (error != null){
        pageContext.setAttribute("error", error);
    }

    HashMap<String, String> variable = (HashMap<String, String>) request.getAttribute("variable");
    if (variable != null){
        pageContext.setAttribute("variable", variable);
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

        <form class="form-signin" action="signup" method="post">
            <span id="reauth-email" class="reauth-email"></span>

            <input type="email" id="inputEmail" name="email" class="form-control" value="${variable.get("email")}" placeholder="Adres e-mail" required
                   autofocus>
            <p class="alert-warning">${error.get("email")}</p>

            <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Hasło" required>
            <p class="alert-warning">${error.get("password")}</p>

            <input type="password" id="inputPassword2" name="passwordRepeat" class="form-control" placeholder="Powtórz hasło" required>
            <p class="alert-warning">${error.get("passwordRepeat")}</p>

            <input type="text" id="firstName" name="firstName" class="form-control" value="${variable.get("firstName")}" placeholder="Imię" required>
            <p class="alert-warning">${error.get("firstName")}</p>

            <input type="text" id="lastName" name="lastName" class="form-control" value="${variable.get("lastName")}" placeholder="Nazwisko" required>
            <p class="alert-warning">${error.get("lastName")}</p>

            <input type="text" id="phoneNumber" name="phoneNumber" class="form-control" value="${variable.get("phoneNumber")}" placeholder="Numer telefonu" required>
            <p class="alert-warning">${error.get("phoneNumber")}</p>

            <label>Data urodzenia</label>
            <input type="date" id="dayOfBirth" name="dayOfBirth" class="form-control" required>
            <p class="alert-warning">${error.get("dayOfBirth")}</p>

            <label>Data wydania prawa jazdy</label>
            <input type="date" id="licenseDate" name="licenseDate" class="form-control" required>
            <p class="alert-warning">${error.get("licenseDate")}</p>

            <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Zarejestruj się</button>
        </form><!-- /form -->

    </div>


</div>

<!-- /.container -->
<jsp:include page="footer.jsp"/>