<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index Page</title>

<%@include file="components/allCss.jsp"%>
</head>
<body>
	<%-- Navbar --%>
	<%@include file="components/navbar.jsp"%>

	<%-- Carousel --%>

	<div id="carouselExampleIndicators" class="carousel slide"
		data-bs-ride="carousel">
		<div class="carousel-indicators">
			<button type="button" data-bs-target="#carouselExampleIndicators"
				data-bs-slide-to="0" class="active" aria-current="true"
				aria-label="Slide 1"></button>
			<button type="button" data-bs-target="#carouselExampleIndicators"
				data-bs-slide-to="1" aria-label="Slide 2"></button>
			<button type="button" data-bs-target="#carouselExampleIndicators"
				data-bs-slide-to="2" aria-label="Slide 3"></button>
		</div>
		<div class="carousel-inner">
			<div class="carousel-item active" data-bs-interval="3000">
				<img src="img/doc1.jpg" class="d-block w-100" alt="..." height="530px">
			</div>
			<div class="carousel-item" data-bs-interval="3000">
				<img src="img/doc2.jpg" class="d-block w-100" alt="..." height="530px">
			</div>
			<div class="carousel-item" data-bs-interval="3000">
				<img src="img/doc3.jpg" class="d-block w-100" alt="..." height="530px">
			</div>
		</div>
		<button class="carousel-control-prev" type="button"
			data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
			<span class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Previous</span>
		</button>
		<button class="carousel-control-next" type="button"
			data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
			<span class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Next</span>
		</button>
	</div>
	
	<%-- Key Features --%>
	
	<div class="container p-3">
		<p class="text-center fs-2"> Key Features of Our Hospital</p>
		<div class="row">
			<div class="col-md-8 pt-5">
				<div class="row">
					<div class="col-md-6">
						<div class="card paint-card shadow">
							<div class="card-body">
								<p class="fs-5">100% Safety</p>
								<p>lorem ipsum dolor sit amet, consecteur adipscing elit.
									Voluptatemt, inventore</p>
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="card paint-card shadow">
							<div class="card-body">
								<p class="fs-5">Clean Environments</p>
								<p>lorem ipsum dolor sit amet, consecteur adipscing elit.
									Voluptatemt, inventore</p>
							</div>
						</div>
					</div>
					<div class="col-md-6 mt-2">
						<div class="card  shadow">
							<div class="card-body">
								<p class="fs-5">Friendly Doctors</p>
								<p>lorem ipsum dolor sit amet, consecteur adipscing elit.
									Voluptatemt, inventore</p>
							</div>
						</div>
					</div>
					<div class="col-md-6 mt-2">
						<div class="card  shadow">
							<div class="card-body">
								<p class="fs-5">Medical Research</p>
								<p>lorem ipsum dolor sit amet, consecteur adipscing elit.
									Voluptatemt, inventore</p>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-4 p-4">
				<img alt="" src="img/doc5.png" width="100%" height="87%"/>
			</div>
		</div>
	</div>
	<hr/>
	
	<%-- Our Team --%>
	<div class="container p-4">
		<p class="text-center fs-2 mb-5"> OUR TEAM </p>
		<div class="row">
			<div class="col-md-3">
				<div class="card shadow border-0 rounded ">
					<div class="card-body text-center border-0">
						 <img src="img/doc6.png" class="rounded" width="220px" height="300px"/>
						 <p class="fw-bold fs-5">Dr Woong</p>
						 <p class="fs-7">(CEO & CHAIRMAN)</p>
					</div>
				</div>
			</div>
			<div class="col-md-3">
				<div class="card shadow border-0 rounded ">
					<div class="card-body text-center border-0">
						 <img src="img/doc7.png" class="rounded" width="220px" height="300px"/>
						 <p class="fw-bold fs-5">Dr Angelina</p>
						 <p class="fs-7">(Chief Doctor)</p>
					</div>
				</div>
			</div>
			<div class="col-md-3">
				<div class="card shadow border-0 rounded ">
					<div class="card-body text-center border-0">
						 <img src="img/doc5.png" class="rounded" width="220px" height="300px"/>
						 <p class="fw-bold fs-5">Dr Samuel</p>
						 <p class="fs-7">(Chief Doctor)</p>
					</div>
				</div>
			</div>
			<div class="col-md-3">
				<div class="card shadow border-0 rounded ">
					<div class="card-body text-center border-0">
						 <img src="img/doc8.png" class="rounded" width="220px" height="300px"/>
						 <p class="fw-bold fs-5">Dr Swan</p>
						 <p class="fs-7">(Chief Doctor)</p>
					</div>
				</div>
			</div>
			
		</div>
	</div>
	<%@include file="components/footer.jsp" %>

</body>
</html>