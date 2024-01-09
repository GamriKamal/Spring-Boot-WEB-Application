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

  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">

  <script src="https://kit.fontawesome.com/04bc96b126.js" crossorigin="anonymous"></script>

  <title>My Account</title>
  <link rel="stylesheet" type="text/css" href="styles.css">
  <style><%@include file="/WEB-INF/css/navbarCSS.css"%>
    <%@include file="/WEB-INF/css/accountPage.css"%></style>

</head>
<body>
<my:mynavbar></my:mynavbar>

<div class="container">
  <div class="account-info">
    <h2>My Account</h2>
    <div class="user-info">
      <p><strong>Name:</strong> ${nameOfUser}</p>
      <p><strong>Email:</strong> ${mailOfUser}</p>
      <p><strong>Phone Number:</strong> ${phoneNumberOfUser}</p>
    </div>
  </div>

</div>
</body>
</html>
