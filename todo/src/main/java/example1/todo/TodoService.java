package example1.todo;

import java.time.LocalDate;
import java.util.*;

import org.springframework.stereotype.Service;


@Service
public class TodoService {
	
	private static List<Todo> todos = new ArrayList<>();
	static {
		todos.add(new Todo(1,"racz","Learn Azure Fundamentals",LocalDate.now().plusDays(7),false));
		todos.add(new Todo(1,"racz","Learn Azure AI Fundamentals",LocalDate.now().plusDays(7),false));
		todos.add(new Todo(1,"racz","Learn Azure Data Fundamentals",LocalDate.now().plusDays(7),false));
	}
	
	public List<Todo> findbyusername(String username)
	{
		return todos;
	}
}
