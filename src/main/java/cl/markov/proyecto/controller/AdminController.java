package cl.markov.proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")

public class AdminController {

	 @GetMapping
	    public String index() {
	        String vista = "admin/admin";
	        return vista;
	    }
}