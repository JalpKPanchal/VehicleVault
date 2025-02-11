<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Reset Password - VehicleVault</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body class="bg-light">

<div class="container d-flex justify-content-center align-items-center min-vh-100">
    <div class="card p-4 shadow-lg" style="max-width: 400px; width: 100%;">
        <h3 class="text-center text-primary">Reset Password</h3>
        <p class="text-center text-muted">Enter the OTP sent to your email along with your new password.</p>

        <% String error = request.getParameter("error"); %>
        <% if (error != null) { %>
            <div class="alert alert-danger">
                <%= error %>
            </div>
        <% } %>

        <form action="reset-password" method="post" onsubmit="return validateForm()">
            <input type="hidden" name="email" value="${email}">

            <div class="mb-3">
                <label>Enter OTP</label>
                <input type="text" id="otp" name="otp" class="form-control" required>
            </div>

            <div class="mb-3">
                <label>New Password</label>
                <input type="password" id="password" name="newPassword" class="form-control" required>
            </div>

            <div class="mb-3">
                <label>Confirm New Password</label>
                <input type="password" id="confirmPassword" class="form-control" required>
            </div>

            <button type="submit" class="btn btn-primary w-100">Reset Password</button>
        </form>

        <div class="text-center mt-3">
            <a href="<%= request.getContextPath() %>/auth/login" class="text-decoration-none">Back to Login</a>
        </div>
    </div>
</div>

<script>
function validateForm() {
    let otp = document.getElementById("otp").value.trim();
    let password = document.getElementById("password").value;
    let confirmPassword = document.getElementById("confirmPassword").value;
    
    if (otp === "") {
        alert("Please enter the OTP.");
        return false;
    }
    
    if (password !== confirmPassword) {
        alert("Passwords do not match!");
        return false;
    }
    
    return true;
}
</script>

</body>
</html>
