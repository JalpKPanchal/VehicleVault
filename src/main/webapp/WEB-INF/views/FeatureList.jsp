<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Feature List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <h2 class="text-center">Feature List</h2>

    <div class="d-flex justify-content-between mb-3">
        <a href="${pageContext.request.contextPath}/features/add" class="btn btn-primary">Add Feature</a>
    </div>

    <table class="table table-bordered table-hover">
        <thead class="table-dark">
            <tr>
                <th>ID</th>
                <th>Feature Name</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="feature" items="${features}">
                <tr>
                    <td>${feature.featureId}</td>
                    <td>${feature.featureName}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/features/edit/${feature.featureId}" class="btn btn-warning btn-sm">Edit</a>
                        <a href="${pageContext.request.contextPath}/features/delete/${feature.featureId}" class="btn btn-danger btn-sm"
                           onclick="return confirm('Are you sure you want to delete this feature?');">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
