<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: IRMAG
  Date: 04.08.2023
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="my" tagdir="/WEB-INF/tags" %>

<html>
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
            crossorigin="anonymous"></script>


    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
          crossorigin="anonymous">

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css"
          integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz"
          crossorigin="anonymous">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <title>The Movie Database Application</title>
    <style>
      <%@include file="/WEB-INF/css/navbarCSS.css"%>
      <%@include file="/WEB-INF/css/searchMovieOrTV.css"%></style>
  </head>
    <body>
    <my:mynavbar></my:mynavbar>

    <div class="head-text"><h2>Search results: ${input}</h2></div>
    <div class="container cards-wrapper d-flex gx-5">
      <div class="row gy-3">
        <c:forEach items="${list}" var="movie">
          <div class="col-md-4">
            <div class="card" id="cardmain">
              <a class="image" href="/welcomePage/additionInfoMovie?movieID=${movie.getId()}" title="${movie.getTitle()}">
                <img src="http://image.tmdb.org/t/p/w500${movie.getPoster_path()}">
              </a>
              <div class="rating-box">
                <p class="rating" id="ratingNum">${movie.getVote_average()}</p>
              </div>
              <div class="card-body">
                <strong class="card-title">${movie.getTitle()}</strong>
                <p>${movie.getRelease_date()}</p>

              </div>
            </div>
          </div>
        </c:forEach>
      </div>
    </div>

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
