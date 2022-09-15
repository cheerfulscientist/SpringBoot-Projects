<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
	<head>
		<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
	</head>
	<div class="container">
	<body>
		<h2>Enter new todo details here :</h2>
		<form:form method="post" modelAttribute="todo">
			Add Description : <form:input type="text" name="description" required="required" path="description"/>
							<form:errors  path="description" cssClass="text-warning"/>
							<form:input type="hidden"   path="id"/>
							<form:input type="hidden"   path="done"/>
			
			<input type="submit" class="btn btn-success"/>
		</form:form>
		<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
		<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
	</body>
	</div>
</html>