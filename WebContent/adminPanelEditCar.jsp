<%@ page import="car_rent.rent.CarRepository" %>
<%@ page import="car_rent.rent.Car" %>
<%@ page import="car_rent.rent.CarSegment" %>
<%@ page import="car_rent.rent.Make" %>
<%@ page import="car_rent.rent.Color" %>
<%@ page import="car_rent.rent.EngineType" %>
<%@ page import="car_rent.rent.GearBox" %>
<%@ page import="java.util.Optional" %>
<%@ page language="java" contentType="text/html; harset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Page Content -->
<%
    String carId = request.getParameter("carId");
    Integer id = null;

    try {
        id = Integer.valueOf(carId);
    } catch (Exception e) {
        e.printStackTrace();
    }
    if (id != null){
        Optional<Car> car = CarRepository.findCar(id);
        if (car.isPresent()) {

            pageContext.setAttribute("car", car.get());
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

<div class="container">

    <div class="card card-container">
        <form class="form-signin" action="/editCar" method="post">

            <input type="hidden" id="id" name="id" class="form-control" value="${car.id}">

            <input type="text" id="model" name="model" class="form-control" value="${car.model}"
                   placeholder="Model samochodu" required autofocus>

            <input type="number" id="insuranceCost" name="insuranceCost" class="form-control" value="${car.insuranceCost}"
                   placeholder="Koszt ubezpieczenia" required autofocus>

            <input type="number" id="capacity" name="capacity" class="form-control" value="${car.capacity}"
                   placeholder="Pojemność" required autofocus>

            <select class="form-control" name="segment">
            <c:forEach var="segment" items="CarSegment.values()">
                <option value="${segment}">${segment}</option>
            </c:forEach>
            </select>

            <select class="form-control" name="make">
                <c:forEach var="make" items="Make.values()">
                    <option value="${make}">${make}</option>
                </c:forEach>
            </select>

            <select class="form-control" name="color">
                <c:forEach var="color" items="Color.values()">
                    <option value="${color}">${color}</option>
                </c:forEach>
            </select>

            <select class="form-control" name="gearBox">
                <c:forEach var="gearBox" items="GearBox.values()">
                    <option value="${gearBox}">${gearBox}</option>
                </c:forEach>
            </select>

            <select class="form-control" name="engineType">
                <c:forEach var="engineType" items="EngineType.values()">
                    <option value="${engineType}">${engineType}</option>
                </c:forEach>
            </select>

            <input type="number" id="torque" name="torque" class="form-control" value="${car.engine.torque}"
                   placeholder="Moment obrotowy" required autofocus>

            <input type="number" id="horsePower" name="horsePower" class="form-control" value="${car.engine.horsePower}"
                   placeholder="Konie mechanicze" required autofocus>

            <input type="number" id="fuelConsumption" name="fuelConsumption" class="form-control" value="${car.engine.fuelConsumption}"
                   placeholder="Spalanie" required autofocus>

            <input type="number" id="engineCapacity" name="engineCapacity" class="form-control" value="${car.engine.engineCapacity}"
                   placeholder="Pojemność silnika" required autofocus>

            <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Zarejestruj się</button>

        </form><!-- /form -->

    </div>


</div>

<!-- /.container -->
<jsp:include page="footer.jsp"/>