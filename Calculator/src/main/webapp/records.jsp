<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "https://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>First JSP</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
</head>
<body>
	<nav class="navbar navbar-expand-lg bg-body-tertiary">
	  <div class="container">
	    <a class="navbar-brand" href="#">Trig</a>
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    <div class="collapse navbar-collapse" id="navbarNav">
	      <ul class="navbar-nav">
	        <li class="nav-item">
	          <a class="nav-link active" aria-current="page" href="/">Home</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="records">Records</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="logout">Logout</a>
	        </li>
	      </ul>
	    </div>
	  </div>
	</nav>

	<section class="border border-secondary p-4 mx-auto my-5 shadow rounded" style="width: 60vw;">
	
		<div class="d-flex justify-content-between">
			<h2> Trigonometry Records </h2>
			<a href="/" class="btn btn-success py-auto">Create Record </a>
		</div>		
		
		<section class="d-flex justify-content-between">
			<table class="table my-2 mt-4" style="width: 40vw">
				<tr>
					<th>ID</th>
					<th>Angle</th>
					<th>Function</th>
					<th>Result</th>
					<th>Delete</th>
					<th>Edit</th>
				</tr>
				
				<c:forEach items="${records}" var="record">
					<tr>
						<td>${record.id}</td>
						<td>${record.angle}</td>
						<td>${record.func}</td>
						<td>${record.result}</td>
						<td>
							<form action="delete/${record.id}" method="POST">
								<input type="hidden" name="_method" value="DELETE" />
								<button type="submit" class="btn btn-danger">Delete</button>
							</form>
						</td>
						<td>
							<a href="/edit?id=${record.id}" class="btn btn-info">Edit</a>
						</td>
					</tr>		
				</c:forEach>
				
			</table>
			
			<div class="mt-4 ms-4">
				<h4>Tools </h4>
				
				<form action="sort" method="get">
					<label class="form-label">Sort</label>
					<div  class="d-flex">
						<select name="sortBy" class="form-select rounded-0 rounded-start">
							<option value="asc">Ascending</option>
							<option value="desc">Descending</option>
						</select>
						<button type="submit" class="btn btn-primary rounded-0 rounded-end">Sort</button>
					</div>
				</form>
				
				<form action="search" method="get">
					<label class="form-label"> Search</label>
					
					<div class="d-flex">
						<input type="text" name="searchValue" placeholder="Search here..." class="form-control rounded-0 rounded-start" />
						<button type="submit" class="btn btn-primary rounded-0 rounded-end">Search</button>
					</div>
				</form>
				
			</div>
		</section>
		
		
		
	</section>
	
	
</body>
</html>