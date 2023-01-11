
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet">
<title>Add Todos Page</title>
</head>

<body>
	<div class="container">
		<h1>Enter Todo Details</h1>
		<form method = "post">
			<label for = "description">Description: </label>
			<input type = "text" id = "text" name = "description">
			<input type = "submit" class = "btn btn-success" value = "Add Todo">
		</form>
	</div>

	<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
	<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>

</html>