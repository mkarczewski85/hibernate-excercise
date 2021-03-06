<%@ page language="java" contentType="text/html; harset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="car_rent.rent.Car" %>
<%@ page import="car_rent.rent.CarRepository" %>
<%@ page import="java.util.Optional" %>

<%
    Integer carId = Integer.valueOf(request.getParameter("carId"));
    Optional<Car> car = CarRepository.findCar(carId);
    if (car.isPresent()) {
        pageContext.setAttribute("car", car.get());
    }
%>
<jsp:include page="header.jsp"/>
<!-- Page Content -->
<div class="container">
    <br>
    <div class="row">

        <div class="col-lg-3">
            <div class="list-group">
                <form method="post" action="carSpec">
                    <input type="date" name="startDate" placeholder="Data początkowa"/>
                    <input type="date" name="endDate" placeholder="Data końcowa"/>
                    <input type="hidden" name="carId" value="${car.id}"/>
                    <button type="submit" class="btn btn-dark">Rezerwacja</button>
                </form>
            </div>
        </div>
        <!-- /.col-lg-3 -->

        <div class="col-lg-9">

            <div class="card mt-4">
                <img class="card-img-top img-fluid" src="" alt="">
                <div class="card-body">
                    <h3 class="card-title">${car.model}</h3>
                    <h4>${car.basePrice} PLN</h4>
                    <div class="card-text">Parametry:
                        <ul>
                            <li>Liczba osób: ${car.capacity}</li>
                            <li>Marka: ${car.make.name()}</li>
                            <li>Segment: ${car.carSegment.name()}</li>
                            <li>Kolor: ${car.color.name()}</li>
                            <li>Koszt ubezpieczenia: ${car.insuranceCost}</li>
                            <li>Silnik:
                                <ul>
                                    <li>Typ: ${car.engine.engineType.name()}</li>
                                    <li>Pojemność: ${car.engine.engineCapacity}</li>
                                    <li>Moc: ${car.engine.horsePower}</li>
                                    <li>Spalanie: ${car.engine.fuelConsumption}</li>
                                    <li>Skrzynia biegów: ${car.engine.gearBox.name()}</li>
                                    <li>Moment obrotowy: ${car.engine.torque}</li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                    <c:forEach items="${car.optionSet}" var="option">
                        <span>${option.name}</span>
                    </c:forEach>
                    <span class="text-warning">&#9733; &#9733; &#9733; &#9734; &#9734;</span>
                    3.0 stars
                </div>
            </div>
            <!-- /.card -->

            <div class="card card-outline-secondary my-4">
                <div class="card-header">
                    Product Reviews
                </div>
                <div class="card-body">
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Omnis et enim aperiam inventore,
                        similique necessitatibus neque non! Doloribus, modi sapiente laboriosam aperiam fugiat laborum.
                        Sequi mollitia, necessitatibus quae sint natus.</p>
                    <small class="text-muted">Posted by Anonymous on 3/1/17</small>
                    <hr>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Omnis et enim aperiam inventore,
                        similique necessitatibus neque non! Doloribus, modi sapiente laboriosam aperiam fugiat laborum.
                        Sequi mollitia, necessitatibus quae sint natus.</p>
                    <small class="text-muted">Posted by Anonymous on 3/1/17</small>
                    <hr>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Omnis et enim aperiam inventore,
                        similique necessitatibus neque non! Doloribus, modi sapiente laboriosam aperiam fugiat laborum.
                        Sequi mollitia, necessitatibus quae sint natus.</p>
                    <small class="text-muted">Posted by Anonymous on 3/1/17</small>
                    <hr>
                    <a href="#" class="btn btn-success">Leave a Review</a>
                </div>
            </div>
            <!-- /.card -->

        </div>
        <!-- /.col-lg-9 -->

    </div>

</div>
<!-- /.container -->

<jsp:include page="footer.jsp"/>