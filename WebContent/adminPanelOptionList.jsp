<%@ page language="java" contentType="text/html; harset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="car_rent.rent.Option" %>
<%@ page import="car_rent.rent.OptionRepository" %>
<%@ page import="java.util.List" %>

<%
    List<Option> optionList = OptionRepository.findAll();
    pageContext.setAttribute("optionList", optionList);
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
                <form method="post" action="addOption">
                    <input type="text" name="optionName" class="form-control">
                    <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Dodaj</button>
                </form>
            </div>

            <c:forEach items="${optionList}" var="option">
                <div class="row">

                    <div class="col-md-10">
                        <p>${option.name}</p>
                    </div>
                    <div class="col-md-2">
                        <a href="/removeOption?optionId=${option.id}" class="btn btn-primary">Usuń</a>
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