package mx.com.semarnat.users.Controlers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //Steretoype
@RequestMapping ("/hello")
public class Controller {
	@GetMapping
	public String helloWorld() {
		return "¡ Hello world! ";
	}

}
