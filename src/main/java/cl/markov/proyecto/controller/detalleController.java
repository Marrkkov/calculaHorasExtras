package cl.markov.proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/detalle")
public class detalleController {

	 @GetMapping
	    public String index() {
	        String vista = "trabajadores/detalle";
	        return vista;
	    }
}
