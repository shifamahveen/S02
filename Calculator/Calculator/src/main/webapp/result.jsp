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

	<section class="border border-secondary p-4 w-50 mx-auto my-5 shadow rounded text-center">
		<p> The trigonometric value of ${func}(${angle}) is: <b>${result}</b> </p>
	
		<a href="/" class="btn btn-success">Back to Home</a>
		<a href="/records" class="btn btn-warning">View Logs</a>
	
	</section>
</body>
</html>