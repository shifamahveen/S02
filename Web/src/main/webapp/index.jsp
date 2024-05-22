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
	<h1>Enter Details</h1>
	
	<form action="submitForm" method="POST">
		<label class="text-primary">A</label>
		<input type="text" placeholder="Enter A value" class="form-control" name="a" />
		
		<label class="text-primary">B</label>
		<input type="text" placeholder="Enter B value" class="form-control" name="b" />
		
		<label class="text-primary">Opr</label>
		<select class="form-control" name="opr">
			<option value="add">+</option>
			<option value="sub">-</option>
			<option value="mul">*</option>
			<option value="div">/</option>
		</select>
		
		<br>
		<button type="submit" class="btn btn-success">Submit</button>
	</form>

</body>
</html>