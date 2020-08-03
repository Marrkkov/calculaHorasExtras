package cl.markov.proyecto.model.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.markov.proyecto.model.entity.Usuario;

public interface UsuarioDao extends JpaRepository<Usuario, Integer>{
    Optional<Usuario> findByRut(String rut);
    Optional<Usuario> findByCorreo(String correo);
}
