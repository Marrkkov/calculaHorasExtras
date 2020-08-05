package cl.markov.proyecto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import cl.markov.proyecto.model.entity.Rol;
import cl.markov.proyecto.model.entity.Usuario;
import cl.markov.proyecto.service.UsuarioService;

@SpringBootApplication
public class CalculaHorasExtrasApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalculaHorasExtrasApplication.class, args);
	}

}

@Component
class AppStartupRunner implements ApplicationRunner {

    @Autowired
    private UsuarioService servicioUsuario;
    
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Usuario usuario = new Usuario();
        usuario.setNombre("administrador");
        usuario.setCorreo("admin@mail.cl");
        usuario.setContrasenia("1234");
        usuario.setRol(Rol.ROLE_ADMIN);
        
        servicioUsuario.registrarUsuario(usuario);
        

    	}
 }
