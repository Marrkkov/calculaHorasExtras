package cl.markov.proyecto.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cl.markov.proyecto.model.entity.Usuario;
import cl.markov.proyecto.service.UsuarioService;

@Controller
@RequestMapping(value = "/detalle")

public class detalleController {

    @Autowired
    private UsuarioService servicio;
    
    @GetMapping
    public String home(
        @ModelAttribute("mensaje") String mensaje, 
        ModelMap mapa
    ) {
        System.out.println("mensaje:" + mensaje);
        if(mensaje != null)
            mapa.put("mensaje", mensaje);
        mapa.put("usuarios", servicio.llenarUsuarios());

        return "/";
    }
	 
	 @PostMapping
	    public String buscar(
	        RedirectAttributes atributos,
	        @ModelAttribute Usuario usuario) {
		 
	        Usuario Usuariorespuesta = servicio.buscarRut(usuario).orElse(null); 
	        
	        if (Usuariorespuesta != null) {
	        	
	        	return "trabajadores/detalle";
	        	}
	               
	 		else {
	        
	        	atributos.addFlashAttribute(
	            "mensaje", 
	            "Rut no encontrado" 
	        			);
	        	return "redirect:/";
	 		}        
	 }
}