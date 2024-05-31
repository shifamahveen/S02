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
	<section class="border border-secondary p-4 w-50 mx-auto my-5 shadow rounded" >
		<h1>Trigonometry Calculator</h1>
		
		<form action="update" method="POST">
			<input type="hidden" class="form-control" name="id" value="${obj.id}" >
		
			<div class="mb-3">
			    <label class="form-label">Angle</label>
			    <input type="text" class="form-control" name="angle" value="${obj.angle}" >
			</div>
			<div class="mb-3">
			    <label class="form-label">Function</label>
			    <input type="text" class="form-control" name="func" value="${obj.func}" >
			</div>
			<div class="mb-3">
			    <label class="form-label">Result</label>
			    <input type="text" class="form-control" name="result" value="${obj.result}" >
			</div>
			
			<button type="submit" class="btn btn-primary">Update</button>
			
		</form>
	</section>
	

</body>
</html>