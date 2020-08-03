package cl.markov.proyecto.model.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.markov.proyecto.model.entity.HoraExtra;

public interface HoraExtraDao extends JpaRepository<HoraExtra, Integer>{
    Optional<HoraExtra> findByFecha(String fecha);
}
