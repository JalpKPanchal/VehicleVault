<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login | VehicleVault</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <style>
        body {
            background-color: #1e1e2f;
            color: white;
        }
        .container {
            max-width: 400px;
            background: #28293d;
            padding: 20px;
            border-radius: 8px;
            margin-top: 50px;
        }
        input, button {
            border-radius: 5px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2 class="text-center">Login</h2>
        <% if(request.getAttribute("error") != null) { %>
            <div class="alert alert-danger"><%= request.getAttribute("error") %></div>
        <% } %>
        <form action="login" method="post">
            <div class="mb-3">
                <label>Email</label>
                <input type="email" name="email" class="form-control" required>
            </div>

            <div class="mb-3">
                <label>Password</label>
                <input type="password" name="password" class="form-control" required>
            </div>

            <button type="submit" class="btn btn-primary w-100">Login</button>

            <div class="text-center mt-3">
				<a href="forgot-password" class="text-light">Forgot Password?</a>
                <a href="Signup.jsp" class="text-light">Sign Up</a>
            </div>
        </form>
    </div>
</body>
</html>
