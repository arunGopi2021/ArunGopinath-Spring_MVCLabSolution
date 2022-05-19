<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
<!-- Adding the JSTL tags -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    
    
<!DOCTYPE html>
<html>

<head>
<!-- Add the meta tags -->
<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- Add the bootstrap css -->
<link href="<c:url value="/static/css/bootstrap.min.css" />" rel="stylesheet"> 
<title>registration-app</title>
</head>

<body>
<div class="container">

<h2>Welcome to the College Festival 2022!</h2>
<p>Click <a href="/RegistrationApp/students/list" class="link-info">here</a> to register for the debate event.</p>



</div>

<!-- Add the bootstrap js, jquery and  popper -->
<script src="<c:url value="/static/js/jquery.min.js" />"></script>
<script src="<c:url value="/static/js/popper.min.js" />"></script>
<script src="<c:url value="/static/js/bootstrap.min.js" />"></script>

</body>
</html>




