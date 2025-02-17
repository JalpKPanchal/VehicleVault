<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Car List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <h2 class="text-center">Car List</h2>

    <div class="d-flex justify-content-between mb-3">
        <a href="${pageContext.request.contextPath}/cars/add" class="btn btn-primary">Add Car</a>
    </div>

    <table class="table table-bordered table-hover">
        <thead class="table-dark">
            <tr>
                <th>Make</th>
                <th>Model</th>
                <th>Year</th>
                <th>Price</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="car" items="${cars}">
                <tr>
                    <td>${car.make}</td>
                    <td>${car.model}</td>
                    <td>${car.year}</td>
                    <td>${car.price}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/cars/edit/${car.carId}" class="btn btn-warning btn-sm">Edit</a>
                        <a href="${pageContext.request.contextPath}/cars/delete/${car.carId}" class="btn btn-danger btn-sm"
                           onclick="return confirm('Are you sure you want to delete this car?');">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
