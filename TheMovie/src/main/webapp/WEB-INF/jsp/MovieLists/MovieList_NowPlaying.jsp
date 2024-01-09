<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="my" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
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

        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css"
              integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz"
              crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/04bc96b126.js" crossorigin="anonymous"></script>

        <title href="src/main/webapp/WEB-INF/images/video-player.png">Now Playing (TMDBA)</title>
        <style>
            <%@include file="/WEB-INF/css/designForLists.css"%>
            <%@include file="/WEB-INF/css/navbarCSS.css"%>
        </style>
    </head>
    <body>

    <my:mynavbar></my:mynavbar>
    <div class="head-text"><h2>Now Playing</h2></div>
    <div class="content_wrapper">
        <div class="content">
            <div class="container">
                <div class="row">
                    <c:forEach items="${movieListNowPlaying}" var="movie">
                        <div class="col-md-4 mb-4">
                            <div class="card style">
                                <div class="image">
                                    <div class="wrapper">
                                        <a class="image" href="/welcomePage/additionInfoMovie?movieID=${movie.getId()}" title="${movie.getTitle()}">
                                            <img loading="lazy" class="poster" src="${movie.getPoster_path()}" alt="">
                                        </a>
                                    </div>
                                </div>
                                <div class="content">
                                    <div class="rating-box">
                                        <p class="rating" id="ratingNumber">${movie.vote_average}</p>
                                    </div>
                                    <strong><a href="/welcomePage/additionInfoMovie?movieID=${movie.getId()}" title="${movie.getTitle()}">${movie.getTitle()}</a></strong>
                                    <p>${movie.getRelease_date()}</p>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
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