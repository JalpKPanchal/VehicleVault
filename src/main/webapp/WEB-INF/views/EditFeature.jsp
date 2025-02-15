<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Edit Feature</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <h2 class="text-center">Edit Feature</h2>

    <form action="${pageContext.request.contextPath}/features/update/${feature.featureId}" method="post" class="border p-4 rounded shadow bg-light">
        <div class="mb-3">
            <label for="featureName" class="form-label">Feature Name:</label>
            <input type="text" id="featureName" name="featureName" class="form-control" value="${feature.featureName}" required>
        </div>

        <div class="d-flex justify-content-between">
            <a href="${pageContext.request.contextPath}/features" class="btn btn-secondary">Back</a>
            <button type="submit" class="btn btn-primary">Update</button>
        </div>
    </form>
</div>
</body>
</html>
