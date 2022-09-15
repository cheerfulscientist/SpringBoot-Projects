package example1.todo;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;


@Service
public class TodoService {
	
	private static int todoCount=0;
	private static List<Todo> todos = new ArrayList<>();
	static {
		todos.add(new Todo(++todoCount,"racz","Learn Azure Fundamentals",LocalDate.now().plusDays(7),false));
		todos.add(new Todo(++todoCount,"racz","Learn Azure AI Fundamentals",LocalDate.now().plusDays(14),false));
		todos.add(new Todo(++todoCount,"racz","Learn Azure Data Fundamentals",LocalDate.now().plusDays(21),false));
	}
	
	public List<Todo> findbyusername(String username)
	{
		return todos;
	}
	
	public 	void addTodo(String username, String description,LocalDate date, boolean done)
	{
		Todo todo = new Todo(++todoCount,username,description,date,done);
		todos.add(todo);
	}
	
	public void deleteById(int id)
	{
		Predicate<? super Todo>predicate=todo -> todo.getId()==id;
		todos.removeIf(predicate);
	}
}
