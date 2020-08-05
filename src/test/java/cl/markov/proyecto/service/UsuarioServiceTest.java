package cl.markov.proyecto.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import cl.markov.proyecto.model.entity.Usuario;

@SpringBootTest
public class UsuarioServiceTest {

	@Autowired UsuarioService servicio;
	
	@Test
	public void registrarUsuario(Usuario usuario) {
		//Crea Usuario, lo carga en la base de datos y retorne el usuario creado.
		assertTrue(true);
	}
	
	@Test 
	public void eliminarUsuario() {
		//Elimina un usuario, busca usuario con rut eliminado y no debe encontrar nada.
		assertTrue(true);
	}
	
	@Test 
	public void llenarUsuarios() {
		//debe traer la lista de todos los usuarios y mostrarla
		assertTrue(true);
	}
	
	@Test
	public void modificarUsuario() {
	//debe modificar un usuario, eliminando el dato que existia antes y luego al ser consultado
		//mostrar los nuevos datos ingresados
		
		assertTrue(true); 
	}
	
	@Test
	public void crearAdministrador() {
	//crea un usuario con rol administrador, checkea el rol del usuario creado, debe ser rol admin.	
	}
}
	