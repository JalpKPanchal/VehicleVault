<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Delete Car</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <h2 class="text-center">Delete Car</h2>
    
    <p>Are you sure you want to delete the car <strong>${car.make} ${car.model} (${car.year})</strong>?</p>
    
    <a href="${pageContext.request.contextPath}/cars/delete/${car.carId}" class="btn btn-danger">Yes, Delete</a>
    <a href="${pageContext.request.contextPath}/cars" class="btn btn-secondary">Cancel</a>
</div>
</body>
</html>