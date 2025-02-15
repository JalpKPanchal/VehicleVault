<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit State</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-4">
        <h2>Edit State</h2>
        <form action="${pageContext.request.contextPath}/states/update/${state.stateId}" method="post">
            <div class="mb-3">
                <label class="form-label">State Name:</label>
                <input type="text" name="stateName" class="form-control" value="${state.stateName}" required>
            </div>
            <button type="submit" class="btn btn-success">Update</button>
            <a href="${pageContext.request.contextPath}/states" class="btn btn-secondary">Cancel</a>
        </form>
    </div>
</body>
</html>
