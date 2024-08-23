<% List<MovieModel> movieList = null; %>
<%@ page import="com.app.TheMovie.Model.Tables.TVModel" %>
<%@ page import="java.util.List" %>
<%@ page import="com.app.TheMovie.Model.Tables.MovieModel" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="my" tagdir="/WEB-INF/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: IRMAG
  Date: 30.07.2023
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">

        <title>The Movie Database Application</title>
        <style><%@include file="/WEB-INF/css/welcomePage.css"%>
        <%@include file="/WEB-INF/css/navbarCSS.css"%>
        </style>
    </head>
    <body class="background-images">
    <my:mynavbar></my:mynavbar>

        <div id="carouselMovieAutoplaying" class="carousel slide" data-bs-ride="carousel">
            <div class="head-text" id="textMovie"><h2>Discover &#127381 Movie</h2></div>
            <div class="carousel-inner" id="carouselInnerMovie">
                <%
                    movieList = (List<MovieModel>) request.getAttribute("movieList");
                    if (movieList != null && !movieList.isEmpty()) {
                        for (int i = 0; i < movieList.size(); i += 5) {
                %>
                <div class="container">
                    <div class="carousel-item <%=(i == 0) ? "active" : ""%>">
                        <div class="row">
                            <%
                                for (int j = i; j < Math.min(i + 5, movieList.size()); j++) {
                                    MovieModel movie = movieList.get(j);
                            %>
                            <div class="col-md-2" id="container">
                                <a href="/welcomePage/additionInfoMovie?movieID=<%=movie.getId()%>" name="movieID">
                                    <div class="rating-box">
                                        <p class="rating" id="ratingNumber"><%=movie.getVote_average()%></p>
                                    </div>
                                    <div class="carousel-img">
                                        <img src="http://image.tmdb.org/t/p/w500/<%=movie.getPoster_path()%>" class="d-block w-100" alt="<%=movie.getTitle()%>" loading="lazy"
                                             width="400" height="400"
                                             decoding="async">
                                    </div>
                                </a>
                                <div class="carousel-caption">
                                    <strong><%=movie.getTitle()%></strong>
                                    <p><%=movie.getRelease_date()%></p>
                                </div>
                            </div>
                            <%
                                }
                            %>
                        </div>
                    </div>
                </div>
                <%
                        }
                    }
                %>
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselMovieAutoplaying" data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">&lt;</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselMovieAutoplaying" data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">&gt;</span>
            </button>
        </div>

        <div id="carouselTVAutoplaying" class="carousel slide" data-bs-ride="carousel" >
            <div class="head-text" id="textTV"><h2>Discover &#127381 TV</h2></div>
            <div class="carousel-inner" id="carouselInnerTV">
                <%
                    List<TVModel> tvList = (List<TVModel>) request.getAttribute("tvList");
                    if (tvList != null && !tvList.isEmpty()) {
                        for (int i = 0; i < tvList.size(); i += 5) {
                %>
                <div class="container">
                    <div class="carousel-item <%=(i == 0) ? "active" : ""%>">
                        <div class="row" id="movieRow">
                            <%
                                for (int j = i; j < Math.min(i + 5, tvList.size()); j++) {
                                    TVModel tv = tvList.get(j);
                            %>

                            <div class="col-md-2"  id="container">
                                <div class="carousel-img">
                                    <a href="/welcomePage/additionInfoTV?TVID=<%=tv.getIdTV()%>">
                                        <div class="rating-box">
                                            <p class="rating" id="ratingNum"><%=tv.getVote_average()%></p>
                                        </div>
                                        <img src="http://image.tmdb.org/t/p/original/<%=tv.getPoster_path()%>" class="d-block w-100" alt="<%=tv.getName()%>"loading="lazy"
                                             width="400" height="400"
                                             decoding="async">
                                    </a>
                                </div>
                                <div class="carousel-caption">
                                    <strong><%=tv.getName()%></strong>
                                    <p><%=tv.getFirst_air_date()%></p>
                                </div>
                            </div>
                            <%
                                }
                            %>

                        </div>
                    </div>
                </div>
                <%
                        }
                    }
                %>
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselTVAutoplaying" data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">&lt;</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselTVAutoplaying" data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">&gt;</span>
            </button>
        </div>


    <script src="https://code.jquery.com/jquery-3.6.4.min.js"
            integrity="sha384-oVr5kxyZD7i44FkKBL3M6Ro9i6NLf5G8s8s2KxU+2n0Z4ka9Rd1Exs6LbZfTqP2"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
            crossorigin="anonymous"></script>
    <script src="https://kit.fontawesome.com/04bc96b126.js" crossorigin="anonymous"></script>
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
        document.addEventListener("DOMContentLoaded", function () {
            const movieCarousel = document.getElementById("carouselMovieAutoplaying");
            const tvCarousel = document.getElementById("carouselTVAutoplaying");

            function loadItems(carousel, items, path, callback) {
                let currentIndex = 0;
                const batchSize = 5;

                function loadBatch() {
                    const endIndex = Math.min(currentIndex + batchSize, items.length);
                    const batch = items.slice(currentIndex, endIndex);

                    batch.forEach(function (item) {
                        const itemContainer = document.createElement("div");
                        itemContainer.classList.add("col-md-2", "container");

                        const ratingBox = document.createElement("div");
                        ratingBox.classList.add("rating-box");
                        const rating = document.createElement("p");
                        rating.classList.add("rating");
                        rating.innerText = item.getVote_average();
                        ratingBox.appendChild(rating);

                        const carouselImg = document.createElement("div");
                        carouselImg.classList.add("carousel-img");
                        const img = document.createElement("img");
                        img.src = path + item.getPoster_path();
                        img.classList.add("d-block", "w-100");
                        img.alt = item.getTitle();
                        carouselImg.appendChild(img);

                        const caption = document.createElement("div");
                        caption.classList.add("carousel-caption");
                        const strong = document.createElement("strong");
                        strong.innerText = item.getTitle();
                        const p = document.createElement("p");
                        p.innerText = item.getRelease_date();
                        caption.appendChild(strong);
                        caption.appendChild(p);

                        const link = document.createElement("a");
                        link.href = path + item.getId();
                        link.name = "movieID";
                        link.appendChild(ratingBox);
                        link.appendChild(carouselImg);
                        link.appendChild(caption);

                        itemContainer.appendChild(link);

                        carousel.appendChild(itemContainer);
                    });

                    currentIndex += batchSize;

                    if (currentIndex < items.length) {
                        setTimeout(loadBatch, 500); // Задержка для эффекта постепенной загрузки
                    } else {
                        callback(); // Вызываем колбэк после загрузки всех элементов
                    }
                }

                loadBatch();
            }

            // Замените параметры на свои
            loadItems(movieCarousel, <%= movieList %>, "http://image.tmdb.org/t/p/w500/", function () {
                // Колбэк после загрузки всех элементов карусели фильмов
            });

            // Замените параметры на свои
            loadItems(tvCarousel, <%= tvList %>, "http://image.tmdb.org/t/p/original/", function () {
                // Колбэк после загрузки всех элементов карусели сериалов
            });
        });
    </script>

    </body>
</html>
