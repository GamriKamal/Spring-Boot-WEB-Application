<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="my" tagdir="/WEB-INF/tags" %>


<%--
  Created by IntelliJ IDEA.
  User: IRMAG
  Date: 09.08.2023
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
            crossorigin="anonymous"></script>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
          crossorigin="anonymous">


    <script src="https://kit.fontawesome.com/04bc96b126.js" crossorigin="anonymous"></script>

    <title>The Movie Database Application</title>
    <style>
        <%@include file="/WEB-INF/css/navbarCSS.css"%>
        <%@include file="/WEB-INF/css/designForLists.css"%></style>
</head>
    <body>
    <my:mynavbar></my:mynavbar>

    <div class="head-text"><h2>Popular TV List</h2></div>
    <div class="content_wrapper">
        <div class="content">
            <div class="container">
                <div class="row">
                    <c:forEach items="${tvListPopular}" var="tv">
                        <div class="col-md-4 mb-4">
                            <div class="card style">
                                <div class="image">
                                    <div class="wrapper">
                                        <a class="image" href="/welcomePage/additionInfoTV?TVID=${tv.getIdTV()}" title="${tv.getName()}">
                                            <img loading="lazy" class="poster" src="${tv.getPoster_path()}" alt="">
                                        </a>
                                    </div>
                                </div>
                                <div class="content">
                                    <div class="rating-box">
                                        <p class="rating" id="ratingNumber">${tv.getVote_average()}</p>
                                    </div>
                                    <strong><a href="/welcomePage/additionInfoTV?TVID=${tv.getIdTV()}" title="${tv.getName()}">${tv.getName()}</a></strong>
                                    <p>${tv.getFirst_air_date()}</p>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>

<%--    <div class="head-text"><h2>Popular TV</h2></div>--%>
<%--    <div class="container cards-wrapper d-flex gx-5">--%>
<%--        <div class="row gy-3">--%>
<%--            <c:forEach items="${tvListPopular}" var="tv">--%>
<%--                <div class="col-md-4">--%>
<%--                    <div class="card" id="cardmain">--%>
<%--                        <div class="wrapper">--%>
<%--                            <a class="image" href="/welcomePage/additionInfoTV?TVID=${tv.getIdTV()}" title="${tv.getName()}">--%>
<%--                                <img src="${tv.getPoster_path()}">--%>
<%--                            </a>--%>
<%--                        </div>--%>
<%--                        <div class="rating-box">--%>
<%--                            <p class="rating" id="ratingNum">${tv.getVote_average()}</p>--%>
<%--                        </div>--%>
<%--                        <div class="card-body">--%>
<%--                            <strong class="card-title><a href="/welcomePage/additionInfoTV?TVID=${tv.getIdTV()}" title="${tv.getName()}">${tv.getName()}</a></strong>--%>
<%--                            <p>${tv.getFirst_air_date()}</p>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </c:forEach>--%>
<%--        </div>--%>
<%--    </div>--%>

    <script>
        document.addEventListener("DOMContentLoaded", function() {
            const ratingElements = document.querySelectorAll(".rating");

            ratingElements.forEach(function(ratingElement) {
                const ratingValue = parseFloat(ratingElement.innerText);

                if (ratingValue >= 0 && ratingValue < 4) {
                    ratingElement.classList.add("red");
                } else if (ratingValue >= 4 && ratingValue < 7) {
                    ratingElement.classList.add("yellow");
                } else if (ratingValue >= 7 && ratingValue <= 10) {
                    ratingElement.classList.add("green");
                }
            });
        });
    </script>

    </body>
</html>
