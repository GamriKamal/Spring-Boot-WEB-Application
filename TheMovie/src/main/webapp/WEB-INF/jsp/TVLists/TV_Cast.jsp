<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: IRMAG
  Date: 22.08.2023
  Time: 15:42
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
    <%@include file="/WEB-INF/css/castCSS.css"%>
    :root {
      --average-color: rgba(${averageColor.getRed()}, ${averageColor.getGreen()}, ${averageColor.getBlue()}, 0.7);
    }

  </style>
</head>
<body>
<my:mynavbar></my:mynavbar>

<section class="cast&crew">
  <div class="header_text">
    <div class="container">
      <div class="img_poster">
        <img src="${modelTV.getPoster_path()}">
      </div>
      <div class="poster_text">
        <strong>${modelTV.getName()} (${modelTV.getFirst_air_date()})</strong>
        <div class="poster_link">
          <a href="/welcomePage/additionInfoTV?TVID=${modelTV.getId()}"> &#8592; Back to main</a>
        </div>
      </div>
    </div>
  </div>
  <div class="body_text">
    <div class="container">
      <div class="castList">
        <div class="castNum">
          <p>Cast <span>${castList.size()}</span></p>
        </div>
        <c:forEach var="cast" items="${castList}" varStatus="status">
          <div class="info_actor">
            <div class="img_actor">
              <img src="${cast.getProfile_path()}">
            </div>
            <div class="cast_caption">
              <strong>${cast.getName()}</strong>
              <p>${cast.getCharacter()}</p>
            </div>
          </div>
        </c:forEach>
      </div>
      <div class="crewList">
        <div class="castNum">
          <p>Crew <span>${crewList.size()}</span></p>
        </div>
        <c:forEach var="crew" items="${crewList}" varStatus="status">
          <div class="info_actor">
            <div class="img_actor">
              <img src="${crew.getProfile_path()}">
            </div>
            <div class="cast_caption">
              <strong>${crew.getName()}</strong>
              <p>${crew.getJob()}</p>
            </div>
          </div>
        </c:forEach>
      </div>
    </div>
  </div>
</section>

</body>
</html>
