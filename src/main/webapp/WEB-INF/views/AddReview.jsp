<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add Review</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-4">
        <h2 class="text-center">Add New Review</h2>
        <form action="save" method="post">
            <div class="mb-3">
                <label class="form-label">Car</label>
                <select name="carId" class="form-control" required>
                    <c:forEach var="car" items="${cars}">
                        <option value="${car.carId}">${car.make} ${car.model} (${car.year})</option>
                    </c:forEach>
                </select>
            </div>
            <div class="mb-3">
                <label class="form-label">User</label>
                <select name="userId" class="form-control" required>
                    <c:forEach var="user" items="${users}">
                        <option value="${user.userId}">${user.firstName} ${user.lastName}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="mb-3">
                <label class="form-label">Rating</label>
                <select name="rating" class="form-control" required>
                    <option value="1">1 ⭐</option>
                    <option value="2">2 ⭐</option>
                    <option value="3">3 ⭐</option>
                    <option value="4">4 ⭐</option>
                    <option value="5">5 ⭐</option>
                </select>
            </div>
            <div class="mb-3">
                <label class="form-label">Review Text</label>
                <textarea name="reviewText" class="form-control" required></textarea>
            </div>
            <div class="mb-3">
                <label class="form-label">Any Extra Comment</label>
                <textarea name="anyExtraComment" class="form-control"></textarea>
            </div>
            <button type="submit" class="btn btn-success">Save Review</button>
            <a href="../review" class="btn btn-secondary">Cancel</a>
        </form>
    </div>
</body>
</html>
