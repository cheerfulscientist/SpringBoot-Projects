<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<html>
<body>
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
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${todos}" var="todo">
		<tr>
			<td>${todo.id}</td>
			<td>${todo.description}</td>
			<td>${todo.date}</td>
			<td>${todo.done}</td>
		</tr>
		</c:forEach>
	</tbody>
</table>
</div>
</body>
</html>