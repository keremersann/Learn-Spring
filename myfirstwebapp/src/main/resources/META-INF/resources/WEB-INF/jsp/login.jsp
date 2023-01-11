<html>

<head>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet">
<title>Login Page</title>
</head>

<body>
	<div class="container">
		<h1>Welcome to Login Form</h1>
		<pre>${invalidLogin}</pre>
		<form method="post">
			<label for = "name">Name:</label>
			<input type = "text" name = "name" id = "name">
			<label for = "password">Password:</label>
			<input type = "password" name = "password" id = "password">
			<input type="submit">
		</form>
	</div>
	
	<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
	<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>

</html>