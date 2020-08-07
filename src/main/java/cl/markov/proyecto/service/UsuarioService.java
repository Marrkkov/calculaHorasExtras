package cl.markov.proyecto.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import cl.markov.proyecto.model.dao.UsuarioDao;
import cl.markov.proyecto.model.entity.Rol;
import cl.markov.proyecto.model.entity.Usuario;

@Service
public class UsuarioService {

	private Logger logger = LoggerFactory.getLogger(UsuarioService.class);

	@Autowired
	private UsuarioDao dao;

	public Usuario registrarUsuario(Usuario usuario) {

		Usuario usuarioEnBase = dao.findByRut(usuario.getRut()).orElse(null);

		if (usuarioEnBase != null) {

			logger.warn("El usuario que desea ingresar ya existe");
		} else {

			dao.save(usuario);
		}

		return usuario;
	}

	public List<Usuario> llenarUsuarios() {

		return dao.findAll();
	}

	public Usuario eliminarUsuario(Usuario usuario) {

		dao.delete(usuario);

		return usuario;
	}

	public Usuario modificarUsuario(Usuario usuario) {

		return dao.save(usuario);
	}

	public Usuario crearAdministrador(Usuario usuario) {

		Usuario usuarioEnBase = dao.findByCorreo(usuario.getCorreo()).orElse(null);

		if (usuarioEnBase != null) {
			logger.warn("El usuario que desea ingresar ya existe");
		} else {
			usuario.setRol(Rol.ROLE_ADMIN);

			dao.save(usuario);
		}

		return usuario;
	}

	public Usuario buscar(Integer id) {
		return dao.findById(id).orElse(null);
	
	}

}