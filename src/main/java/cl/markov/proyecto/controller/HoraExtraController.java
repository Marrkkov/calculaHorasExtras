package cl.markov.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cl.markov.proyecto.model.entity.HoraExtra;
import cl.markov.proyecto.model.entity.Usuario;
import cl.markov.proyecto.service.HoraExtraService;
import cl.markov.proyecto.service.UsuarioService;

public class HoraExtraController {
	
	@Controller
	@RequestMapping(value = "/horaExtra")
	public class UsuarioController {

	    @Autowired
	    private HoraExtraService servicio;
	    
	    @GetMapping
	    public String home(
	        @ModelAttribute("mensaje") String mensaje, 
	        ModelMap mapa
	    ) {
	        System.out.println("mensaje:" + mensaje);
	        if(mensaje != null)
	            mapa.put("mensaje", mensaje);
	        mapa.put("horaExtra", servicio.llenarHorasExtras());

	        return "admin/admin";
	    }
	    
	    @PostMapping("/actualizar")
	    public String actualizar(
	        ModelMap mapa,
	        RedirectAttributes atributos,
	        @ModelAttribute Usuario usuario) {
	        
	          //  servicio.modificarUsuario(usuario);
	        
	        atributos.addFlashAttribute("mensaje", "Usuario actualizado");
	        
	        return "redirect:/horaExtra";
	    }

	    @PostMapping
	    public String ingresar(
	        RedirectAttributes atributos,
	        @ModelAttribute HoraExtra horaExtra) {
	        HoraExtra Horarespuesta = servicio.agregarHoraExtra(horaExtra); 
	     
	        
	        atributos.addFlashAttribute(
	            "mensaje", 
	            "Usuario: " 
	           // + Usuariorespuesta.getRut()
	            + "fecha: "
	            + Horarespuesta.getFecha()
	            + ", ingresado."
	        );

	        return "redirect:/horaExtra";
	    }

	    @GetMapping(value = "/eliminar")
	    public String eliminar(
	        @RequestParam Integer id, 
	        RedirectAttributes atributos) {
	      //  Usuario usuario = servicio.buscar(id);
	      // servicio.eliminarUsuario(usuario);
	       // String mensaje = "Usuario: " + usuario.getRut() + " eliminado";
	      //  atributos.addFlashAttribute("mensaje", mensaje);

	        return "redirect:/usuarios";
	    }
	    
	}
}