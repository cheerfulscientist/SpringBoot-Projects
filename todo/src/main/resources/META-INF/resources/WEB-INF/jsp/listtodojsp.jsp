<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<html>
<head>
	<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
<h2>LIST OF ALL TODOS</h2>
Your are ${name} and following are your todos:
<div>
<table>
	<thead>
		<tr>
			<th>Todo Id</th>
			<th>Description of Task</th>
			<th>Deadline</th>
			<th>Status is done ?</th>
			<th></th>	
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${todos}" var="todo">
		<tr>
			<td>${todo.id}</td>
			<td>${todo.description}</td>
			<td>${todo.date}</td>
			<td>${todo.done}</td>
			<td> <a href="deletetodo?id=${todo.id}" class="btn btn-warning">DELETE ${todo.id}</td>
		</tr>
		</c:forEach>
	</tbody>
</table>

<a href="addtodos" class="btn btn-success">Add Todo</a>
</div>

<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</div>
</body>
</html>