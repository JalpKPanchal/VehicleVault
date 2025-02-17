<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Review List</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-4">
        <h2 class="text-center">Review List</h2>
        <a href="review/add" class="btn btn-primary mb-3">Add Review</a>
        <table class="table table-bordered">
            <thead class="table-dark">
                <tr>
                    <th>#</th>
                    <th>Car</th>
                    <th>User</th>
                    <th>Rating</th>
                    <th>Review Date</th>
                    <th>Review Text</th>
                    <th>Extra Comment</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="review" items="${reviews}">
                    <tr>
                        <td>${review.reviewId}</td>
                        <td>${review.car.make} ${review.car.model} (${review.car.year})</td>
                        <td>${review.user.firstName} ${review.user.lastName}</td>
                        <td>${review.rating} ⭐</td>
                        <td>${review.reviewDate}</td>
                        <td>${review.reviewText}</td>
                        <td>${review.anyExtraComment}</td>
                        <td>
                            <a href="review/edit/${review.reviewId}" class="btn btn-warning btn-sm">Edit</a>
                            <a href="review/delete/${review.reviewId}" class="btn btn-danger btn-sm" onclick="return confirm('Are you sure?')">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
