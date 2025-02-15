<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>City List</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-4">
        <h2>City List</h2>
        <a href="${pageContext.request.contextPath}/cities/add" class="btn btn-primary mb-3">Add New City</a>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>City Name</th>
                    <th>State</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="city" items="${cities}">
                    <tr>
                        <td>${city.cityId}</td>
                        <td>${city.cityName}</td>
                        <td>${city.state.stateName}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/cities/edit/${city.cityId}" class="btn btn-warning btn-sm">Edit</a>
                            <a href="${pageContext.request.contextPath}/cities/delete/${city.cityId}" class="btn btn-danger btn-sm">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
