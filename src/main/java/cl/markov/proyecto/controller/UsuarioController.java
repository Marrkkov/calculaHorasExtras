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

import cl.markov.proyecto.model.entity.Usuario;
import cl.markov.proyecto.service.UsuarioService;

@Controller
@RequestMapping(value = "/usuarios")
public class UsuarioController {

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

        return "admin/admin";
    }
    
    @PostMapping("/actualizar")
    public String actualizar(
        ModelMap mapa,
        RedirectAttributes atributos,
        @ModelAttribute Usuario usuario) {
        
            servicio.modificarUsuario(usuario);
        
        atributos.addFlashAttribute("mensaje", "Usuario actualizado");
        
        return "redirect:/usuarios";
    }

    @PostMapping
    public String ingresar(
        RedirectAttributes atributos,
        @ModelAttribute Usuario usuario) {
        Usuario Usuariorespuesta = servicio.registrarUsuario(usuario); 
        
        atributos.addFlashAttribute(
            "mensaje", 
            "Usuario: " 
            + Usuariorespuesta.getRut()
            + ", ingresado."
        );

        return "redirect:/usuarios";
    }

    @GetMapping(value = "/eliminar")
    public String eliminar(
        @RequestParam Integer id, 
        RedirectAttributes atributos) {
        Usuario usuario = servicio.buscar(id);
        servicio.eliminarUsuario(usuario);
        String mensaje = "Usuario: " + usuario.getRut() + " eliminado";
        atributos.addFlashAttribute("mensaje", mensaje);

        return "redirect:/usuarios";
    }
    
}
