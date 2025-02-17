<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Inquiry</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h1 class="mb-4">Add Inquiry</h1>
        <form action="${pageContext.request.contextPath}/inquiry/save" method="post">
            <div class="mb-3">
                <label for="carId" class="form-label">Car</label>
                <select id="carId" name="carId" class="form-select" required>
                    <c:forEach var="car" items="${cars}">
                        <option value="${car.carId}">${car.carName}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="mb-3">
                <label for="userId" class="form-label">User</label>
                <select id="userId" name="userId" class="form-select" required>
                    <c:forEach var="user" items="${users}">
                        <option value="${user.userId}">${user.firstName} ${user.lastName}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="mb-3">
                <label for="message" class="form-label">Message</label>
                <textarea id="message" name="message" class="form-control" required></textarea>
            </div>

            <button type="submit" class="btn btn-success">Save Inquiry</button>
            <a href="${pageContext.request.contextPath}/inquiry" class="btn btn-secondary">Cancel</a>
        </form>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
