<%@ page language="java" contentType="text/html; harset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="car_rent.rent.Car" %>
<%@ page import="car_rent.rent.CarRepository" %>
<%@ page import="java.util.List" %>

<%
    List<Car> carList = CarRepository.findAll();
    pageContext.setAttribute("carList", carList);
%>
<jsp:include page="header.jsp"/>
<!-- Page Content -->
<div class="container">

    <div class="row">

        <div class="col-lg-3">
            <h1 class="my-4">Flota</h1>
            <div class="list-group">
                <a href="#" class="list-group-item active">Samochody osobowe</a>
                <a href="#" class="list-group-item">Samochody dostawcze</a>
                <a href="#" class="list-group-item">Pojazdy specjalne</a>
            </div>
        </div>
        <!-- /.col-lg-3 -->

        <div class="col-lg-9">

            <div class="row">
                <a href="/editCar" class="btn btn-primary">Dodaj</a>
            </div>

            <c:forEach items="${carList}" var="car">
                <div class="row">

                    <div class="col-md-8">
                        <p>${car.model}</p>
                    </div>
                    <div class="col-md-2">
                        <a href="/editCar?carId=${car.id}" class="btn btn-primary">Edytuj</a>
                    </div>

                    <div class="col-md-2">
                        <a href="/removeCar?carId=${car.id}" class="btn btn-primary">Usuń</a>
                    </div>

                </div>
            </c:forEach>
            <!-- /.card -->

        </div>
        <!-- /.col-lg-9 -->

    </div>

</div>
<!-- /.container -->
<jsp:include page="footer.jsp"/>