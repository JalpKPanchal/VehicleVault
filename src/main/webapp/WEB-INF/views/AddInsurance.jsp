<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Add Insurance</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <h2 class="text-center">Add Insurance</h2>
    
    <form action="${pageContext.request.contextPath}/insurance/save" method="post" class="border p-4 rounded shadow bg-light">
        <div class="mb-3">
            <label for="insuranceType" class="form-label">Insurance Type:</label>
            <select id="insuranceType" name="insuranceType" class="form-select" required>
                <c:forEach var="type" items="${insuranceTypes}">
                    <option value="${type}">${type}</option>
                </c:forEach>
            </select>
        </div>

        <div class="d-flex justify-content-between">
            <a href="${pageContext.request.contextPath}/insurance" class="btn btn-secondary">Back</a>
            <button type="submit" class="btn btn-success">Save</button>
        </div>
    </form>
</div>
</body>
</html>
