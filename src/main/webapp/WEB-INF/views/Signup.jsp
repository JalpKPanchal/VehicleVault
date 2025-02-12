<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Signup | VehicleVault</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <style>
        body {
            background-color: #1e1e2f;
            color: white;
        }
        .container {
            max-width: 500px;
            background: #28293d;
            padding: 20px;
            border-radius: 8px;
            margin-top: 50px;
        }
        input, select, button {
            border-radius: 5px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2 class="text-center">Create an Account</h2>
        <form action="signup" method="post" onsubmit="return validateForm()">
            <div class="mb-3">
                <label>First Name</label>
                <input type="text" name="firstName" class="form-control" required>
            </div>

            <div class="mb-3">
                <label>Last Name</label>
                <input type="text" name="lastName" class="form-control" required>
            </div>

            <div class="mb-3">
                <label>Email</label>
                <input type="email" name="email" class="form-control" required>
            </div>

            <div class="mb-3">
                <label>Password</label>
                <input type="password" id="password" name="password" class="form-control" required>
            </div>

            <div class="mb-3">
                <label>Confirm Password</label>
                <input type="password" id="confirmPassword" class="form-control" required>
            </div>

            <div class="mb-3">
                <label>Contact Number</label>
                <input type="text" name="contactNum" class="form-control" required>
            </div>

            <div class="mb-3">
                <label>Gender</label>
                <select name="gender" class="form-control">
                    <option value="Male">Male</option>
                    <option value="Female">Female</option>
                    <option value="Other">Other</option>
                </select>
            </div>

            <button type="submit" class="btn btn-primary w-100">Sign Up</button>
            <div class="text-center mt-3">
                <a href="Login.jsp" class="text-light">Already have an account? Login</a>
            </div>
        </form>
    </div>

    <script>
        function validateForm() {
            let password = document.getElementById("password").value;
            let confirmPassword = document.getElementById("confirmPassword").value;

            if (password !== confirmPassword) {
                alert("Passwords do not match!");
                return false;
            }
            return true;
        }
    </script>
</body>
</html>
