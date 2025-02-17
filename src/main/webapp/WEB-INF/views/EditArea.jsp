<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Edit Area</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <h2 class="text-center">Edit Area</h2>
    
    <form action="${pageContext.request.contextPath}/area/update/${area.areaId}" method="post">
        <div class="mb-3">
            <label class="form-label">Area Name</label>
            <input type="text" name="areaName" class="form-control" value="${area.areaName}" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Select City</label>
            <select name="cityId" class="form-select" required>
                <option value="">-- Select City --</option>
                <c:forEach var="city" items="${cities}">
                    <option value="${city.cityId}" ${area.city.cityId == city.cityId ? 'selected' : ''}>
                        ${city.cityName}
                    </option>
                </c:forEach>
            </select>
        </div>

        <button type="submit" class="btn btn-success">Update</button>
        <a href="${pageContext.request.contextPath}/area" class="btn btn-secondary">Cancel</a>
    </form>
</div>
</body>
</html>
