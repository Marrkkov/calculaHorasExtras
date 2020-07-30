package cl.markov.proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")

public class LoginController {

	 @GetMapping
	    public String index() {
	        String vista = "auth/login";
	        return vista;
	    }
}