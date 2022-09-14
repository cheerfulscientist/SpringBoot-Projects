package example1.todo.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	
	public boolean authentication(String username,String password)
	{
		 boolean isvalidusername = username.equalsIgnoreCase("racz");
		 boolean isvalidpassword = password.equalsIgnoreCase("pass");
		return isvalidusername && isvalidpassword;
	}
}
