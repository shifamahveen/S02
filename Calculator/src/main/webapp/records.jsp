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

	<section class="border border-secondary p-4 w-50 mx-auto my-5 shadow rounded">
	
		<div class="d-flex justify-content-between">
			<h2> Trigonometry Records </h2>
			<a href="/" class="btn btn-success py-auto">Create Record </a>
		</div>		
		
		<table class="table my-2">
			<tr>
				<th>ID</th>
				<th>Angle</th>
				<th>Function</th>
				<th>Result</th>
			</tr>
			
			<c:forEach items="${records}" var="record">
				<tr>
					<td>${record.id}</td>
					<td>${record.angle}</td>
					<td>${record.func}</td>
					<td>${record.result}</td>
				</tr>		
			</c:forEach>
			
		</table>
	</section>
	
	
</body>
</html>