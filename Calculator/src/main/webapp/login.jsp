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
		<h1>Login to the Account</h1>
		
		<form action="login" method="POST">
			
			<div class="mb-3">
			    <label class="form-label">Email</label>
			    <input type="email" class="form-control" name="email" required>
			</div>
			
			<div class="mb-3">
			    <label class="form-label">Password</label>
			    <input type="password" class="form-control" name="password" required>
			</div>
			
			<button type="submit" class="btn btn-primary">Login</button>
		</form>
		
		<p class="text-secondary py-2"> Dont have an account? <a href="register" >Register Now!</a> </p>
	</section>
	

</body>
</html>