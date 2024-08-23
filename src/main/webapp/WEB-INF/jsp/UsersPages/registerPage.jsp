<%--
  Created by IntelliJ IDEA.
  User: khgamri
  Date: 25.10.2023
  Time: 00:28
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

  <script src="https://kit.fontawesome.com/04bc96b126.js" crossorigin="anonymous"></script>


    <title>Registration Page</title>
  <style>
    <%@include file="/WEB-INF/css/navbarCSS.css"%>
    <%@include file="/WEB-INF/css/registerPage.css"%>
  </style>
</head>
<body>
<my:mynavbar></my:mynavbar>

<div class="container">
  <h2>Register</h2>
<%--  <form action="/account" method="post">--%>
<%--    <input type="text" name="username" placeholder="Username" required><br>--%>
<%--    <input type="password" name="password" placeholder="Password" required><br>--%>
<%--    <input type="submit" value="Register">--%>
<%--  </form>--%>
  <form action="/addRegister" method="post">
    <div class="form-group">
      <input type="text" id="username" name="username" placeholder="Enter your name" required>
    </div>
    <div class="form-group">
      <input type="email" id="email" name="email" placeholder="Enter email" required>
    </div>
    <div class="form-group">
      <input type="tel" id="phone" name="phone" placeholder="Enter phone number:" required>
    </div>
    <div class="form-group">
      <input type="password" id="password" name="password" placeholder="Enter password:" required>
    </div>
    <div class="form-group">
      <input type="password" id="confirm-password" name="confirm-password" placeholder="Confirm password:" required>
    </div>
    <input type="submit" value="Register">
  </form>
  <p>Already have an account? <a href="/login">Login</a></p>
</div>
</body>


</html>
