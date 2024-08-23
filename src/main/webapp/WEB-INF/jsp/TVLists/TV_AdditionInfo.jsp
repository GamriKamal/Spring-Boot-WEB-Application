<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.app.TheMovie.Model.Tables.MovieModel" %><%--
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

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
              integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
              crossorigin="anonymous">

        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css"
              integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz"
              crossorigin="anonymous">

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <script src="https://kit.fontawesome.com/04bc96b126.js" crossorigin="anonymous"></script>

        <title>The Movie Database Application</title>
        <style>
            <%@include file="/WEB-INF/css/navbarCSS.css"%>
            <%@include file="/WEB-INF/css/additionInfoTV.css"%>
        :root {
            --average-color: rgba(${averageColor.getRed()}, ${averageColor.getGreen()}, ${averageColor.getBlue()}, 0.7);
        }
        </style>
    </head>
    <body>
    <my:mynavbar></my:mynavbar>

        <section>
            <div class="single_column">
                <div class="img_backdrop">
                    <img src="${modelTV.getBackdrop_path()}">
                </div>
                <div class="container">
                    <div class="img_poster">
                        <img src="${modelTV.getPoster_path()}">
                    </div>
                    <div class="movie_title">
                        <strong>${modelTV.getName()}</strong>
                    </div>
                    <div class="movie_caption">
                        <p>${modelTV.getFirst_air_date()}	&#8226;&nbsp;
                            ${modelTV.getGenres()} &nbsp;&#8226;
                            ${modelTV.getNumber_of_seasons()} season
                        </p>
                    </div>
                    <div class="rating-box">
                        <p class="rating" id="ratingNum">${modelTV.getVote_average()}</p>
                    </div>

                    <div class="containerForButtons">
                        <div class="add_to_list">
                            <form action="/addFavouriteTV?TVID=${modelTV.getId()}" method="POST">
                                <button type="submit" class="round-button">Add to Favorites</button>
                            </form>
                        </div>

                        <div class="add_to_Watchlist">
                            <form action="/addWatchlistTV?TVID=${modelTV.getId()}" method="POST">
                                <button type="submit" class="round-button">Add to Watchlist</button>
                            </form>
                        </div>

                    </div>

                    <div class="movie_overview">
                        <p>${modelTV.getTagline()}</p>
                        <strong>Overview</strong>
                        <h5>${modelTV.getOverview()}</h5>
                    </div>
                </div>
            </div>
        </section>

        <section class="cast">
            <div class="head-text"><h2>Top Billed Cast</h2></div>
            <div class="external_info">
                <a href="${externalIDsList.getFacebook_id()}" class="fa fa-facebook"></a>
                <a href="${externalIDsList.getTwitter_id()}" class="fa fa-twitter"></a>
                <a href="${externalIDsList.getInstagram_id()}" class="fa fa-instagram"></a>
                <a href="${modelTV.getHomepage()}" class="fa fa-link"></a>
            </div>
            <div class="pageInfo">
                <div class="addition-info">
                    <div class="original_title">
                        <strong>Original Title:</strong>
                        <p>${modelTV.getOriginal_name()}</p>
                    </div>
                    <div class="original_title">
                        <strong>Status:</strong>
                        <p>${modelTV.getStatus()}</p>
                    </div>
                    <div class="numberOfEpisodes">
                        <strong>Number of Episodes:</strong>
                        <p>${modelTV.number_of_episodes}</p>
                    </div>
                    <div class="lastEpisode">
                        <strong>Last Episode:</strong>
                        <p>${modelTV.last_air_date}</p>
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
                    <c:forEach var="cast" items="${firstSixCastList}" varStatus="loop">
                        <c:if test="${loop.index < 6}">
                            <div class="card" style="width: 10rem;">
                                <img src="${cast.getProfile_path()}" class="card-img-top" alt="...">
                                <div class="card-body">
                                    <h5 class="card-title">${cast.getName()}</h5>
                                    <p class="card-text">${cast.getCharacter()}</p>
                                </div>
                            </div>
                        </c:if>
                    </c:forEach>
                </div>
                <div class="castPage">
                    <a class="user-select-auto" href="/welcomePage/additionInfoTV/cast?TVID=${modelTV.getId()}">Full Cast & Crew</a>
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

    </body>
</html>
