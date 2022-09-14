package example1.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
	public String gotonewtodoPage()
	{
		
		return "todo";
	}
	@RequestMapping(value="/addtodos",method=RequestMethod.POST)
	public String showtodoPage(@RequestParam String description, ModelMap model)
	{
		String username=(String)model.get("name");
		todoservice.addTodo(username, description, LocalDate.now().plusDays(45), false);
		return "redirect:listtodos";
	}
}
