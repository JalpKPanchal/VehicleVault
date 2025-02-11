<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.grownited.entity.UserEntity" %>
<%
    UserEntity loggedUser = (UserEntity) session.getAttribute("loggedUser");
    if (loggedUser == null) {
        response.sendRedirect("auth/login");
        return;
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard - VehicleVault</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-4">
    <div class="card shadow-lg p-4">
        <h2 class="text-center text-primary">Welcome, <%= loggedUser.getFirstName() %>!</h2>
        <p class="text-center text-muted">Manage your vehicle records and settings below.</p>

        <div class="row">
            <div class="col-md-4">
                <div class="card p-3">
                    <h5>User Profile</h5>
                    <p><strong>Name:</strong> <%= loggedUser.getFirstName() %> <%= loggedUser.getLastName() %></p>
                    <p><strong>Email:</strong> <%= loggedUser.getEmail() %></p>
                    <p><strong>Role:</strong> <%= loggedUser.getRole() %></p>
                </div>
            </div>

            <div class="col-md-8">
                <div class="card p-3">
                    <h5>Quick Links</h5>
                    <ul class="list-group">
                        <li class="list-group-item"><a href="vehicles.jsp">Manage Vehicles</a></li>
                        <li class="list-group-item"><a href="users.jsp">Manage Users</a></li>
                        <li class="list-group-item"><a href="settings.jsp">Settings</a></li>
                    </ul>
                </div>
            </div>
        </div>

        <div class="text-center mt-4">
<a href="<%= request.getContextPath() %>/auth/logout" class="btn btn-danger">Logout</a>

        </div>
    </div>
</div>

</body>
</html>
