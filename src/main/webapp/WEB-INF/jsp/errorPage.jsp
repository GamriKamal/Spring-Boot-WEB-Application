<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.app.TheMovie.Model.Tables.MovieModel" %>
<%@ page import="java.util.List" %>
<%@ page import="com.app.TheMovie.Model.MovieModel.MovieModelCast" %>
<%@ page import="com.app.TheMovie.Model.MovieModel.MovieModelCrew" %><%--
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

    <script src="js/JQuery3.3.1.js"></script>
    <script src="js/lightslider.js"></script>
    <title>The Movie Database Application</title>
    <style><%@include file="/WEB-INF/css/pageWithAdditionInfo.css"%>
    :root {
      --average-color: rgba(${averageColor.getRed()}, ${averageColor.getGreen()}, ${averageColor.getBlue()}, 0.7);
    }

    </style>
  </head>
  <body>
  <my:mynavbar></my:mynavbar>

  </body>
</html>
