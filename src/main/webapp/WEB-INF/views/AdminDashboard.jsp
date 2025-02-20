<%@ include file="header.jsp" %>
<div class="container-fluid">
    <div class="row">
        <!-- Sidebar -->
        <nav class="col-md-3 col-lg-2 d-md-block bg-light sidebar">
            <div class="position-sticky pt-3">
                <ul class="nav flex-column">
                    <li class="nav-item">
                        <a class="nav-link active" href="#">Dashboard</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="UserList.jsp">Manage Users</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="CarList.jsp">Manage Cars</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="InsuranceList.jsp">Manage Insurance</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="ReviewList.jsp">Reviews</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-danger" href="logout.jsp">Logout</a>
                    </li>
                </ul>
            </div>
        </nav>

        <!-- Main Content -->
        <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
            <h2 class="mt-4">Admin Dashboard</h2>
            <div class="row">
                <div class="col-md-4">
                    <div class="card text-white bg-primary mb-3">
                        <div class="card-body">
                            <h5 class="card-title">Total Users</h5>
                            <p class="card-text">120</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="card text-white bg-success mb-3">
                        <div class="card-body">
                            <h5 class="card-title">Total Cars</h5>
                            <p class="card-text">340</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="card text-white bg-warning mb-3">
                        <div class="card-body">
                            <h5 class="card-title">Pending Inquiries</h5>
                            <p class="card-text">15</p>
                        </div>
                    </div>
                </div>
            </div>
        </main>
    </div>
</div>
<%@ include file="footer.jsp" %>
