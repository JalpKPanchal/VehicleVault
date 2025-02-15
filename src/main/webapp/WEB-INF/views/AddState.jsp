<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add State</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-4">
        <h2>Add New State</h2>
        <form action="${pageContext.request.contextPath}/states/save" method="post">
            <div class="mb-3">
                <label class="form-label">State Name:</label>
                <input type="text" name="stateName" class="form-control" required>
            </div>
            <button type="submit" class="btn btn-success">Save</button>
            <a href="${pageContext.request.contextPath}/states" class="btn btn-secondary">Cancel</a>
        </form>
    </div>
</body>
</html>
