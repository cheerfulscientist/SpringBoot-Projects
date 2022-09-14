package example1.todo.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	private AuthenticationService auth;
	
	public LoginController(AuthenticationService auth) {
		super();
		this.auth = auth;
	}
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String gotoLogin()
	{
		return "login";
	}
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String gotowelcome(@RequestParam String name,@RequestParam String password, ModelMap model)
	{
		if(auth.authentication(name, password))
		{
		model.addAttribute("name", name);
		model.addAttribute("password", password);
		return "welcome";
		}
		model.addAttribute("errormsg", "Invalid Creddentials !! Please try again later.");
		return "login";
	}
}
