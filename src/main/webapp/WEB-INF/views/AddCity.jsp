<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add City</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-4">
        <h2>Add New City</h2>
        <form action="${pageContext.request.contextPath}/cities/save" method="post">
            <div class="mb-3">
                <label class="form-label">City Name:</label>
                <input type="text" name="cityName" class="form-control" required>
            </div>
            <div class="mb-3">
                <label class="form-label">State:</label>
                <select name="stateId" class="form-control" required>
                    <c:forEach var="state" items="${states}">
                        <option value="${state.stateId}">${state.stateName}</option>
                    </c:forEach>
                </select>
            </div>
            <button type="submit" class="btn btn-success">Save</button>
            <a href="${pageContext.request.contextPath}/cities" class="btn btn-secondary">Cancel</a>
        </form>
    </div>
</body>
</html>
