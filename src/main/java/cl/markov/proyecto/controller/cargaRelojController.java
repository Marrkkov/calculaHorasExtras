package cl.markov.proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cargaReloj")

public class cargaRelojController {

	 @GetMapping
	    public String index() {
	        String vista = "admin/cargaReloj";
	        return vista;
	    }
}