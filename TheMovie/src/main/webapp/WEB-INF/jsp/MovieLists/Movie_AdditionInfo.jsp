<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%--
  Created by IntelliJ IDEA.
  User: IRMAG
  Date: 07.08.2023
  Time: 15:30
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


        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <script src="https://kit.fontawesome.com/04bc96b126.js" crossorigin="anonymous"></script>

        <title>The Movie Database Application</title>
        <style>
            <%@include file="/WEB-INF/css/navbarCSS.css"%>
            <%@include file="/WEB-INF/css/pageWithAdditionInfo.css"%>
        :root {
            --average-color: rgba(${averageColor.getRed()}, ${averageColor.getGreen()}, ${averageColor.getBlue()}, 0.7);
        }

        </style>
    </head>
    <body>
        <my:mynavbar></my:mynavbar>

        <section class="page-search-info">
            <div class="lazy-load-container">
                <div class="img_backdrop"  >
                    <img src="${modelMovie.getBackdrop_path()}" loading="lazy"
                         width="400" height="400"
                         decoding="async">
                </div>
                <div class="container">
                    <div class="img_poster" >
                        <img src="${modelMovie.getPoster_path()}" loading="lazy"
                             width="400" height="400"
                             decoding="async">
                    </div>
                    <div class="title">
                        <div class="movie_title">
                            <strong>${modelMovie.getTitle()}</strong>
                        </div>
                        <div class="movie_caption">
                            <p>${modelMovie.getRelease_date()} &#8226;&nbsp;
                                ${modelMovie.getGenres()} &nbsp;&#8226;
                                ${modelMovie.getRuntime()} minutes
                            </p>
                        </div>
                    </div>
                    <ul class="auto actions">
                        <div class="rating-box">
                            <p class="rating" id="ratingNum">${modelMovie.getVote_average()}</p>
                        </div>

                        <div class="containerForButtons">
                            <div class="add_to_list">
                                <form action="/addFavouriteMovie?movieID=${modelMovie.getId()}" method="POST">
                                    <button type="submit" class="round-button">Add to Favorites</button>
                                </form>
                            </div>

                            <div class="add_to_Watchlist">
                                <form action="/addWatchlistMovie?movieID=${modelMovie.getId()}" method="POST">
                                    <button type="submit" class="round-button">Add to Watchlist</button>
                                </form>
                            </div>
                        </div>
                        <div th:if="${session.successMessage}" class="success-message">
                            <p th:text="${session.successMessage}"></p>
                        </div>
                        <div class="movie_trailer">
                            <a class="videoButton" href="${modelMovieVideo.getKey()}" >&#9654; Play Trailer</a>
                        </div>
                    </ul>
                    <div class="movie_overview">
                        <p>${modelMovie.getTagline()}</p>
                        <strong>Overview</strong>
                        <h5>${modelMovie.getOverview()}</h5>
                    </div>
<%--                    <div class="crew">--%>
<%--                        <c:forEach var="prod" items="${producerList}">--%>
<%--                            <strong>${prod.getName()}</strong>--%>
<%--                            <strong>${prod.getJob()}</strong>--%>
<%--                        </c:forEach>--%>
<%--                    </div>--%>
                </div>
            </div>
        </section>


        <section class="cast">
            <div class="head-text"><h2>Top Billed Cast</h2></div>
            <div class="external_info">
                <a href="${externalIDsList.getFacebook_id()}" class="fa fa-facebook"></a>
                <a href="${externalIDsList.getTwitter_id()}" class="fa fa-twitter"></a>
                <a href="${externalIDsList.getInstagram_id()}" class="fa fa-instagram"></a>
                <a href="${modelMovie.getHomepage()}" class="fa fa-link"></a>
            </div>
            <div class="pageInfo">
                <div class="addition-info">
                    <div class="original_title">
                        <strong>Original Title</strong>
                        <p>${modelMovie.getOriginal_title()}</p>
                    </div>
                    <div class="original_title">
                        <strong>Status</strong>
                        <p>${modelMovie.getStatusMovie()}</p>
                    </div>
                    <div class="budget">
                        <strong>Budget</strong>
                        <p>${modelMovie.getBudget()}</p>
                    </div>
                    <div class="revenue">
                        <strong>Revenue</strong>
                        <p>${modelMovie.getRevenue()}</p>
                    </div>
                </div>
                <div class="keywords">
                    <strong style="font-size: 20px;">Keywords</strong>
                    <ul>
                        <c:forEach var="word" items="${keywordsList}">
                            <li>
                                <p>${word.getName()}</p>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
                <div class="row">
                    <c:forEach var="cast" items="${firstSixCastList}">
                    <div class="card" style="width: 10rem;">
                        <img src="${cast.getProfile_path()}" loading="lazy"
                             width="400" height="400"
                             decoding="async" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">${cast.getName()}</h5>
                            <p class="card-text">${cast.getCharacter()}</p>
                        </div>
                    </div>
                    </c:forEach>
                </div>
                <div class="castPage">
                    <a class="user-select-auto" href="/welcomePage/additionInfoMovie/cast?movieID=${modelMovie.getId()}">Full Cast & Crew</a>
                </div>
            </div>
        </section>


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

        <script>
            // function loadContent(){
            //     const xhttp = new XMLHttpRequest();
            //     xhttp.onload = function (){
            //         document.getElementById("img_backdrop").innerHTML = this.responseText;
            //         document.getElementById("img_poster").innerHTML = this.responseText;
            //         document.getElementById("card").innerHTML = this.responseText;
            //     }
            //     xhttp.open("GET", "/welcomePage");
            //     xhttp.send();
            // }
            $.ajax({
                url: "Movie_AdditionInfo.jsp",
                cache: false,
                success: function(html){
                    $("#img_backdrop").append(html);
                    $("#img_poster").append(html);
                    $("#card").append(html);
                    $("#lazy-load-container").append(html);
                }
            });
        </script>

    </body>
</html>
