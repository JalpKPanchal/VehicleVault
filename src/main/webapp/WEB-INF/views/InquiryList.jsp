<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inquiry List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h1 class="mb-4">Inquiry List</h1>
        <a href="${pageContext.request.contextPath}/inquiry/add" class="btn btn-primary mb-3">Add New Inquiry</a>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>#</th>
                    <th>Car</th>
                    <th>User</th>
                    <th>Inquiry Date</th>
                    <th>Status</th>
                    <th>Message</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="inquiry" items="${inquiries}">
                    <tr>
                        <td>${inquiry.inquiryId}</td>
                        <td>${inquiry.car.carName}</td> <!-- Adjust with the correct car name field -->
                        <td>${inquiry.user.firstName} ${inquiry.user.lastName}</td>
                        <td>${inquiry.inquiryDate}</td>
                        <td>${inquiry.status}</td>
                        <td>${inquiry.message}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/inquiry/edit/${inquiry.inquiryId}" class="btn btn-warning btn-sm">Edit</a>
                            <a href="${pageContext.request.contextPath}/inquiry/delete/${inquiry.inquiryId}" class="btn btn-danger btn-sm" onclick="return confirm('Are you sure?')">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
