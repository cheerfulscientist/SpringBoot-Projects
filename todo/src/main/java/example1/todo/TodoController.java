package example1.todo;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
