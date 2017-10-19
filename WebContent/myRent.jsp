<%@ page language="java" contentType="text/html; harset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="car_rent.rent.Rent" %>
<%@ page import="car_rent.rent.RentRepository" %>
<%@ page import="java.util.List" %>

<%
    List<Rent> rentList = RentRepository.findByUserId(7);
    pageContext.setAttribute("rentList", rentList);
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
            <c:forEach items="${rentList}" var="rent">
                <div class="row">

                    <div class="col-md-2">
                        <p>${rent.car.model}</p>
                    </div>
                    <div class="col-md-2">
                        <p>${rent.car.basePrice} PLN</p>
                    </div>
                    <div class="col-md-2">
                        <p>${rent.startDate.toLocalDate()}</p>
                    </div>
                    <div class="col-md-2">
                        <p>${rent.endDate.toLocalDate()}</p>
                    </div>
                    <div class="col-md-2">
                        <p>${rent.rentPrice}</p>
                    </div>
                    <div class="col-md-2">
                        <a href="/details.jsp?carId=${rent.car.id}" class="btn btn-primary">Szczegóły oferty</a>
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