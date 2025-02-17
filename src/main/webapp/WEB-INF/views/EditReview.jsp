<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Review</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-4">
        <h2 class="text-center">Edit Review</h2>
        <form action="../update/${review.reviewId}" method="post">
            <div class="mb-3">
                <label class="form-label">Car</label>
                <input type="text" class="form-control" value="${review.car.make} ${review.car.model} (${review.car.year})" readonly>
            </div>
            <div class="mb-3">
                <label class="form-label">User</label>
                <input type="text" class="form-control" value="${review.user.firstName} ${review.user.lastName}" readonly>
            </div>
            <div class="mb-3">
                <label class="form-label">Rating</label>
                <select name="rating" class="form-control" required>
                    <option value="1" ${review.rating == 1 ? 'selected' : ''}>1 ⭐</option>
                    <option value="2" ${review.rating == 2 ? 'selected' : ''}>2 ⭐</option>
                    <option value="3" ${review.rating == 3 ? 'selected' : ''}>3 ⭐</option>
                    <option value="4" ${review.rating == 4 ? 'selected' : ''}>4 ⭐</option>
                    <option value="5" ${review.rating == 5 ? 'selected' : ''}>5 ⭐</option>
                </select>
            </div>
            <div class="mb-3">
                <label class="form-label">Review Text</label>
                <textarea name="reviewText" class="form-control" required>${review.reviewText}</textarea>
            </div>
            <div class="mb-3">
                <label class="form-label">Any Extra Comment</label>
                <textarea name="anyExtraComment" class="form-control">${review.anyExtraComment}</textarea>
            </div>
            <button type="submit" class="btn btn-success">Update Review</button>
            <a href="../review" class="btn btn-secondary">Cancel</a>
        </form>
    </div>
</body>
</html>