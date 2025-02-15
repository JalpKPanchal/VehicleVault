<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>State List</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-4">
        <h2>State List</h2>
        <a href="${pageContext.request.contextPath}/states/add" class="btn btn-primary mb-3">Add New State</a>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>State Name</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="state" items="${states}">
                    <tr>
                        <td>${state.stateId}</td>
                        <td>${state.stateName}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/states/edit/${state.stateId}" class="btn btn-warning btn-sm">Edit</a>
                            <a href="${pageContext.request.contextPath}/states/delete/${state.stateId}" class="btn btn-danger btn-sm">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
