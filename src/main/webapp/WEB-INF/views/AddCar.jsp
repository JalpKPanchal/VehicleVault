<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Car</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h2>Add Car</h2>
        <form action="save" method="post">
            <div class="mb-3">
                <label>Make:</label>
                <input type="text" name="make" class="form-control" required>
            </div>
            <div class="mb-3">
                <label>Model:</label>
                <input type="text" name="model" class="form-control" required>
            </div>
            <div class="mb-3">
                <label>Year:</label>
                <input type="number" name="year" class="form-control" required>
            </div>
            <div class="mb-3">
                <label>Variant:</label>
                <input type="text" name="variant" class="form-control">
            </div>
            <div class="mb-3">
                <label>Mileage:</label>
                <input type="number" step="0.1" name="mileage" class="form-control">
            </div>
            <div class="mb-3">
                <label>Fuel Type:</label>
                <input type="text" name="fuelType" class="form-control" required>
            </div>
            <div class="mb-3">
                <label>Transmission Type:</label>
                <input type="text" name="transmissionType" class="form-control" required>
            </div>
            <div class="mb-3">
                <label>Price:</label>
                <input type="number" step="0.01" name="price" class="form-control" required>
            </div>
            <div class="mb-3">
                <label>Color:</label>
                <input type="text" name="color" class="form-control">
            </div>
            <div class="mb-3">
                <label>Description:</label>
                <textarea name="description" class="form-control"></textarea>
            </div>
            <div class="mb-3">
                <label>Status:</label>
                <input type="text" name="status" class="form-control" required>
            </div>
            <div class="mb-3">
                <label>Registration Number:</label>
                <input type="text" name="registrationNum" class="form-control" required>
            </div>
            <div class="mb-3">
                <label>Registration Year:</label>
                <input type="number" name="registrationYear" class="form-control">
            </div>
            <div class="mb-3">
                <label>Seats:</label>
                <input type="number" name="seats" class="form-control">
            </div>
            <div class="mb-3">
                <label>Kms Driven:</label>
                <input type="number" name="kmsDriven" class="form-control">
            </div>
            <div class="mb-3">
                <label>Insurance:</label>
                <input type="text" name="insurance" class="form-control">
            </div>
            <div class="mb-3">
                <label>Ownership:</label>
                <input type="text" name="ownership" class="form-control">
            </div>
            <button type="submit" class="btn btn-primary">Add Car</button>
        </form>
    </div>
</body>
</html>
