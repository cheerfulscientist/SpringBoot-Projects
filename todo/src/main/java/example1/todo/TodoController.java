package example1.todo;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class TodoController {
	
	private TodoService todoservice;
	public TodoController(TodoService todoservice) {
		super();
		this.todoservice = todoservice;
	}

	@RequestMapping("/listtodos")
	public String listalltodos(ModelMap model)
	
	{
		List<Todo> todos=todoservice.findbyusername("racz");
		model.addAttribute("todos",todos);
		return "listtodojsp";
	}
	
	@RequestMapping(value="/addtodos",method=RequestMethod.GET)
	public String gotonewtodoPage(ModelMap model)
	{
		String username=(String)model.get("name");
		Todo todo = new Todo(0,username,"DEFAULT DESC",LocalDate.now().plusDays(8),false);
		model.put("todo", todo);
		return "todo";
	}
	
	//Instead of binding parameters by req param to method , we use the class here itself in method(Object Backing Bean )
//	@RequestMapping(value="/addtodos",method=RequestMethod.POST)
//	public String showtodoPage(@RequestParam String description, ModelMap model)
//	{
//		String username=(String)model.get("name");
//		todoservice.addTodo(username, description, LocalDate.now().plusDays(45), false);
//		return "redirect:listtodos";
//	}
	
	@RequestMapping(value="/addtodos",method=RequestMethod.POST)
	public String showtodoPage(ModelMap model, @Valid Todo todo, BindingResult result)
	{
		if(result.hasErrors())
		{
			return "todo";
		}
		String username=(String)model.get("name");
		todoservice.addTodo(username, todo.getDescription(), LocalDate.now().plusDays(45), false);
		return "redirect:listtodos";
	}
	
	@RequestMapping("/deletetodo")
	public String deleteTodo(@RequestParam int id)
	
	{
		todoservice.deleteById(id);
		return "redirect:listtodos";
	}
	
	
}
