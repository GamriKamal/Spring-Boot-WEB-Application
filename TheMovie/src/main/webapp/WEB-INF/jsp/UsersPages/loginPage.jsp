<% List<MovieModel> movieList = null; %>
<%@ page import="com.app.TheMovie.Model.TVModel.TVModel" %>
<%@ page import="java.util.List" %>
<%@ page import="com.app.TheMovie.Model.MovieModel.MovieModel" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
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
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
                crossorigin="anonymous"></script>

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
              integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
              crossorigin="anonymous">

        <script src="https://kit.fontawesome.com/04bc96b126.js" crossorigin="anonymous"></script>


        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">

        <title>The Movie Database Application</title>
        <style>
            <%@include file="/WEB-INF/css/navbarCSS.css"%>
            <%@include file="/WEB-INF/css/loginPage.css"%>
        </style>
    </head>
    <body class="background-images">
    <my:mynavbar></my:mynavbar>


        <div style="text-align: center;">
            <c:choose>
                <c:when test="${param.error != null}">
                    <div class="alert alert-danger">
                        Invalid username and password.
                    </div>
                </c:when>
                <c:when test="${param.logout != null}">
                    <div class="alert alert-success">
                        You have been logged out.
                    </div>
                </c:when>
            </c:choose>
        </div>



        <div class="container">
        <form action="/login" method="post">
            <div>
                <label> User Name : <input type="text" name="username"/> </label>
            </div>
            <div>
                <label> Password: <input type="password" name="password"/> </label>
            </div>
            <div>
                <input type="submit" value="Sign In"/>
            </div>
        </form>
            <p>Don't have an account? <a href="/register">Register</a></p>
        </div>
    </body>
</html>
