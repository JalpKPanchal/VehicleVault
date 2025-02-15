<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Insurance List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <h2 class="text-center">Insurance List</h2>

    <!-- Flash Messages -->
    <c:if test="${not empty successMessage}">
        <div class="alert alert-success">${successMessage}</div>
    </c:if>
    <c:if test="${not empty errorMessage}">
        <div class="alert alert-danger">${errorMessage}</div>
    </c:if>

    <div class="d-flex justify-content-between mb-3">
        <a href="${pageContext.request.contextPath}/insurance/add" class="btn btn-primary">Add Insurance</a>
    </div>

    <table class="table table-bordered table-hover">
        <thead class="table-dark">
            <tr>
                <th>ID</th>
                <th>Insurance Type</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="insurance" items="${insurances}">
                <tr>
                    <td>${insurance.insuranceId}</td>
                    <td>${insurance.insuranceType}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/insurance/edit/${insurance.insuranceId}" class="btn btn-warning btn-sm">Edit</a>
                        <a href="${pageContext.request.contextPath}/insurance/delete/${insurance.insuranceId}" class="btn btn-danger btn-sm"
                           onclick="return confirm('Are you sure you want to delete this insurance?');">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
