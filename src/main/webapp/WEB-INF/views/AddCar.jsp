<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Add Car</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <h2 class="text-center">Add Car</h2>
    
    <form action="${pageContext.request.contextPath}/cars/save" method="post">
        <div class="mb-3">
            <label class="form-label">Make</label>
            <input type="text" name="make" class="form-control" required>
        </div>
        
        <div class="mb-3">
            <label class="form-label">Model</label>
            <input type="text" name="model" class="form-control" required>
        </div>
        
        <div class="mb-3">
            <label class="form-label">Year</label>
            <input type="number" name="year" class="form-control" required>
        </div>
        
        <div class="mb-3">
            <label class="form-label">Price</label>
            <input type="text" name="price" class="form-control" required>
        </div>
        
        <button type="submit" class="btn btn-success">Save</button>
        <a href="${pageContext.request.contextPath}/cars" class="btn btn-secondary">Cancel</a>
    </form>
</div>
</body>
</html>
