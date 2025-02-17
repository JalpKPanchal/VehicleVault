<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Edit Car</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <h2 class="text-center">Edit Car</h2>
    
    <form action="${pageContext.request.contextPath}/cars/update/${car.carId}" method="post">
        <div class="mb-3">
            <label class="form-label">Make</label>
            <input type="text" name="make" class="form-control" value="${car.make}" required>
        </div>
        
        <div class="mb-3">
            <label class="form-label">Model</label>
            <input type="text" name="model" class="form-control" value="${car.model}" required>
        </div>
        
        <div class="mb-3">
            <label class="form-label">Year</label>
            <input type="number" name="year" class="form-control" value="${car.year}" required>
        </div>
        
        <div class="mb-3">
            <label class="form-label">Price</label>
            <input type="text" name="price" class="form-control" value="${car.price}" required>
        </div>
        
        <button type="submit" class="btn btn-success">Update</button>
        <a href="${pageContext.request.contextPath}/cars" class="btn btn-secondary">Cancel</a>
    </form>
</div>
</body>
</html>
