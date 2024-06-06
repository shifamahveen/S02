<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "https://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>First JSP</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
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
	
	<section class="border border-secondary p-4 w-50 mx-auto my-5 shadow rounded" >
		<h1>Trigonometry Calculator</h1>
		
		<form action="calculate" method="POST">
			<div class="mb-3">
			    <label class="form-label">Angle</label>
			    <input type="text" class="form-control" name="angle" required>
			</div>
			<div class="mb-3">
			    <select class="form-control" name="func">
			    	<option value="sin">sin</option>
			    	<option value="cos">cos</option>
			    	<option value="tan">tan</option>
			    	<option value="sec">sec</option>
			    	<option value="cosec">cosec</option>
			    	<option value="cot">cot</option>
			    </select>
			</div>
			  
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</section>
	

</body>
</html>